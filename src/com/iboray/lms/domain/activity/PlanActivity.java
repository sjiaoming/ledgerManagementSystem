package com.iboray.lms.domain.activity;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.dozer.Mapper;

import com.iboray.lms.domain.entity.Plan;
import com.iboray.lms.domain.entity.PlanExample;
import com.iboray.lms.domain.entity.PlanExample.Criteria;
import com.iboray.lms.domain.entity.PlanProcurementSource;
import com.iboray.lms.domain.entity.PlanProcurementSourceExample;
import com.iboray.lms.domain.entity.Planchangedetails;
import com.iboray.lms.domain.entity.PlanchangedetailsExample;
import com.iboray.lms.domain.entity.enums.BaseStateEnum;
import com.iboray.lms.domain.entity.enums.JqGridOpEnum;
import com.iboray.lms.domain.entity.enums.PlanChangeStatusEnum;
import com.iboray.lms.domain.entity.enums.PlanStateEnum;
import com.iboray.lms.domain.entity.enums.UserDataRoleEnum;
import com.iboray.lms.domain.vo.PlanProcurementSourceVO;
import com.iboray.lms.domain.vo.PlanVO;
import com.iboray.lms.domain.vo.PlanchangedetailsVO;
import com.iboray.lms.domain.vo.UserVO;
import com.iboray.lms.infrastructure.dao.PlanMapper;
import com.iboray.lms.infrastructure.dao.PlanchangedetailsMapper;
import com.iboray.lms.infrastructure.utils.ArrayUtil;
import com.iboray.lms.infrastructure.utils.DateFormatUtil;
import com.iboray.lms.infrastructure.utils.UUIDHexGenerator;
import com.iboray.lms.userinterface.common.JqGridSearchTo;
import com.iboray.lms.userinterface.common.Pager;

public class PlanActivity {

	static Logger logger = Logger.getLogger(PlanActivity.class);
	
	private PlanMapper planMapper;
	
	private PlanchangedetailsMapper planchangedetailsMapper;
	
	private Mapper mapper ;
	
	
	public void setPlanchangedetailsMapper(
			PlanchangedetailsMapper planchangedetailsMapper) {
		this.planchangedetailsMapper = planchangedetailsMapper;
	}
	public void setPlanMapper(PlanMapper planMapper) {
		this.planMapper = planMapper;
	}
	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}
	public PlanVO findPlanVOBYPlanNo(String planNo){
		logger.info("PlanActivity.findPlanVOBYPlanNo  planNo:"+planNo);
		if(StringUtils.isEmpty(planNo))
			return null;
		PlanExample ue = new PlanExample();
		ue.or().andPlannoEqualTo(planNo);
		Plan u = planMapper.selectByNo(planNo);
		if(u==null)
			throw new RuntimeException("planNo is not find");
		return mapper.map(u, PlanVO.class);
	}
	public int deleteByNos(String[] nos,UserVO user){
		Plan plan = new Plan();
		plan.setInvalid(String.valueOf(BaseStateEnum.DELETE.getCode()));
		String cd = DateFormatUtil.now2Str();
		plan.setUpdatetime(cd);
		if(user != null)
			plan.setFkDtypeno(user.getPersonname());
		PlanExample ue = new PlanExample();
		ue.or().andPlannoIn(ArrayUtil.Strs2List(nos));
		return planMapper.updateByExampleSelective(plan, ue);
	}
	public int createPlan(PlanVO urv,UserVO user){
		
		if(urv == null)
			return 0;
		
		urv.setPlanno(UUIDHexGenerator.generator());
		urv.setInvalid(String.valueOf(BaseStateEnum.VALID.getCode()));
		urv.setPlanstatus(String.valueOf(PlanStateEnum.UNCLAIMED.getCode()));
		String cd = DateFormatUtil.now2Str();
		urv.setCreatetime(cd);
		urv.setUpdatetime(cd);
//		System.out.println(urv);
		Plan urecord = mapper.map(urv, Plan.class);
		if(urecord==null)
			throw new RuntimeException("CREATE ERROR 10002:METHOD createPlan(PlanVO urv,UserVO user) Plan is null");
		if(user != null)
			urecord.setFkDtypeno(user.getPersonname());
		int y = planMapper.insertSelective(urecord);
		if(y<0){
			throw new RuntimeException("CREATE ERROR 10001:METHOD createPlan(PlanVO urv,UserVO user) Plan create error");
		}else{
			Planchangedetails planchangedetails = getPlanchangedetails(urv,user);
			planchangedetails.setFkDtypeno(PlanChangeStatusEnum.ADD.getCode());
			int x = planchangedetailsMapper.insertSelective(planchangedetails);
			if(x!=1){
				throw new RuntimeException("CREATE ERROR 10001:METHOD createPlan(PlanVO urv,UserVO user) Planchangedetails create error");
			}
		}
		return y;
	}
	/**
	 * 
	 * @param urv 
	 * @param cg 是否记录变更记录
	 * @return
	 */
	public int savePlan(PlanVO urv,boolean cg,UserVO user){
		
		if(urv == null)
			return 0;
		String cd = DateFormatUtil.now2Str();
		urv.setUpdatetime(cd);
		//System.out.println(urv);
		Plan record = mapper.map(urv, Plan.class);
		if(record==null)
			throw new RuntimeException("UPDATE ERROR 10003:METHOD savePlan(PlanVO urv,boolean cg,UserVO user) Plan is null");
		if(user != null)
		record.setFkDtypeno(user.getPersonname());
		PlanExample ue = new PlanExample();
		ue.or().andPlannoEqualTo(urv.getPlanno()).andInvalidEqualTo(urv.getInvalid()).andPlanstatusEqualTo(urv.getPlanstatus());
		
		int y = planMapper.updateByExampleSelective(record, ue);
		if(y<0){
			throw new RuntimeException("UPDATE ERROR 10004:METHOD savePlan(PlanVO urv,boolean cg,UserVO user) Plan update error");
		}else if(cg){
			Planchangedetails planchangedetails = getPlanchangedetails(urv,user);
			planchangedetails.setFkDtypeno(PlanChangeStatusEnum.MODIFY.getCode());
			planchangedetailsMapper.insertSelective(planchangedetails);
		}
		return y;
	}
	/**
	 * 
	 * @param urv 需要更新的plan值对象
	 * @param planNos 修改的计划No
	 * @param cg 是否记录变更记录
	 * @return
	 */
	public int savePlans(PlanVO urv,String[] planNos,boolean cg,UserVO user){
		if(urv == null || planNos == null || planNos.length<1)
			return 0;
		String cd = DateFormatUtil.now2Str();
		urv.setUpdatetime(cd);
		//System.out.println(urv);
		Plan record = mapper.map(urv, Plan.class);
		if(record==null)
			throw new RuntimeException("UPDATE Plan ERROR 10003:METHOD savePlans(PlanVO urv,String[] planNos,boolean cg,UserVO user) Plan is null");
		if(user != null)
		record.setFkDtypeno(user.getPersonname());
		PlanExample ue = new PlanExample();
		ue.or().andPlannoIn(ArrayUtil.Strs2List(planNos)).andInvalidEqualTo(urv.getInvalid()).andPlanstatusEqualTo(urv.getPlanstatus());
		
		int y = planMapper.updateByExampleSelective(record, ue);
		if(y<0){
			throw new RuntimeException("UPDATE ERROR 10004:METHOD savePlans(PlanVO urv,String[] planNos,boolean cg,UserVO user) Plan update error");
		}else if(cg){
			for(String no : planNos){
				urv.setPlanno(no);
				Planchangedetails planchangedetails = getPlanchangedetails(urv,user);
				planchangedetails.setFkDtypeno(PlanChangeStatusEnum.MODIFY.getCode());
				planchangedetailsMapper.insertSelective(planchangedetails);
			}
		}
		
		return y;
	}
	/**
	 * 
	 * @param urv 需要更新的plan值对象
	 * @param planNos 需要更新的所有plan编号
	 * @param params 满足的条件
	 * @param user 操作用户
	 * @return
	 */
	public int savePlans(PlanVO urv,String[] planNos,PlanVO params,UserVO user){
		if(urv == null || planNos == null || planNos.length<1 || params==null)
			return 0;
		String cd = DateFormatUtil.now2Str();
		urv.setUpdatetime(cd);
		//System.out.println(urv);
		Plan record = mapper.map(urv, Plan.class);
		if(record==null)
			throw new RuntimeException("UPDATE Plan ERROR 10003:METHOD savePlans(PlanVO urv,String[] planNos,PlanVO params,UserVO user) Plan is null");
		if(user != null)
		record.setFkDtypeno(user.getPersonname());
		PlanExample ue = new PlanExample();
		ue.or().andPlannoIn(ArrayUtil.Strs2List(planNos)).andInvalidEqualTo(params.getInvalid()).andPlanstatusEqualTo(params.getPlanstatus());
		return planMapper.updateByExampleSelective(record, ue);
	}
	public Pager<PlanVO> findAll(int offset,int limit){
		PlanExample ue = null;
		if(offset>=0 && limit>0){
			ue =new PlanExample();
			ue.setOffset(offset);
			ue.setLimit(limit);
			ue.or();
		}
		Pager<PlanVO> planPager = new  Pager<PlanVO>();
		int totalNum = planMapper.countByExample(null);
		planPager.setTotalNum(totalNum);
		planPager.setTotalpages((totalNum+limit-1)/limit);
		List<Plan> ul = planMapper.selectByExample(ue);
		List<PlanVO> uvl = new ArrayList<PlanVO>();
		for(Plan u : ul){
			PlanVO uv = mapper.map(u, PlanVO.class);
			
			uvl.add(uv);
		}
		planPager.setPageList(uvl);
		return planPager;
	}
	public List<PlanVO> findByVO(PlanVO planVO,UserVO user){
		return this.findByPlanVO(planVO, null, 0, 0, null,user);
	}
	public List<PlanchangedetailsVO> findAllPlanchangedetails(String planNo){
		if(planNo==null || StringUtils.isEmpty(planNo)){
			return null;
			//throw new RuntimeException("SELECT Planchangedetails ERROR 10005 : planNo is NULL");
		}
		PlanchangedetailsExample pce  = new PlanchangedetailsExample();
		pce.or().andFkPlannoEqualTo(planNo);
		pce.setOrderByClause(" createTime desc ");
		List<Planchangedetails> ul=   planchangedetailsMapper.selectByExample(pce);
		List<PlanchangedetailsVO> uvl = new ArrayList<PlanchangedetailsVO>();
		for(Planchangedetails u : ul){
			PlanchangedetailsVO uv = mapper.map(u, PlanchangedetailsVO.class);
			uvl.add(uv);
		}
		return uvl;
	}
	public Pager<PlanVO> findByVO(PlanVO planVO,JqGridSearchTo to,int offset,int limit,UserVO user){
		if(planVO==null)
			return null;
		PlanExample ue = new PlanExample();
		if(offset>=0 && limit>0){
			ue.setOffset(offset);
			ue.setLimit(limit);
		}
		if(to!=null){
			if(to.getSidx()!=null&&!StringUtils.isEmpty(to.getSidx())){
				ue.setOrderByClause(to.getSidx()+" "+to.getSord());
			}
		}
		List<PlanVO> uvl = this.findByPlanVO(planVO, to, offset, limit,ue,user);
		Pager<PlanVO> planPager = new  Pager<PlanVO>();
		planPager.setPageList(uvl);
		int totalNum = planMapper.countByExample(ue);
		planPager.setTotalNum(totalNum);
		planPager.setTotalpages((totalNum+limit-1)/limit);
		return planPager;
	}
	public Pager<PlanProcurementSourceVO> findByVO(PlanProcurementSourceVO planProcurementSourceVO,JqGridSearchTo to,int offset,int limit,UserVO user){
		if(planProcurementSourceVO==null)
			return null;
		PlanProcurementSourceExample ue = new PlanProcurementSourceExample();
		if(offset>=0 && limit>0){
			ue.setOffset(offset);
			ue.setLimit(limit);
		}
		if(to!=null){
			if(to.getSidx()!=null&&!StringUtils.isEmpty(to.getSidx())){
				ue.setOrderByClause(to.getSidx()+" "+to.getSord());
			}
		}
		List<PlanProcurementSourceVO> uvl = this.findByPlanProcurementSourceVO(planProcurementSourceVO, to, offset, limit,ue,user);
		Pager<PlanProcurementSourceVO> planPager = new  Pager<PlanProcurementSourceVO>();
		planPager.setPageList(uvl);
		int totalNum = planMapper.countByPlanProcurementSourceExample(ue);
		planPager.setTotalNum(totalNum);
		planPager.setTotalpages((totalNum+limit-1)/limit);
		return planPager;
	}
	/**
	 * 
	 * @param planVO 值对象
	 * @param to 查询参数
	 * @param offset 分页下标
	 * @param limit 分页条数
	 * @param ue 条件封装对象
	 * @param user session中user
	 * @return 值对象数组
	 * 
	 */
	private List<PlanVO> findByPlanVO(PlanVO planVO,JqGridSearchTo to,int offset,int limit,PlanExample ue,UserVO user){
		
		if(ue == null){
			ue = new PlanExample();
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
		if(planVO.getPlanno()!=null && !StringUtils.isEmpty(planVO.getPlanno())){
			c.andPlannoEqualTo(planVO.getPlanno());
		}else if(planVO.getPlannoList()!=null && planVO.getPlannoList().size()>0){
			c.andPlannoIn(planVO.getPlannoList());
		}
		if(planVO.getCartcode()!=null && !StringUtils.isEmpty(planVO.getCartcode())){
			if(planVO.getCartcodeOp()!=null && !StringUtils.isEmpty(planVO.getCartcodeOp())){
				if(planVO.getCartcodeOp().equals(JqGridOpEnum.EQ.getCode())){
					c.andCartcodeEqualTo(planVO.getCartcode());
				}else if (planVO.getCartcodeOp().equals(JqGridOpEnum.CN.getCode())){
					c.andCartcodeLike("%"+planVO.getCartcode()+"%");
				}
			}else{
				c.andCartcodeEqualTo(planVO.getCartcode());
			}
			
		}
		if(planVO.getBnumber()!=null && !StringUtils.isEmpty(planVO.getBnumber())){
			if(planVO.getBnumberOp()!=null && !StringUtils.isEmpty(planVO.getBnumberOp())){
				if(planVO.getBnumberOp().equals(JqGridOpEnum.EQ.getCode())){
					c.andBnumberEqualTo(planVO.getBnumber());
				}else if (planVO.getBnumberOp().equals(JqGridOpEnum.CN.getCode())){
					c.andBnumberLike("%"+planVO.getBnumber()+"%");
				}
			}else{
				c.andBnumberEqualTo(planVO.getBnumber());
			}
			
		}
		if(planVO.getFnumber()!=null && !StringUtils.isEmpty(planVO.getFnumber())){
			if(planVO.getFnumberOp()!=null && !StringUtils.isEmpty(planVO.getFnumberOp())){
				if(planVO.getFnumberOp().equals(JqGridOpEnum.EQ.getCode())){
					c.andFnumberEqualTo(planVO.getFnumber());
				}else if (planVO.getFnumberOp().equals(JqGridOpEnum.CN.getCode())){
					c.andFnumberLike("%"+planVO.getFnumber()+"%");
				}
			}else{
				c.andFnumberEqualTo(planVO.getFnumber());
			}
			
		}
		if(planVO.getCartlinenum()!=null && planVO.getCartlinenum()>0){
			c.andCartlinenumEqualTo(planVO.getCartlinenum());
		}
		if(planVO.getOldplannum()!=null && !StringUtils.isEmpty(planVO.getOldplannum())){
			if(planVO.getOldplannumOp()!=null && !StringUtils.isEmpty(planVO.getOldplannumOp())){
				if(planVO.getOldplannumOp().equals(JqGridOpEnum.EQ.getCode())){
					c.andOldplannumEqualTo(planVO.getCartcode());
				}else if (planVO.getOldplannumOp().equals(JqGridOpEnum.CN.getCode())){
					c.andOldplannumLike("%"+planVO.getOldplannum()+"%");
				}
			}else{
				c.andOldplannumEqualTo(planVO.getCartcode());
			}
		}
		if(planVO.getFkUsecompno()!=null && !StringUtils.isEmpty(planVO.getFkUsecompno())){
			c.andFkUsecompnoEqualTo(planVO.getFkUsecompno());
		}
		if(planVO.getPlanstatus()!=null && !StringUtils.isEmpty(planVO.getPlanstatus())){
			c.andPlanstatusEqualTo(planVO.getPlanstatus());
		}else if(planVO.getPlanstatusList()!=null && planVO.getPlanstatusList().size()>0){
			c.andPlanstatusIn(planVO.getPlanstatusList());
		}
		if(planVO.getInvalid()!=null && !StringUtils.isEmpty(planVO.getInvalid())){
			c.andInvalidEqualTo(planVO.getInvalid());
		}
		if(to!=null){
			if(to.getSidx()!=null&&!StringUtils.isEmpty(to.getSidx())){
				ue.setOrderByClause(to.getSidx()+" "+to.getSord());
			}
		}
		
		List<Plan> ul = planMapper.selectByExample(ue);
		if(ul==null || ul.size()<1){
			return null;
		}
		List<PlanVO> uvl = new ArrayList<PlanVO>();
		for(Plan u : ul){
			PlanVO uv = mapper.map(u, PlanVO.class);
			uvl.add(uv);
		}
		return uvl;
		
	}
	/**
	 * 
	 * @param planVO 值对象
	 * @param to 查询参数
	 * @param offset 分页下标
	 * @param limit 分页条数
	 * @param ue 条件封装对象
	 * @param user session中user
	 * @return 值对象数组
	 * 
	 */
	private List<PlanProcurementSourceVO> findByPlanProcurementSourceVO(PlanProcurementSourceVO planProcurementSourceVO,JqGridSearchTo to,int offset,int limit,PlanProcurementSourceExample ue,UserVO user){
		
		if(ue == null){
			ue = new PlanProcurementSourceExample();
		}
		com.iboray.lms.domain.entity.PlanProcurementSourceExample.Criteria c = ue.createCriteria();
		if(user!=null && !StringUtils.isEmpty(user.getDatarole())){
			if(user.getDatarole().equals(UserDataRoleEnum.SELF.getCode())){
				c.andFkUsernoEqualTo(user.getUserno());
			}else if(user.getDatarole().equals(UserDataRoleEnum.DEPT.getCode())){
				c.andFkDeptnoEqualTo(user.getFkDeptno());
			}
		}else{
			return null;
		}
		if(planProcurementSourceVO.getCartcode()!=null && !StringUtils.isEmpty(planProcurementSourceVO.getCartcode())){
			if(planProcurementSourceVO.getCartcodeOp()!=null && !StringUtils.isEmpty(planProcurementSourceVO.getCartcodeOp())){
				if(planProcurementSourceVO.getCartcodeOp().equals(JqGridOpEnum.EQ.getCode())){
					c.andCartcodeEqualTo(planProcurementSourceVO.getCartcode());
				}else if (planProcurementSourceVO.getCartcodeOp().equals(JqGridOpEnum.CN.getCode())){
					c.andCartcodeLike("%"+planProcurementSourceVO.getCartcode()+"%");
				}
			}else{
				c.andCartcodeEqualTo(planProcurementSourceVO.getCartcode());
			}
			
		}
		if(planProcurementSourceVO.getBnumber()!=null && !StringUtils.isEmpty(planProcurementSourceVO.getBnumber())){
			if(planProcurementSourceVO.getBnumberOp()!=null && !StringUtils.isEmpty(planProcurementSourceVO.getBnumberOp())){
				if(planProcurementSourceVO.getBnumberOp().equals(JqGridOpEnum.EQ.getCode())){
					c.andBnumberEqualTo(planProcurementSourceVO.getBnumber());
				}else if (planProcurementSourceVO.getBnumberOp().equals(JqGridOpEnum.CN.getCode())){
					c.andBnumberLike("%"+planProcurementSourceVO.getBnumber()+"%");
				}
			}else{
				c.andBnumberEqualTo(planProcurementSourceVO.getBnumber());
			}
			
		}
		if(planProcurementSourceVO.getFnumber()!=null && !StringUtils.isEmpty(planProcurementSourceVO.getFnumber())){
			if(planProcurementSourceVO.getFnumberOp()!=null && !StringUtils.isEmpty(planProcurementSourceVO.getFnumberOp())){
				if(planProcurementSourceVO.getFnumberOp().equals(JqGridOpEnum.EQ.getCode())){
					c.andFnumberEqualTo(planProcurementSourceVO.getFnumber());
				}else if (planProcurementSourceVO.getFnumberOp().equals(JqGridOpEnum.CN.getCode())){
					c.andFnumberLike("%"+planProcurementSourceVO.getFnumber()+"%");
				}
			}else{
				c.andFnumberEqualTo(planProcurementSourceVO.getFnumber());
			}
			
		}
		if(planProcurementSourceVO.getCartlinenum()!=null && planProcurementSourceVO.getCartlinenum()>0){
			c.andCartlinenumEqualTo(planProcurementSourceVO.getCartlinenum());
		}
		if(planProcurementSourceVO.getOldplannum()!=null && !StringUtils.isEmpty(planProcurementSourceVO.getOldplannum())){
			if(planProcurementSourceVO.getOldplannumOp()!=null && !StringUtils.isEmpty(planProcurementSourceVO.getOldplannumOp())){
				if(planProcurementSourceVO.getOldplannumOp().equals(JqGridOpEnum.EQ.getCode())){
					c.andOldplannumEqualTo(planProcurementSourceVO.getCartcode());
				}else if (planProcurementSourceVO.getOldplannumOp().equals(JqGridOpEnum.CN.getCode())){
					c.andOldplannumLike("%"+planProcurementSourceVO.getOldplannum()+"%");
				}
			}else{
				c.andOldplannumEqualTo(planProcurementSourceVO.getCartcode());
			}
		}
		if(planProcurementSourceVO.getFkUsecompno()!=null && !StringUtils.isEmpty(planProcurementSourceVO.getFkUsecompno())){
			c.andFkUsecompnoEqualTo(planProcurementSourceVO.getFkUsecompno());
		}
		if(planProcurementSourceVO.getPlanstatus()!=null && !StringUtils.isEmpty(planProcurementSourceVO.getPlanstatus())){
			c.andPlanstatusEqualTo(planProcurementSourceVO.getPlanstatus());
		}else if(planProcurementSourceVO.getPlanstatusList()!=null && planProcurementSourceVO.getPlanstatusList().size()>0){
			c.andPlanstatusIn(planProcurementSourceVO.getPlanstatusList());
		}
		if(planProcurementSourceVO.getInvalid()!=null && !StringUtils.isEmpty(planProcurementSourceVO.getInvalid())){
			c.andInvalidEqualTo(planProcurementSourceVO.getInvalid());
		}
		if(to!=null){
			if(to.getSidx()!=null&&!StringUtils.isEmpty(to.getSidx())){
				ue.setOrderByClause(to.getSidx()+" "+to.getSord());
			}
		}
		
		List<PlanProcurementSource> ul = planMapper.selectPlanProcurementSourceByExample(ue);
		if(ul==null || ul.size()<1){
			return null;
		}
		List<PlanProcurementSourceVO> uvl = new ArrayList<PlanProcurementSourceVO>();
		for(PlanProcurementSource u : ul){
			PlanProcurementSourceVO uv = mapper.map(u, PlanProcurementSourceVO.class);
			uvl.add(uv);
		}
		return uvl;
		
	}
	/**
	 * 封装plan变更对象
	 * @param urv 计划
	 * @param user 操作用户
	 * @return
	 */
	private Planchangedetails getPlanchangedetails(PlanVO urv,UserVO user){
		Planchangedetails planchangedetails = new Planchangedetails();
		planchangedetails.setPlanchangeno(UUIDHexGenerator.generator());
		planchangedetails.setOldplannum(urv.getOldplannum());
		planchangedetails.setOldplanlinenum(urv.getOldplanlinenum());
		planchangedetails.setItemscode(urv.getItemscode());
		planchangedetails.setItemsname(urv.getItemsname());
		planchangedetails.setFkUsecompno(urv.getFkUsecompno());
		planchangedetails.setReceiptdate(urv.getReceiptdate());
		planchangedetails.setUnit(urv.getUnit());
		planchangedetails.setPlannum(urv.getPlannum());
		planchangedetails.setPlanprice(urv.getPlanprice());
		planchangedetails.setPlanmoney(urv.getPlanmoney());
		planchangedetails.setArrivaldate(urv.getArrivaldate());
		planchangedetails.setArrivaladdr(urv.getArrivaladdr());
		planchangedetails.setFnumber(urv.getFnumber());
		planchangedetails.setBnumber(urv.getBnumber());
		planchangedetails.setPlanstatus(urv.getPlanstatus());
		planchangedetails.setPlaninvalid(urv.getInvalid());
		planchangedetails.setFkPlanno(urv.getPlanno());
		planchangedetails.setCartcode(urv.getCartcode());
		planchangedetails.setCartlinenum(urv.getCartlinenum());
		if(user != null)
		planchangedetails.setFkUserno(user.getPersonname());
		String cd1 = DateFormatUtil.now2Str();
		planchangedetails.setCreatetime(cd1);
		
		return planchangedetails;
	}
	
}
