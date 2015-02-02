package com.iboray.lms.application.service;

import java.util.List;

import com.iboray.lms.domain.vo.MResourceVO;

public interface MResourceService {
	
	public List<MResourceVO> findAll();

	public List<MResourceVO> findByFk_No(String fkno);
	
	public int createMResource(MResourceVO mResourceVO);
	
	public List<MResourceVO> findAllParentMResource();
	
	public MResourceVO findByNo(String no);
}
