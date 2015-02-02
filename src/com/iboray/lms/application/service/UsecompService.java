package com.iboray.lms.application.service;

import com.iboray.lms.domain.vo.UsecompVO;
import com.iboray.lms.userinterface.common.Pager;

public interface UsecompService {

	public UsecompVO findUsecompVOBYNo(String no);
	public int deleteByNos(String[] nos);
	public int create(UsecompVO urv);
	public int save(UsecompVO urv);
	public Pager<UsecompVO> findAll(int offset,int limit);
	public Pager<UsecompVO> findByVO(UsecompVO vo,int offset,int limit);
	
}
