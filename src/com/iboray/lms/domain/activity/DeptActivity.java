package com.iboray.lms.domain.activity;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.dozer.Mapper;

import com.iboray.lms.domain.entity.Dept;
import com.iboray.lms.domain.entity.enums.BaseStateEnum;
import com.iboray.lms.domain.vo.DeptVO;
import com.iboray.lms.infrastructure.dao.DeptMapper;
import com.iboray.lms.infrastructure.utils.DateFormatUtil;
import com.iboray.lms.infrastructure.utils.UUIDHexGenerator;

public class DeptActivity {
	static Logger logger = Logger.getLogger(MResourceActivity.class.getName());
	private DeptMapper deptMapper;
	private Mapper mapper ;
	
	public List<DeptVO> findAll(){
		List<Dept> deptList = deptMapper.selectByExample(null);
		List<DeptVO> deptVOList = new ArrayList<DeptVO>();
		for(Dept r : deptList){
			deptVOList.add(mapper.map(r, DeptVO.class));
		}
		return deptVOList;
	}
	public int create(DeptVO dept){
		dept.setDeptno(UUIDHexGenerator.generator());
		dept.setInvalid(String.valueOf(BaseStateEnum.VALID.getCode()));
		String cd = DateFormatUtil.now2Str();
		dept.setCreatetime(cd);
		dept.setUpdatetime(cd);
		Dept record = mapper.map(dept, Dept.class);
		if(record==null)
			throw new RuntimeException("CREATE ERROR 30002:MResource is null");
		
		return deptMapper.insertSelective(record);
	}
	public DeptMapper getDeptMapper() {
		return deptMapper;
	}

	public void setDeptMapper(DeptMapper deptMapper) {
		this.deptMapper = deptMapper;
	}

	public Mapper getMapper() {
		return mapper;
	}

	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}
	
	
}
