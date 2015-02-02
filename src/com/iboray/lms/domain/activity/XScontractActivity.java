package com.iboray.lms.domain.activity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.dozer.Mapper;

import com.iboray.lms.domain.entity.Xscontract;
import com.iboray.lms.domain.entity.XscontractExample;
import com.iboray.lms.domain.entity.XscontractExample.Criteria;
import com.iboray.lms.domain.entity.enums.BaseStateEnum;
import com.iboray.lms.domain.entity.enums.JqGridOpEnum;
import com.iboray.lms.domain.entity.enums.PlanStateEnum;
import com.iboray.lms.domain.entity.enums.UserDataRoleEnum;
import com.iboray.lms.domain.vo.PlanVO;
import com.iboray.lms.domain.vo.UserVO;
import com.iboray.lms.domain.vo.XscontractVO;
import com.iboray.lms.infrastructure.dao.XscontractMapper;
import com.iboray.lms.infrastructure.utils.ArrayUtil;
import com.iboray.lms.infrastructure.utils.DateFormatUtil;
import com.iboray.lms.infrastructure.utils.KeyGenerator;
import com.iboray.lms.infrastructure.utils.UUIDHexGenerator;
import com.iboray.lms.userinterface.common.JqGridSearchTo;
import com.iboray.lms.userinterface.common.Pager;

public class XScontractActivity {

	static Logger logger = Logger.getLogger(XScontractActivity.class);
	
	private XscontractMapper xscontractMapper;
	
	private PlanActivity planActivity;
	
	private Mapper mapper ;


	public void setPlanActivity(PlanActivity planActivity) {
		this.planActivity = planActivity;
	}

	public void setXscontractMapper(XscontractMapper xscontractMapper) {
		this.xscontractMapper = xscontractMapper;
	}

	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}
	
	public XscontractVO findVOBYNo(String no){
		logger.info("XScontractActivity.findVOBYNo  no:"+no);
		if(StringUtils.isEmpty(no))
			return null;
		XscontractExample ue = new XscontractExample();
		ue.or().andXscontractnoEqualTo(no);
		Xscontract u = xscontractMapper.selectByNo(no);
		if(u==null)
			throw new RuntimeException("no is not find");
		return mapper.map(u, XscontractVO.class);
	}
	public int deleteByNos(String[] nos){
		Xscontract Xscontract = new Xscontract();
		Xscontract.setInvalid(String.valueOf(BaseStateEnum.DELETE.getCode()));
		XscontractExample ue = new XscontractExample();
		ue.or().andXscontractnoIn(ArrayUtil.Strs2List(nos));
		return xscontractMapper.updateByExampleSelective(Xscontract, ue);
	}
	public String create(XscontractVO urv,String[] planNos,PlanVO planvo){
		if(urv == null)
			return null;
		urv.setXscontractno(UUIDHexGenerator.generator());
		urv.setInvalid(String.valueOf(BaseStateEnum.VALID.getCode()));
		String cd = DateFormatUtil.now2Str();
		urv.setCreatetime(cd);
		urv.setUpdatetime(cd);
		Xscontract urecord = mapper.map(urv, Xscontract.class);
		if(urecord==null)
			throw new RuntimeException("CREATE XscontractVO ERROR 10002:Xscontract is null");
		String contractNum = null;
		if(urv.getXscontractnum() == null || StringUtils.isEmpty(urv.getXscontractnum())){
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yy");
			String srt = sdf.format(d);
			String head = "SHWZGNXS" + srt;
			//String maxCode = service.getMaxContractNum(head);
			String maxCode = xscontractMapper.selectMaxNo();
			if(maxCode!=null && !StringUtils.isEmpty(maxCode) && maxCode.length() == 14){
				maxCode = maxCode.trim().substring(0, 14);
			}
			contractNum = KeyGenerator.computeNewCode(maxCode, head, 4);
			urecord.setXscontractnum(contractNum);
		}
		
		int y = xscontractMapper.insertSelective(urecord);
		if(y != 1){
			throw new RuntimeException("CREATE XscontractVO ERROR 10002:XScontractno : "+urv.getXscontractno());
		}
		PlanVO pv = new PlanVO();
		pv.setPlanstatus(String.valueOf(PlanStateEnum.XSCONTRACT.getCode()));
		//pv.setSearchprice(planvo.getSearchprice());
		//pv.setSearchmoney(planvo.getSearchmoney());
		pv.setFkXscontractno(urv.getXscontractno());
		PlanVO params = new PlanVO();
		params.setInvalid(String.valueOf(BaseStateEnum.VALID.getCode()));
		params.setPlanstatus(String.valueOf(PlanStateEnum.CGCONTRACT.getCode()));
		planActivity.savePlans(pv, planNos, params,null);
		
		return contractNum;
	}
	public int save(XscontractVO urv){
		
		if(urv == null)
			return 0;
		String cd = DateFormatUtil.now2Str();
		urv.setUpdatetime(cd);
		System.out.println(urv);
		Xscontract record = mapper.map(urv, Xscontract.class);
		if(record==null)
			throw new RuntimeException("UPDATE ERROR 10003:Xscontract is null");
		
		XscontractExample ue = new XscontractExample();
		ue.or().andXscontractnoEqualTo(urv.getXscontractno());
		
		return xscontractMapper.updateByExampleSelective(record, ue);
	}	
	public Pager<XscontractVO> findAll(int offset,int limit){
		XscontractExample ue = null;
		if(offset>=0 && limit>0){
			ue =new XscontractExample();
			ue.setOffset(offset);
			ue.setLimit(limit);
			ue.or();
		}
		Pager<XscontractVO> pager = new  Pager<XscontractVO>();
		pager.setTotalNum(xscontractMapper.countByExample(null));
		List<Xscontract> ul = xscontractMapper.selectByExample(ue);
		List<XscontractVO> uvl = new ArrayList<XscontractVO>();
		for(Xscontract u : ul){
			XscontractVO uv = mapper.map(u, XscontractVO.class);
			
			uvl.add(uv);
		}
		pager.setPageList(uvl);
		return pager;
	}
	public Pager<XscontractVO> findByVO(XscontractVO vo,JqGridSearchTo to,int offset,int limit,UserVO user){
		if(vo==null)
			return null;
		XscontractExample ue = new XscontractExample();
		if(offset>=0 && limit>0){
			ue.setOffset(offset);
			ue.setLimit(limit);
		}
		
		if(to!=null){
			if(to.getSidx()!=null&&!StringUtils.isEmpty(to.getSidx())){
				ue.setOrderByClause(to.getSidx()+" "+to.getSord());
			}
		}
		List<XscontractVO> uvl = this.findByVO(vo, to, offset, limit,ue,user);
		Pager<XscontractVO> pager = new  Pager<XscontractVO>();
		pager.setPageList(uvl);
		int totalNum = xscontractMapper.countByExample(ue);
		pager.setTotalNum(totalNum);
		pager.setTotalpages((totalNum+limit-1)/limit);
		return pager;
	}
	
	/**
	 * 
	 * @param XscontractVO 值对象
	 * @param to 查询参数
	 * @param offset 分页下标
	 * @param limit 分页条数
	 * @param ue 条件封装对象
	 * @param user session中user
	 * @return 值对象数组
	 * 
	 */
	private List<XscontractVO> findByVO(XscontractVO xscontractVO,JqGridSearchTo to,int offset,int limit,XscontractExample ue,UserVO user){
		
		if(ue == null){
			ue = new XscontractExample();
		}
		Criteria c = ue.createCriteria();
		if(user!=null && !StringUtils.isEmpty(user.getDatarole())){
			if(user.getDatarole().equals(UserDataRoleEnum.SELF.getCode())){
				c.andFkUsernoEqualTo(user.getUserno());
			}else if(user.getDatarole().equals(UserDataRoleEnum.DEPT.getCode())){
				c.andFkDeptnoEqualTo(user.getFkDeptno());
			}
		}else{
			return null;
		}
		if(xscontractVO.getXscontractnum()!=null && !StringUtils.isEmpty(xscontractVO.getXscontractnum())){
			if(xscontractVO.getXscontractnumOp()!=null && !StringUtils.isEmpty(xscontractVO.getXscontractnumOp())){
				if(xscontractVO.getXscontractnumOp().equals(JqGridOpEnum.EQ.getCode())){
					c.andXscontractnumEqualTo(xscontractVO.getXscontractnum());
				}else if (xscontractVO.getXscontractnumOp().equals(JqGridOpEnum.CN.getCode())){
					c.andXscontractnumLike("%"+xscontractVO.getXscontractnum()+"%");
				}
			}else{
				c.andXscontractnumEqualTo(xscontractVO.getXscontractnum());
			}
			
		}
		if(xscontractVO.getFkUsecompno()!=null && !StringUtils.isEmpty(xscontractVO.getFkUsecompno())){
			c.andFkUsecompnoEqualTo(xscontractVO.getFkUsecompno());
		}
		if(xscontractVO.getInvalid()!=null && !StringUtils.isEmpty(xscontractVO.getInvalid())){
			c.andInvalidEqualTo(xscontractVO.getInvalid());
		}
		if(to!=null){
			if(to.getSidx()!=null&&!StringUtils.isEmpty(to.getSidx())){
				ue.setOrderByClause(to.getSidx()+" "+to.getSord());
			}
		}
		
		List<Xscontract> ul = xscontractMapper.selectByExample(ue);
		if(ul==null || ul.size()<1){
			return null;
		}
		List<XscontractVO> uvl = new ArrayList<XscontractVO>();
		for(Xscontract u : ul){
			XscontractVO uv = mapper.map(u, XscontractVO.class);
			uvl.add(uv);
		}
		return uvl;
		
	}
	
}
