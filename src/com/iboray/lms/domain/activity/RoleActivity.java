package com.iboray.lms.domain.activity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.dozer.Mapper;

import com.iboray.lms.domain.entity.MResource;
import com.iboray.lms.domain.entity.MResourceExample;
import com.iboray.lms.domain.entity.MResourceRole;
import com.iboray.lms.domain.entity.MResourceRoleExample;
import com.iboray.lms.domain.entity.Role;
import com.iboray.lms.domain.entity.RoleExample;
import com.iboray.lms.domain.entity.enums.BaseStateEnum;
import com.iboray.lms.domain.vo.MResourceRoleVO;
import com.iboray.lms.domain.vo.MResourceVO;
import com.iboray.lms.domain.vo.RoleVO;
import com.iboray.lms.infrastructure.dao.MResourceMapper;
import com.iboray.lms.infrastructure.dao.MResourceRoleMapper;
import com.iboray.lms.infrastructure.dao.RoleMapper;
import com.iboray.lms.infrastructure.utils.DateFormatUtil;
import com.iboray.lms.infrastructure.utils.UUIDHexGenerator;

public class RoleActivity {
	
	static Logger logger = Logger.getLogger(RoleActivity.class);
	
	private RoleMapper roleMapper;
	private Mapper mapper ;
	private MResourceRoleMapper mResourceRoleMapper;
	
	private MResourceMapper  mResourceMapper;
	
	public List<RoleVO> findAll(){
		return findByExample(null);
	}
	public RoleVO findByNo(String no){
		logger.info("METHOD : RoleActivity.findByNo");
		RoleExample mre = new RoleExample();
		mre.or().andRolenoEqualTo(no);
		Role r = roleMapper.selectByNo(no);
		RoleVO rv = null;
		if(r!=null)
			rv = mapper.map(r, RoleVO.class);
		return rv;
	}
	private List<RoleVO> findByExample(RoleExample mre){
		logger.info("METHOD : RoleActivity.findByExample");
		List<Role> RoleList = roleMapper.selectByExample(mre);
		List<RoleVO> RoleVOList = new ArrayList<RoleVO>();
		for(Role r : RoleList){
			RoleVOList.add(mapper.map(r, RoleVO.class));
		}
		return RoleVOList;
	}
	public int createRole(RoleVO rv){
		logger.info("METHOD : RoleActivity.createRole");
		if(rv.getRolename()==null || rv.getRolevalue() ==null || StringUtils.isEmpty(rv.getRolename()) || StringUtils.isEmpty(rv.getRolevalue()))
			throw new RuntimeException("CREATE ERROR 10003:rolename or rolevalue  is required");
		rv.setRoleno(UUIDHexGenerator.generator());
		rv.setInvalid(String.valueOf(BaseStateEnum.VALID.getCode()));
		String cd = DateFormatUtil.now2Str();
		rv.setCreatetime(cd);
		rv.setUpdatetime(cd);
		Role record = mapper.map(rv, Role.class);
		if(record==null)
			throw new RuntimeException("CREATE ERROR 10002:role is null");
		
		return roleMapper.insertSelective(record);
	}
	public Set<MResourceVO> findMResourceByRoleNo(String RoleNo){
		logger.info("METHOD : RoleActivity.findMResourceByRoleNo");
		MResourceRoleExample mrre = new MResourceRoleExample();
		mrre.or().andFkRolenoEqualTo(RoleNo);
		List<MResourceRole> mResourceRoles =  mResourceRoleMapper.selectByExample(mrre);
		List<MResource> mResourceList = new ArrayList<MResource>();
		for(MResourceRole mrr : mResourceRoles){
			MResourceExample mre = new MResourceExample();
			mre.or().andMresourcenoEqualTo(mrr.getFkMresourceno());
			List<MResource> mResources = new ArrayList<MResource>();
			mResources = mResourceMapper.selectByExample(mre);
			mResourceList.addAll(mResources);
		}
		Set<MResource> mResourceSet = new HashSet<MResource>(mResourceList);
		Set<MResourceVO> mResourceVOSet = new HashSet<MResourceVO>();
		for(Iterator<MResource> it = mResourceSet.iterator();it.hasNext();){
			mResourceVOSet.add(mapper.map(it.next(), MResourceVO.class));
		}
		return mResourceVOSet;
	}
	public int createRoleMResource(MResourceRoleVO mr) {
		logger.info("METHOD : RoleActivity.createRoleMResource");
		RoleVO rv = mr.getRoleVO();
		Set<MResourceVO> mrSet = mr.getMresourceVOs();
		if(mrSet==null || mrSet.size()<1 || rv==null || StringUtils.isEmpty(rv.getRoleno())){
			throw new RuntimeException("CREATE ERROR 4001: role or resource invalid");
		}
		for(Iterator<MResourceVO> it = mrSet.iterator();it.hasNext(); ){
			MResourceRole record = new MResourceRole();
			record.setInvalid(String.valueOf(BaseStateEnum.VALID.getCode()));
			String cd = DateFormatUtil.now2Str();
			record.setCreatetime(cd);
			record.setUpdatetime(cd);
			record.setFkMresourceno(it.next().getMresourceno());
			record.setFkRoleno(rv.getRoleno());
			mResourceRoleMapper.insert(record);
		}
		return 1;
	}
	public int deleteRoleByRoleNo(String roleNo){
		MResourceRoleExample mre = new MResourceRoleExample();
		mre.or().andFkRolenoEqualTo(roleNo);
		return mResourceRoleMapper.deleteByExample(mre);
	}
	public RoleMapper getRoleMapper() {
		return roleMapper;
	}
	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}
	public Mapper getMapper() {
		return mapper;
	}
	public void setMapper(Mapper mapper) {
		this.mapper = mapper;
	}
	public static void main(String[] args) {
		System.out.println();
		
	}
	public MResourceRoleMapper getmResourceRoleMapper() {
		return mResourceRoleMapper;
	}
	public void setmResourceRoleMapper(MResourceRoleMapper mResourceRoleMapper) {
		this.mResourceRoleMapper = mResourceRoleMapper;
	}
	public MResourceMapper getmResourceMapper() {
		return mResourceMapper;
	}
	public void setmResourceMapper(MResourceMapper mResourceMapper) {
		this.mResourceMapper = mResourceMapper;
	}

	
}
