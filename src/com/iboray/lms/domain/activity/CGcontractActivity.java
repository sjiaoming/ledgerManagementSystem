package com.iboray.lms.domain.activity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.dozer.Mapper;

import com.iboray.lms.domain.entity.CGcontract;
import com.iboray.lms.domain.entity.CGcontractExample;
import com.iboray.lms.domain.entity.CGcontractExample.Criteria;
import com.iboray.lms.domain.entity.enums.BaseStateEnum;
import com.iboray.lms.domain.entity.enums.JqGridOpEnum;
import com.iboray.lms.domain.entity.enums.PlanStateEnum;
import com.iboray.lms.domain.entity.enums.UserDataRoleEnum;
import com.iboray.lms.domain.vo.CGcontractVO;
import com.iboray.lms.domain.vo.PlanVO;
import com.iboray.lms.domain.vo.UserVO;
import com.iboray.lms.infrastructure.dao.CGcontractMapper;
import com.iboray.lms.infrastructure.utils.ArrayUtil;
import com.iboray.lms.infrastructure.utils.DateFormatUtil;
import com.iboray.lms.infrastructure.utils.KeyGenerator;
import com.iboray.lms.infrastructure.utils.UUIDHexGenerator;
import com.iboray.lms.userinterface.common.JqGridSearchTo;
import com.iboray.lms.userinterface.common.Pager;

public class CGcontractActivity {

	static Logger logger = Logger.getLogger(CGcontractActivity.class);
	
	private CGcontractMapper cgcontractMapper;
	
	private PlanActivity planActivity;
	
	private Mapper mapper ;
	
	public void setPlanActivity(PlanActivity planActivity) {
		this.planActivity = planActivity;
	}

	public void setCgcontractMapper(CGcontractMapper cgcontractMapper) {
		this.cgcontractMapper = cgcontractMapper;
	}

	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}
	
	public CGcontractVO findVOBYNo(String no){
		logger.info("CGcontractActivity.findVOBYNo  no:"+no);
		if(StringUtils.isEmpty(no))
			return null;
		CGcontractExample ue = new CGcontractExample();
		ue.or().andCgcontractnoEqualTo(no);
		CGcontract u = cgcontractMapper.selectByNo(no);
		if(u==null)
			throw new RuntimeException("no is not find");
		return mapper.map(u, CGcontractVO.class);
	}
	public int deleteByNos(String[] nos){
		CGcontract CGcontract = new CGcontract();
		CGcontract.setInvalid(String.valueOf(BaseStateEnum.DELETE.getCode()));
		CGcontractExample ue = new CGcontractExample();
		ue.or().andCgcontractnoIn(ArrayUtil.Strs2List(nos));
		return cgcontractMapper.updateByExampleSelective(CGcontract, ue);
	}
	public String create(CGcontractVO urv,String[] planNos,PlanVO planvo){
		
		if(urv == null)
			return null;
		urv.setCgcontractno(UUIDHexGenerator.generator());
		urv.setInvalid(String.valueOf(BaseStateEnum.VALID.getCode()));
		String cd = DateFormatUtil.now2Str();
		urv.setCreatetime(cd);
		urv.setUpdatetime(cd);
		CGcontract urecord = mapper.map(urv, CGcontract.class);
		if(urecord==null)
			throw new RuntimeException("CREATE CGcontractVO ERROR 10002:CGcontract is null");
		String contractNum = null;
		if(urv.getCgcontractnum() == null || StringUtils.isEmpty(urv.getCgcontractnum())){
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yy");
			String srt = sdf.format(d);
			String head = "SHWZGNCG" + srt;
			//String maxCode = service.getMaxContractNum(head);
			String maxCode = cgcontractMapper.selectMaxNo();
			if(maxCode!=null && !StringUtils.isEmpty(maxCode) && maxCode.length() == 14){
				maxCode = maxCode.trim().substring(0, 14);
			}
			contractNum = KeyGenerator.computeNewCode(maxCode, head, 4);
			urecord.setCgcontractnum(contractNum);
		}
		
		int y = cgcontractMapper.insertSelective(urecord);
		if(y != 1){
			throw new RuntimeException("CREATE CGcontractVO ERROR 10002:Cgcontractno : "+urv.getCgcontractno());
		}
		PlanVO pv = new PlanVO();
		pv.setPlanstatus(String.valueOf(PlanStateEnum.CGCONTRACT.getCode()));
		//pv.setSearchprice(planvo.getSearchprice());
		//pv.setSearchmoney(planvo.getSearchmoney());
		pv.setFkCgcontractno(urv.getCgcontractno());
		PlanVO params = new PlanVO();
		params.setInvalid(String.valueOf(BaseStateEnum.VALID.getCode()));
		params.setPlanstatus(String.valueOf(PlanStateEnum.PROCUREMENTSC.getCode()));
		
		planActivity.savePlans(pv, planNos, params,null);
		
		return contractNum;
	}
	public int save(CGcontractVO urv){
		
		if(urv == null)
			return 0;
		String cd = DateFormatUtil.now2Str();
		urv.setUpdatetime(cd);
		System.out.println(urv);
		CGcontract record = mapper.map(urv, CGcontract.class);
		if(record==null)
			throw new RuntimeException("UPDATE ERROR 10003:CGcontract is null");
		
		CGcontractExample ue = new CGcontractExample();
		ue.or().andCgcontractnoEqualTo(urv.getCgcontractno());
		
		return cgcontractMapper.updateByExampleSelective(record, ue);
	}	
	public Pager<CGcontractVO> findAll(int offset,int limit){
		CGcontractExample ue = null;
		if(offset>=0 && limit>0){
			ue =new CGcontractExample();
			ue.setOffset(offset);
			ue.setLimit(limit);
			ue.or();
		}
		Pager<CGcontractVO> pager = new  Pager<CGcontractVO>();
		pager.setTotalNum(cgcontractMapper.countByExample(null));
		List<CGcontract> ul = cgcontractMapper.selectByExample(ue);
		List<CGcontractVO> uvl = new ArrayList<CGcontractVO>();
		for(CGcontract u : ul){
			CGcontractVO uv = mapper.map(u, CGcontractVO.class);
			
			uvl.add(uv);
		}
		pager.setPageList(uvl);
		return pager;
	}
	public Pager<CGcontractVO> findByVO(CGcontractVO vo,JqGridSearchTo to,int offset,int limit,UserVO user){
		if(vo==null)
			return null;
		CGcontractExample ue = new CGcontractExample();
		if(offset>=0 && limit>0){
			ue.setOffset(offset);
			ue.setLimit(limit);
		}
		if(to!=null){
			if(to.getSidx()!=null&&!StringUtils.isEmpty(to.getSidx())){
				ue.setOrderByClause(to.getSidx()+" "+to.getSord());
			}
		}
		List<CGcontractVO> uvl = this.findByVO(vo, to, offset, limit,ue,user);
		Pager<CGcontractVO> pager = new  Pager<CGcontractVO>();
		pager.setPageList(uvl);
		int totalNum = cgcontractMapper.countByExample(ue);
		pager.setTotalNum(totalNum);
		pager.setTotalpages((totalNum+limit-1)/limit);
		return pager;
	}
	
	/**
	 * 
	 * @param CGcontractVO 值对象
	 * @param to 查询参数
	 * @param offset 分页下标
	 * @param limit 分页条数
	 * @param ue 条件封装对象
	 * @param user session中user
	 * @return 值对象数组
	 * 
	 */
	private List<CGcontractVO> findByVO(CGcontractVO cgcontractVO,JqGridSearchTo to,int offset,int limit,CGcontractExample ue,UserVO user){
		
		if(ue == null){
			ue = new CGcontractExample();
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
		if(cgcontractVO.getCgcontractnum()!=null && !StringUtils.isEmpty(cgcontractVO.getCgcontractnum())){
			if(cgcontractVO.getCgcontractnumOp()!=null && !StringUtils.isEmpty(cgcontractVO.getCgcontractnumOp())){
				if(cgcontractVO.getCgcontractnumOp().equals(JqGridOpEnum.EQ.getCode())){
					c.andCgcontractnumEqualTo(cgcontractVO.getCgcontractnum());
				}else if (cgcontractVO.getCgcontractnumOp().equals(JqGridOpEnum.CN.getCode())){
					c.andCgcontractnumLike("%"+cgcontractVO.getCgcontractnum()+"%");
				}
			}else{
				c.andCgcontractnumEqualTo(cgcontractVO.getCgcontractnum());
			}
			
		}
		if(cgcontractVO.getFkUsecompno()!=null && !StringUtils.isEmpty(cgcontractVO.getFkUsecompno())){
			c.andFkUsecompnoEqualTo(cgcontractVO.getFkUsecompno());
		}
		if(cgcontractVO.getInvalid()!=null && !StringUtils.isEmpty(cgcontractVO.getInvalid())){
			c.andInvalidEqualTo(cgcontractVO.getInvalid());
		}
		if(to!=null){
			if(to.getSidx()!=null&&!StringUtils.isEmpty(to.getSidx())){
				ue.setOrderByClause(to.getSidx()+" "+to.getSord());
			}
		}
		
		List<CGcontract> ul = cgcontractMapper.selectByExample(ue);
		if(ul==null || ul.size()<1){
			return null;
		}
		List<CGcontractVO> uvl = new ArrayList<CGcontractVO>();
		for(CGcontract u : ul){
			CGcontractVO uv = mapper.map(u, CGcontractVO.class);
			uvl.add(uv);
		}
		return uvl;
		
	}
	
	
}
