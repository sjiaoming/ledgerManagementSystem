package com.iboray.lms.domain.activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.dozer.Mapper;

import com.iboray.lms.domain.entity.ProcurementSource;
import com.iboray.lms.domain.entity.ProcurementSourceExample;
import com.iboray.lms.domain.entity.enums.BaseStateEnum;
import com.iboray.lms.domain.entity.enums.PlanStateEnum;
import com.iboray.lms.domain.vo.PlanVO;
import com.iboray.lms.domain.vo.ProcurementSourceVO;
import com.iboray.lms.domain.vo.UserVO;
import com.iboray.lms.infrastructure.dao.ProcurementSourceMapper;
import com.iboray.lms.infrastructure.utils.ArrayUtil;
import com.iboray.lms.infrastructure.utils.DateFormatUtil;
import com.iboray.lms.infrastructure.utils.UUIDHexGenerator;
import com.iboray.lms.userinterface.common.Pager;

public class ProcurementSourceActivity {

	static Logger logger = Logger.getLogger(ProcurementSourceActivity.class);
	
	private ProcurementSourceMapper procurementSourceMapper;
	
	private PlanActivity planActivity;
	
	private Mapper mapper ;

	public void setPlanActivity(PlanActivity planActivity) {
		this.planActivity = planActivity;
	}
	public void setProcurementSourceMapper(
			ProcurementSourceMapper procurementSourceMapper) {
		this.procurementSourceMapper = procurementSourceMapper;
	}

	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}
	
	public ProcurementSourceVO findProcurementSourceVOBYNo(String no){
		logger.info("ProcurementSourceActivity.findProcurementSourceVOBYNo  no:"+no);
		if(StringUtils.isEmpty(no))
			return null;
		ProcurementSourceExample ue = new ProcurementSourceExample();
		ue.or().andProcurementnoEqualTo(no);
		ProcurementSource u = procurementSourceMapper.selectByNo(no);
		if(u==null)
			throw new RuntimeException("no is not find");
		return mapper.map(u, ProcurementSourceVO.class);
	}
	public int deleteByNos(String[] nos){
		ProcurementSource procurementSource = new ProcurementSource();
		procurementSource.setInvalid(String.valueOf(BaseStateEnum.DELETE.getCode()));
		ProcurementSourceExample ue = new ProcurementSourceExample();
		ue.or().andProcurementnoIn(ArrayUtil.Strs2List(nos));
		return procurementSourceMapper.updateByExampleSelective(procurementSource, ue);
	}
	public int create(ProcurementSourceVO urv,String[] planNos,PlanVO planvo,UserVO uv){
		if(urv == null || planNos==null || planNos.length<1)
			return 0;
		PlanVO tempPv = new PlanVO();
		tempPv.setInvalid(String.valueOf(BaseStateEnum.VALID.getCode()));
		tempPv.setPlanstatus(String.valueOf(PlanStateEnum.PROCUREMENTSC.getCode()));
		List<String> paramsNos = Arrays.asList(planNos);
		tempPv.setPlannoList(paramsNos);
		List<PlanVO> planVOList = planActivity.findByVO(tempPv, uv);
//		boolean isInsert;
		int y=-1;
		if(planVOList==null || planVOList.isEmpty()){
//			isInsert = true;
			urv.setProcurementno(UUIDHexGenerator.generator());
			urv.setInvalid(String.valueOf(BaseStateEnum.VALID.getCode()));
			String cd = DateFormatUtil.now2Str();
			urv.setCreatetime(cd);
			urv.setUpdatetime(cd);
			//System.out.println(urv);
			ProcurementSource urecord = mapper.map(urv, ProcurementSource.class);
			if(urecord==null)
				throw new RuntimeException("CREATE ERROR 10002:Procurement is null");
			y = procurementSourceMapper.insertSelective(urecord);
			if(y != 1){
				throw new RuntimeException("CREATE ProcurementSource ERROR 10002:Procurementno : "+urv.getProcurementno());
			}
			PlanVO pv = new PlanVO();
			pv.setInvalid(String.valueOf(BaseStateEnum.VALID.getCode()));
			pv.setPlanstatus(String.valueOf(PlanStateEnum.PROCUREMENTSC.getCode()));
			pv.setFkProcurementno(urv.getProcurementno());
			pv.setSearchprice(planvo.getSearchprice());
			pv.setSearchmoney(planvo.getSearchmoney());
			PlanVO params = new PlanVO();
			params.setInvalid(String.valueOf(BaseStateEnum.VALID.getCode()));
			params.setPlanstatus(String.valueOf(PlanStateEnum.CLAIMED.getCode()));
			planActivity.savePlans(pv, planNos, params,null);
		}else{
			List<String> planNo = new ArrayList<String>();
			for(PlanVO p : planVOList){
				planNo.add(p.getPlanno());
			}
			Map<String,List<String>> map = this.getDiffrent(paramsNos, planNo);
			List<String> same = map.get("same");
			if(same!=null && !same.isEmpty()){
				PlanVO tpv = new PlanVO();
				tpv.setInvalid(String.valueOf(BaseStateEnum.VALID.getCode()));
				tpv.setPlanstatus(String.valueOf(PlanStateEnum.PROCUREMENTSC.getCode()));
				tpv.setPlannoList(same);
				List<PlanVO> samePlanList = planActivity.findByVO(tpv, uv);
				for(PlanVO p : samePlanList){
					String cd = DateFormatUtil.now2Str();
					urv.setUpdatetime(cd);
					urv.setProcurementno(p.getFkProcurementno());
					ProcurementSource urecord = mapper.map(urv, ProcurementSource.class);
					if(urecord==null)
						throw new RuntimeException("UPDATE ProcurementSource ERROR 10002:Procurement is null");
					y = procurementSourceMapper.updateByPrimaryKeySelective(urecord);
					if(y != 1){
						throw new RuntimeException("UPDATE ProcurementSource ERROR 10002:Procurementno : "+urv.getProcurementno());
					}
					p.setSearchprice(planvo.getSearchprice());
					p.setSearchmoney(planvo.getSearchmoney());
					y = planActivity.savePlan(p,false,uv);
					if(y != 1){
						throw new RuntimeException("UPDATE ProcurementSource ERROR 10002:Procurementno : "+urv.getProcurementno());
					}
					
				}
			}
			List<String> diff = map.get("diff");
			if(diff!=null && !diff.isEmpty()){
				urv.setProcurementno(UUIDHexGenerator.generator());
				urv.setInvalid(String.valueOf(BaseStateEnum.VALID.getCode()));
				String cd = DateFormatUtil.now2Str();
				urv.setCreatetime(cd);
				urv.setUpdatetime(cd);
				//System.out.println(urv);
				ProcurementSource urecord = mapper.map(urv, ProcurementSource.class);
				if(urecord==null)
					throw new RuntimeException("CREATE ERROR 10002:Procurement is null");
				y = procurementSourceMapper.insertSelective(urecord);
				if(y != 1){
					throw new RuntimeException("CREATE ProcurementSource ERROR 10002:Procurementno : "+urv.getProcurementno());
				}
				PlanVO pv = new PlanVO();
				pv.setInvalid(String.valueOf(BaseStateEnum.VALID.getCode()));
				pv.setPlanstatus(String.valueOf(PlanStateEnum.PROCUREMENTSC.getCode()));
				pv.setFkProcurementno(urv.getProcurementno());
				pv.setSearchprice(planvo.getSearchprice());
				pv.setSearchmoney(planvo.getSearchmoney());
				PlanVO params = new PlanVO();
				params.setInvalid(String.valueOf(BaseStateEnum.VALID.getCode()));
				params.setPlanstatus(String.valueOf(PlanStateEnum.CLAIMED.getCode()));
				planActivity.savePlans(pv,diff.toArray(new String[diff.size()]), params,null);				
			}
		}
		
		
				
		return y;
	}
	public int save(ProcurementSourceVO urv){
		
		if(urv == null)
			return 0;
		String cd = DateFormatUtil.now2Str();
		urv.setUpdatetime(cd);
		System.out.println(urv);
		ProcurementSource record = mapper.map(urv, ProcurementSource.class);
		if(record==null)
			throw new RuntimeException("UPDATE ERROR 10003:Procurement is null");
		
		ProcurementSourceExample ue = new ProcurementSourceExample();
		ue.or().andProcurementnoEqualTo(urv.getProcurementno());
		
		return procurementSourceMapper.updateByExampleSelective(record, ue);
	}	
	public Pager<ProcurementSourceVO> findAll(int offset,int limit){
		ProcurementSourceExample ue = null;
		if(offset>=0 && limit>0){
			ue =new ProcurementSourceExample();
			ue.setOffset(offset);
			ue.setLimit(limit);
			ue.or();
		}
		Pager<ProcurementSourceVO> pager = new  Pager<ProcurementSourceVO>();
		pager.setTotalNum(procurementSourceMapper.countByExample(null));
		List<ProcurementSource> ul = procurementSourceMapper.selectByExample(ue);
		List<ProcurementSourceVO> uvl = new ArrayList<ProcurementSourceVO>();
		for(ProcurementSource u : ul){
			ProcurementSourceVO uv = mapper.map(u, ProcurementSourceVO.class);
			
			uvl.add(uv);
		}
		pager.setPageList(uvl);
		return pager;
	}
	public Pager<ProcurementSourceVO> findByVO(ProcurementSourceVO vo,int offset,int limit){
		if(vo==null)
			return findAll(offset,limit);
		ProcurementSourceExample ue = new ProcurementSourceExample();
		ue.or();
		if(offset>=0 && limit>0){
			ue.setOffset(offset);
			ue.setLimit(limit);
		}
		if(vo.getProcurementname()!=null && StringUtils.isEmpty(vo.getProcurementname())){
			ue.or().andProcurementnameLike(vo.getProcurementname());
		}
		if(vo.getProcurementwaycode()!=null && StringUtils.isEmpty(vo.getProcurementwaycode())){
			ue.or().andProcurementwaycodeEqualTo(vo.getProcurementwaycode());
		}
		if(vo.getProcurementauditdate()!=null && StringUtils.isEmpty(vo.getProcurementauditdate())){
			ue.or().andProcurementauditdateEqualTo(vo.getProcurementauditdate());
		}
		if(vo.getBnumber()!=null && StringUtils.isEmpty(vo.getBnumber())){
			ue.or().andBnumberLike(vo.getBnumber());
		}
		if(vo.getFnumber()!=null && StringUtils.isEmpty(vo.getFnumber())){
			ue.or().andFnumberLike(vo.getFnumber());
		}
		if(vo.getSearchannounceddate()!=null && StringUtils.isEmpty(vo.getSearchannounceddate())){
			ue.or().andSearchannounceddateEqualTo(vo.getSearchannounceddate());
		}
		if(vo.getSearchauditdate()!=null && StringUtils.isEmpty(vo.getSearchauditdate())){
			ue.or().andSearchauditdateEqualTo(vo.getSearchauditdate());
		}
		if(vo.getExecutionwaycode()!=null && StringUtils.isEmpty(vo.getExecutionwaycode())){
			ue.or().andExecutionwaycodeEqualTo(vo.getExecutionwaycode());
		}
		if(vo.getFkDeptno()!=null && StringUtils.isEmpty(vo.getFkDeptno())){
			ue.or().andFkDeptnoEqualTo(vo.getFkDeptno());
		}
		if(vo.getFkUserno()!=null && StringUtils.isEmpty(vo.getFkUserno())){
			ue.or().andFkUsernoEqualTo(vo.getFkUserno());
		}
		Pager<ProcurementSourceVO> pager = new  Pager<ProcurementSourceVO>();
		pager.setTotalNum(procurementSourceMapper.countByExample(ue));
		List<ProcurementSource> ul = procurementSourceMapper.selectByExample(ue);
		List<ProcurementSourceVO> uvl = new ArrayList<ProcurementSourceVO>();
		for(ProcurementSource u : ul){
			ProcurementSourceVO uv = mapper.map(u, ProcurementSourceVO.class);
			
			uvl.add(uv);
		}
		pager.setPageList(uvl);
		return pager;
	}
	private static Map<String,List<String>> getDiffrent(List<String> list1, List<String> list2) {  
//        long st = System.nanoTime();  
        List<String> diff = new ArrayList<String>();
        List<String> same = new ArrayList<String>();
        List<String> maxList = list1;  
        List<String> minList = list2;  
        if (list2.size() > list1.size()) {  
            maxList = list2;  
            minList = list1;  
        }  
        // 将List中的数据存到Map中   
        Map<String, Integer> maxMap = new HashMap<String, Integer>(maxList.size());  
        for (String string : maxList) {  
            maxMap.put(string, 1);  
        }  
        // 循环minList中的值，标记 maxMap中 相同的 数据2   
        for (String string : minList) {  
            // 相同的   
            if (maxMap.get(string) != null) {  
                maxMap.put(string, 2);
                same.add(string);
                continue;
            }  
            // 不相等的  
            diff.add(string);  
        }  
        // 循环maxMap   
        for (Map.Entry<String, Integer> entry : maxMap.entrySet()) {  
            if (entry.getValue() == 1) {  
                diff.add(entry.getKey());  
            }
        }
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        map.put("diff", diff);
        map.put("same", same);
//      System.out.println("getDiffrent5 total times " + (System.nanoTime() - st));  
        return map;  
    }  
}
