package com.iboray.lms.domain.activity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.dozer.Mapper;

import com.iboray.lms.domain.entity.MResource;
import com.iboray.lms.domain.entity.MResourceExample;
import com.iboray.lms.domain.entity.enums.BaseStateEnum;
import com.iboray.lms.domain.vo.MResourceVO;
import com.iboray.lms.infrastructure.dao.MResourceMapper;
import com.iboray.lms.infrastructure.utils.DateFormatUtil;
import com.iboray.lms.infrastructure.utils.UUIDHexGenerator;

public class MResourceActivity {
	static Logger logger = Logger.getLogger(MResourceActivity.class.getName());
	private MResourceMapper mResourceMapper;
	private Mapper mapper ;
	
	public List<MResourceVO> findAll() {
		return findByExample(null);
	}
	public List<MResourceVO> findByFk_No(String fkno){
		if(fkno == null || StringUtils.isEmpty(fkno)){
			logger.info("findByFNo: No is null");
			return null;
		}
		MResourceExample mre = new MResourceExample();
		mre.or().andFkMresourcenoEqualTo(fkno);
		return findByExample(mre);
	}
	public List<MResourceVO> findAllParentMResource(){
		MResourceExample mre = new MResourceExample();
		mre.or().andFkMresourcenoIsNull();
		return findByExample(mre);
	}
	
	private List<MResourceVO> findByExample(MResourceExample mre){
		List<MResource> resourceList = mResourceMapper.selectByExample(mre);
		List<MResourceVO> resourceVOList = new ArrayList<MResourceVO>();
		for(MResource r : resourceList){
			resourceVOList.add(mapper.map(r, MResourceVO.class));
		}
		
		List<MResourceVO> mrls = new ArrayList<MResourceVO>();
		for(MResourceVO mr : resourceVOList){
			Set<MResourceVO> mrSet = null;
			List<MResourceVO> mrlchildren = findByFK_No(mr.getMresourceno());
			MResourceVO parentMResourceVO = findByNo(mr.getFkMresourceno());
			if(parentMResourceVO!=null)
				mr.setMresourceVOParent(parentMResourceVO);
			if(mrlchildren!=null && mrlchildren.size() > 0){
				mrSet = new HashSet<MResourceVO>();
				mrSet.addAll(mrlchildren);
//				List<MResourceVO> mrll = new ArrayList<MResourceVO>(mrSet);
//				mr.setMrls(mrll);
				mr.setMresourceVOSet(mrSet);
			}
			mrls.add(mr);
		}
		return mrls;
	}
	private List<MResourceVO> findByFK_No(String FK_No){
		if(FK_No == null || StringUtils.isEmpty(FK_No))
			return null;
		MResourceExample mre = new MResourceExample();
		mre.or().andFkMresourcenoEqualTo(FK_No);
		List<MResource> resourceList = mResourceMapper.selectByExample(mre);
		List<MResourceVO> resourceVOList = new ArrayList<MResourceVO>();
		for(MResource r : resourceList){
			resourceVOList.add(mapper.map(r, MResourceVO.class));
		}
		return resourceVOList;
	}
	public MResourceVO findByNo(String no){
		if(no == null || StringUtils.isEmpty(no))
			return null;
		return mapper.map(mResourceMapper.selectByNo(no), MResourceVO.class);
	}
	public int createMResource(MResourceVO uv){
		uv.setMresourceno(UUIDHexGenerator.generator());
		uv.setInvalid(String.valueOf(BaseStateEnum.VALID.getCode()));
		String cd = DateFormatUtil.now2Str();
		uv.setCreatetime(cd);
		uv.setUpdatetime(cd);
		MResource record = mapper.map(uv, MResource.class);
		if(record==null)
			throw new RuntimeException("CREATE ERROR 30002:MResource is null");
		
		return mResourceMapper.insertSelective(record);
	}
	
	
	public MResourceMapper getmResourceMapper() {
		return mResourceMapper;
	}
	public void setmResourceMapper(MResourceMapper mResourceMapper) {
		this.mResourceMapper = mResourceMapper;
	}
	public Mapper getMapper() {
		return mapper;
	}
	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}
	
	
}
