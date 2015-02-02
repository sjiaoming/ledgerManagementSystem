package com.iboray.lms.userinterface.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileUploadStatus  extends ActionSupport{
	
	Logger logger = Logger.getLogger(FileUploadStatus.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 5504981257838965977L;

	public String getUploadStatus() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setContentType("text/html;charset=utf-8");  
		PrintWriter out = response.getWriter();  
		HttpSession session=request.getSession();  
		String status=(String) session.getAttribute("read");//获取上传进度百分比 
		String planErrorJsonStr=(String)session.getAttribute("planErrorJsonStr");
		if(planErrorJsonStr!=null&&!planErrorJsonStr.equals("")){
			status = planErrorJsonStr;
		}
		System.out.println("getUploadStatus!!!!!!!!!!:"+status); 
		out.println(status);
		return null;
	}
	public String getPlanImportErrorInfo() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setContentType("text/html;charset=utf-8");  
		PrintWriter out = response.getWriter();  
		HttpSession session=request.getSession();  
		String planErrorJsonStr=(String)session.getAttribute("planErrorJsonStr");
		if(planErrorJsonStr!=null&&!planErrorJsonStr.equals("")){
			System.out.println("getPlanImportErrorInfo##########:"+planErrorJsonStr); 
			out.println(planErrorJsonStr);
			planErrorJsonStr="";
		}
		return null;
	}
	public String clearUploadStatus() throws Exception {
		System.out.println("进度已清除,clearUploadStatus");
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		response.setContentType("text/html;charset=utf-8");  
		HttpSession session=request.getSession();
		//String status=(String) session.getAttribute("read");//获取上传进度百分比 
 		session.removeAttribute("read");
    	session.removeAttribute("planErrorJsonStr");
		System.out.println("clearUploadStatus^^^getAttribute^^^^read^^^^^"+(String) session.getAttribute("read"));
		System.out.println("clearUploadStatus^^^getAttribute^^^^^planErrorJsonStr^^^^"+(String) session.getAttribute("planErrorJsonStr"));  
//		if(!StringUtils.isEmpty(status)){
//	    	String[] str = status.split("#");
//	    	try {
//	    		if(str.length==2){
//	    			if(str[1].equals("100%")){
//	    				session.setAttribute("read", "");
//	    				//System.out.println(status+"进度已清除,clearUploadStatus");
//	    			}
//	    		}
//	    	session.removeAttribute("read");
//	    	session.removeAttribute("planErrorJsonStr");
//			} catch (Exception e) {
//				e.printStackTrace();
//				logger.error("上传进度转换错误");
//			}
//		}
		return null;
	
	}
}
