package com.iboray.lms.userinterface.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;

import com.iboray.lms.application.service.DeptService;
import com.iboray.lms.application.service.PlanService;
import com.iboray.lms.application.service.UsecompService;
import com.iboray.lms.domain.entity.enums.BaseStateEnum;
import com.iboray.lms.domain.entity.enums.PlanStateEnum;
import com.iboray.lms.domain.entity.enums.UserDataRoleEnum;
import com.iboray.lms.domain.vo.DeptVO;
import com.iboray.lms.domain.vo.PlanImportErrorVO;
import com.iboray.lms.domain.vo.PlanVO;
import com.iboray.lms.domain.vo.UsecompVO;
import com.iboray.lms.domain.vo.UserVO;
import com.iboray.lms.infrastructure.utils.ExcelRead;
import com.iboray.lms.infrastructure.utils.ExcelRead2010;
import com.iboray.lms.infrastructure.utils.FileUpload;
import com.iboray.lms.infrastructure.utils.JsonPojoMapper;
import com.iboray.lms.userinterface.common.Pager;

public class PlanImportServlet extends HttpServlet {
	
	Logger logger = Logger.getLogger(PlanImportServlet.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 8937312554564846784L;

	private PlanService planService;
	
	private UsecompService usecompService;
	
	private DeptService deptService;
	
	private Pager<UsecompVO> usecompPager;
	
	private List<DeptVO> deptList;
	
	private ExcelRead excelRead;
	
	private ExcelRead2010 excelReadx;
	
	public void setPlanService(PlanService planService) {
		this.planService = planService;
	}
	
	public void setExcelRead(ExcelRead excelRead) {
		this.excelRead = excelRead;
	}
	

	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

	public void setUsecompService(UsecompService usecompService) {
		this.usecompService = usecompService;
	}

	public void setExcelReadx(ExcelRead2010 excelReadx) {
		this.excelReadx = excelReadx;
	}

	public PlanImportServlet(){
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");  
        PrintWriter out = response.getWriter();
        FileUpload fu=new FileUpload();  
        fu.setMap(request);//解析request  
        Map<String,FileItem> files=fu.getFiles(); 
        String fileName =fu.getFileName(files.get("file"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String path="page\\upload\\"+sdf.format(new Date())+fileName;
        String realPath = this.getServletContext().getRealPath("//page//upload//"+sdf.format(new Date())+fileName);
        String resourcePath = PlanImportServlet.class.getResource("/").getFile();
        File file=new File(realPath);
        try {
        	
            files.get("file").write(file);
        } catch (Exception e) {
            e.printStackTrace();  
        }
        List<PlanImportErrorVO> feedback =new ArrayList<PlanImportErrorVO>();
        NumberFormat nf=NumberFormat.getPercentInstance();
        try {
        	request.getSession().setAttribute("read", "开始导入计划#"+nf.format(0.6));
        	feedback = this.readPlanExcel(request, response, realPath);
        	if(feedback.size()>0){
        		String planErrorJsonStr = JsonPojoMapper.toJson(feedback, true);
        		request.getSession().setAttribute("planErrorJsonStr", planErrorJsonStr);
        		logger.info("PlanImportServlet@@@@@@@getAttribute@@@@@@@@"+request.getSession().getAttribute("planErrorJsonStr"));
        	}
		} catch (ParseException e) {
			e.printStackTrace();
		}
        if(file.exists()){
//        	file.delete();
		}
        
	}
	private List<PlanImportErrorVO> readPlanExcel(HttpServletRequest request, HttpServletResponse response,String path) throws ParseException{
		String ex = request.getParameter("ex");
		if(ex!=null&&ex.equals("xls")){
			excelRead.importExcel(path);
		}else if(ex!=null&&ex.equals("xlsx")){
			excelReadx.importExcel(path);
		}
		int rowcount=0;
		if(ex!=null&&ex.equals("xls")){
			 rowcount=excelRead.getRowIndex(0);
		}else if(ex!=null&&ex.equals("xlsx")){
			rowcount=excelReadx.getRowIndex(0);
		}
		int numb;
		List<PlanImportErrorVO> feedback =new ArrayList<PlanImportErrorVO>();
		List listuser = new ArrayList();
		List<List> lists = new ArrayList();
    	numb=rowcount;
    	usecompPager = usecompService.findAll(0, 0);
    	deptList = deptService.findAll();
    	  for (int i = 1; i <= rowcount; i++) {
    		  if(ex!=null&&ex.equals("xls")){
    			  listuser =  excelRead.readRow(0, i);
    			}else if(ex!=null&&ex.equals("xlsx")){
    				listuser = excelReadx.readRow(0, i);
    			}
    		  lists.add(listuser);
    		 
    		  @SuppressWarnings("unchecked")
			PlanImportErrorVO piev= this.isNumeric(listuser);
    		  boolean flag=false;
    		  if(piev!=null){
					flag=true;
    		  }
    		  
    		  if(flag){
    			  if(feedback.size()<21){
    				  piev.setErrorLineNo(String.valueOf(i+1));
    				  feedback.add(piev);
        		  }else{
        			  break;
        		  }
    		  }
    	  }
    	  UserVO user = (UserVO)request.getSession().getAttribute("user");
    	  if(feedback.size()!=0){
    		 return feedback;
    	  }else{
    		  NumberFormat nf=NumberFormat.getPercentInstance();
    		  for (int i = 1; i <= rowcount; i++) {
        		  
        		  PlanVO p=new PlanVO();
        		  Object result = null;
        		  SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMdd");
        		  SimpleDateFormat sdf1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy",Locale.ENGLISH);
        		  DecimalFormat df = new DecimalFormat("0"); 
        		  DecimalFormat df1 = new DecimalFormat("0.00000"); 
        		 
        		  for (int j = 0; j < lists.get(i-1).size(); j++) {
    	    			  if(lists.get(i-1).get(j)!=null){
    	    				  switch (j) {
    	    				  case 1: 
    	    					  String tempReceiptDate = lists.get(i-1).get(j).toString().trim();
    	    					  String receiptDate = tempReceiptDate.length()==8?sdf.format(sdf.parse(tempReceiptDate)).toString():sdf.format(sdf1.parse(tempReceiptDate)).toString();
    	    					  p.setReceiptdate(receiptDate);break;
    	    				  case 2: p.setCartcode(lists.get(i-1).get(j).toString().trim());break;
    	    				  case 3: p.setCartlinenum(Integer.parseInt(lists.get(i-1).get(j).toString().trim()));break;
    	    				  case 4: p.setOldplannum(lists.get(i-1).get(j).toString().trim());break;
    	    				  case 5: p.setOldplanlinenum(Integer.parseInt(lists.get(i-1).get(j).toString().trim()));break;
    	    				  case 6: p.setItemscode(lists.get(i-1).get(j).toString().trim());break;
    	    				  case 7: p.setItemsname((String)lists.get(i-1).get(j));break;
    	    				  case 8: p.setPlanprice(Double.parseDouble(lists.get(i-1).get(j).toString().trim()));break;
    	    				  case 9: p.setPlannum(Double.parseDouble(lists.get(i-1).get(j).toString().trim()));break;
    	    				  case 10: p.setUnit(lists.get(i-1).get(j).toString().trim());break;
    	    				  case 11: p.setPlanmoney(Double.parseDouble(lists.get(i-1).get(j).toString().trim()));break;
    	    				  case 12: 
    	    				  for(Iterator<DeptVO> it = deptList.iterator();it.hasNext();){
    	    					  DeptVO uv = it.next();
	    							if(uv.getDeptname().equals(lists.get(i-1).get(j).toString().trim())){
	    								p.setFkDeptno(uv.getDeptno());
	    								logger.info("uv.getDeptno()"+uv.getDeptno());
	    								break;
	    							}
	    					  }
	    					  break;
    	    				 //case 13: p.setFkUserno("20000001");break;
    	    				  case 14: 
    	    					  String temparrivaldate = lists.get(i-1).get(j).toString().trim();
    	    					  String arrivaldate = temparrivaldate.length()==8?sdf.format(sdf.parse(temparrivaldate)).toString():sdf.format(sdf1.parse(temparrivaldate)).toString();
    	    					  p.setArrivaldate(arrivaldate);break;
    	    				  case 15:
    	    					  for(Iterator<UsecompVO> it = usecompPager.getPageList().iterator();it.hasNext();){
    	    							UsecompVO uv = it.next();
    	    							if(uv.getUsecompname().equals(lists.get(i-1).get(j).toString().trim())){
    	    								p.setFkUsecompno(uv.getUsecompcode());
    	    								logger.info("uv.getUsecompname()"+uv.getUsecompname());
    	    								break;
    	    							}
    	    					  }
    	    					  break;
    	    				  case 16: p.setArrivaladdr(lists.get(i-1).get(j).toString().trim());break;
    	    				  }
    	    			  }else{
    	    				  continue;
    	    			  }
        		    }
        		  double nowcount = i;
        		  double totle = rowcount;
        		  double read = (nowcount/totle*0.4)+0.6;
        		  if(read>=0.99){
        			  read = 0.99;
        		  }
        		  request.getSession().setAttribute("read", "正在导入第 "+i+" 条计划#"+nf.format(read));
        		  PlanVO pv = new PlanVO();
        		  pv.setCartcode(p.getCartcode());
        		  pv.setCartlinenum(p.getCartlinenum());
        		  pv.setInvalid(String.valueOf(BaseStateEnum.VALID.getCode()));
        		  pv.setPlanstatus(String.valueOf(PlanStateEnum.UNCLAIMED.getCode()));
        		  user.setDatarole(UserDataRoleEnum.ALL.getCode());
        		  List<PlanVO> plist = planService.findByVO(pv,user);
        		  if(plist==null){
        			  planService.createPlan(p,user);
        		  }else if(plist.size()==1){
        			  p.setInvalid(String.valueOf(BaseStateEnum.VALID.getCode()));
            		  p.setPlanstatus(String.valueOf(PlanStateEnum.UNCLAIMED.getCode()));
        			  p.setPlanno(plist.get(0).getPlanno());
        			  planService.savePlan(p,false,user);
        		  }else{
        			  logger.info("====PlanImportErr====Plan:==Cartcode:"+p.getCartcode()+"    cartLineNum:"+p.getCartlinenum());
        		  }
        		 
        	  }
    		  request.getSession().setAttribute("read", "导入计划完成#"+nf.format(1));
    	  }
    	 
    	  return feedback;
	}
	public void init() throws ServletException {
	}
	
	/**
	 * 
	 * @param list
	 * @return 错误所在行号
	 */
	public  PlanImportErrorVO isNumeric(List<String> list){
		
		PlanImportErrorVO pie = null;
		for(int i=0;i<list.size();i++){
			switch(i){
			case 1:
				if(list.get(1)==null){
					if(pie == null ){
						pie = new PlanImportErrorVO();
					}
					pie.setCol1("为空值");
				}else if(!isNumeric1(list.get(1))){
					if(pie == null ){
						pie = new PlanImportErrorVO();
					}
					pie.setCol1("日期错误");
				}
			case 2:
				if(list.get(2)==null){
					if(pie == null ){
						pie = new PlanImportErrorVO();
					}
					pie.setCol2("为空值");
				}
			case 3:
				if(list.get(3)==null){
					if(pie == null ){
						pie = new PlanImportErrorVO();
					}
					pie.setCol3("为空值");
				}
//			case 4:
//				if(list.get(4)==null){
//					if(pie == null ){
//						pie = new PlanImportErrorVO();
//					}
//					pie.setCol4("为空值");
//				}
//			case 5:
//				if(list.get(5)==null){
//					if(pie == null ){
//						pie = new PlanImportErrorVO();
//					}
//					pie.setCol5("为空值");
//				}
			case 6:
				if(list.get(6)==null){
					if(pie == null ){
						pie = new PlanImportErrorVO();
					}
					pie.setCol6("为空值");
				}
			case 7:
				if(list.get(7)==null){
					if(pie == null ){
						pie = new PlanImportErrorVO();
					}
					pie.setCol7("为空值");
				}
			case 8:
				if(list.get(8)==null){
					if(pie == null ){
						pie = new PlanImportErrorVO();
					}
					pie.setCol8("为空值");
				}
			case 9:
				if(list.get(9)==null){
					if(pie == null ){
						pie = new PlanImportErrorVO();
					}
					pie.setCol9("为空值");
				}
			case 10:
				if(list.get(10)==null){
					if(pie == null ){
						pie = new PlanImportErrorVO();
					}
					pie.setCol10("为空值");
				}
			case 11:
				if(list.get(11)==null){
					if(pie == null ){
						pie = new PlanImportErrorVO();
					}
					pie.setCol11("为空值");
				}
			case 12:
				if(list.get(12)==null){
					if(pie == null ){
						pie = new PlanImportErrorVO();
					}
					pie.setCol12("为空值");
				}else{
					boolean ub = false;
					logger.info("deptList.size()"+deptList.size());
					for(Iterator<DeptVO> it = deptList.iterator();it.hasNext();){
						DeptVO uv = it.next();
						if(uv.getDeptname().equals(list.get(12).trim())){
							ub = true;
							break;
						}
					}
					if(!ub){
						if(pie == null ){
							pie = new PlanImportErrorVO();
						}
						pie.setCol12("无此部门");
					}
				}
//			case 13:
//				if(list.get(13)==null){
//					if(pie == null ){
//						pie = new PlanImportErrorVO();
//					}
//					pie.setCol13("为空值");
//				}
			case 14:
				if(list.get(14)==null){
					if(pie == null ){
						pie = new PlanImportErrorVO();
					}
					pie.setCol14("为空值");
				}
			case 15:
				if(list.get(15)==null){
					if(pie == null ){
						pie = new PlanImportErrorVO();
					}
					pie.setCol15("为空值");
				}else{
					boolean ub = false;
					logger.info("usecompPager.getPageList().size()"+usecompPager.getPageList().size());
					for(Iterator<UsecompVO> it = usecompPager.getPageList().iterator();it.hasNext();){
						UsecompVO uv = it.next();
						if(uv.getUsecompname().equals(list.get(15).trim())){
							ub = true;
							break;
						}
					}
					if(!ub){
						if(pie == null ){
							pie = new PlanImportErrorVO();
						}
						pie.setCol15("无此提报单位");
					}
				}
//			case 16:
//				if(list.get(16)==null){
//					if(pie == null ){
//						pie = new PlanImportErrorVO();
//					}
//					pie.setCol16("为空值");
//				}
			}
		}
		
		return pie; 
	}

	public  boolean isNumeric1(String str){
		try {
			DecimalFormat df = new DecimalFormat("0"); 
			double strd=Double.parseDouble(str);
			Pattern pattern = Pattern.compile("^\\d+$|\\d+\\.\\d+$"); 
			if(pattern.matcher(df.format(strd).toString()).matches()){
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
	public  boolean isDate(String str){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy",Locale.ENGLISH);
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
			Date d = null;
			if(str.trim().length() == 8 ){
				 d = sdf1.parse(str.trim());
			}
			return true;
		} catch (Exception e) {
			logger.error("import plans date format error  param[str]:"+str);
			return false;
		}
	}
	
}
