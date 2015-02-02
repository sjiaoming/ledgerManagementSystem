package com.iboray.lms.domain.activity;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.dozer.Mapper;

import com.iboray.lms.domain.entity.Usecomp;
import com.iboray.lms.domain.entity.UsecompExample;
import com.iboray.lms.domain.entity.enums.BaseStateEnum;
import com.iboray.lms.domain.vo.UsecompVO;
import com.iboray.lms.infrastructure.dao.UsecompMapper;
import com.iboray.lms.infrastructure.utils.ArrayUtil;
import com.iboray.lms.infrastructure.utils.DateFormatUtil;
import com.iboray.lms.infrastructure.utils.UUIDHexGenerator;
import com.iboray.lms.userinterface.common.Pager;

public class UsecompActivity {
static Logger logger = Logger.getLogger(UsecompActivity.class);
	
	private UsecompMapper usecompMapper;
	
	private Mapper mapper ;

	public void setUsecompMapper(UsecompMapper usecompMapper) {
		this.usecompMapper = usecompMapper;
	}

	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}
	
	public UsecompVO findUsecompVOBYNo(String no){
		logger.info("UsecompActivity.findUsecompVOBYNo  no:"+no);
		if(StringUtils.isEmpty(no))
			return null;
		UsecompExample ue = new UsecompExample();
		ue.or().andUsecompnoEqualTo(no);
		Usecomp u = usecompMapper.selectByNo(no);
		if(u==null)
			throw new RuntimeException("no is not find");
		return mapper.map(u, UsecompVO.class);
	}
	public int deleteByNos(String[] nos){
		Usecomp usecomp = new Usecomp();
		usecomp.setInvalid(String.valueOf(BaseStateEnum.DELETE.getCode()));
		UsecompExample ue = new UsecompExample();
		ue.or().andUsecompnoIn(ArrayUtil.Strs2List(nos));
		return usecompMapper.updateByExampleSelective(usecomp, ue);
	}
	public int create(UsecompVO urv){
		
		if(urv == null)
			return 0;
		urv.setUsecompno(UUIDHexGenerator.generator());
		urv.setInvalid(String.valueOf(BaseStateEnum.VALID.getCode()));
		String cd = DateFormatUtil.now2Str();
		urv.setCreatetime(cd);
		urv.setUpdatetime(cd);
		System.out.println(urv);
		Usecomp urecord = mapper.map(urv, Usecomp.class);
		if(urecord==null)
			throw new RuntimeException("CREATE ERROR 10002:Usecomp is null");
		
		return usecompMapper.insertSelective(urecord);
	}
	public int save(UsecompVO urv){
		
		if(urv == null)
			return 0;
		String cd = DateFormatUtil.now2Str();
		urv.setUpdatetime(cd);
		System.out.println(urv);
		Usecomp record = mapper.map(urv, Usecomp.class);
		if(record==null)
			throw new RuntimeException("UPDATE ERROR 10003:Usecomp is null");
		
		UsecompExample ue = new UsecompExample();
		ue.or().andUsecompnoEqualTo(urv.getUsecompno());
		
		return usecompMapper.updateByExampleSelective(record, ue);
	}	
	public Pager<UsecompVO> findAll(int offset,int limit){
		UsecompExample ue = null;
		if(offset>=0 && limit>0){
			ue =new UsecompExample();
			ue.setOffset(offset);
			ue.setLimit(limit);
			ue.or();
		}
		Pager<UsecompVO> pager = new  Pager<UsecompVO>();
		pager.setTotalNum(usecompMapper.countByExample(null));
		List<Usecomp> ul = usecompMapper.selectByExample(ue);
		List<UsecompVO> uvl = new ArrayList<UsecompVO>();
		for(Usecomp u : ul){
			UsecompVO uv = mapper.map(u, UsecompVO.class);
			
			uvl.add(uv);
		}
		pager.setPageList(uvl);
		return pager;
	}
	public Pager<UsecompVO> findByVO(UsecompVO vo,int offset,int limit){
		if(vo==null)
			return findAll(offset,limit);
		UsecompExample ue = new UsecompExample();
		ue.or();
		if(offset>=0 && limit>0){
			ue.setOffset(offset);
			ue.setLimit(limit);
		}
		if(vo.getSortname1()!=null && StringUtils.isEmpty(vo.getSortname1())){
			ue.or().andSortname1Like(vo.getSortname1());
		}
		if(vo.getSortname2()!=null && StringUtils.isEmpty(vo.getSortname2())){
			ue.or().andSortname2Like(vo.getSortname2());
		}
		if(vo.getUsecompname()!=null && StringUtils.isEmpty(vo.getUsecompname())){
			ue.or().andUsecompnameEqualTo(vo.getUsecompname());
		}
		if(vo.getUsecompcode()!=null && StringUtils.isEmpty(vo.getUsecompcode())){
			ue.or().andUsecompcodeEqualTo(vo.getUsecompcode());
		}
		Pager<UsecompVO> pager = new  Pager<UsecompVO>();
		pager.setTotalNum(usecompMapper.countByExample(ue));
		List<Usecomp> ul = usecompMapper.selectByExample(ue);
		List<UsecompVO> uvl = new ArrayList<UsecompVO>();
		for(Usecomp u : ul){
			UsecompVO uv = mapper.map(u, UsecompVO.class);
			
			uvl.add(uv);
		}
		pager.setPageList(uvl);
		return pager;
	}
}
