package com.iboray.lms.domain.activity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.dozer.Mapper;

import com.iboray.lms.domain.entity.MResource;
import com.iboray.lms.domain.entity.MResourceExample;
import com.iboray.lms.domain.entity.MResourceRole;
import com.iboray.lms.domain.entity.MResourceRoleExample;
import com.iboray.lms.domain.entity.User;
import com.iboray.lms.domain.entity.UserExample;
import com.iboray.lms.domain.entity.UserRole;
import com.iboray.lms.domain.entity.UserRoleExample;
import com.iboray.lms.domain.entity.enums.BaseStateEnum;
import com.iboray.lms.domain.vo.MResourceVO;
import com.iboray.lms.domain.vo.RoleVO;
import com.iboray.lms.domain.vo.UserRoleVO;
import com.iboray.lms.domain.vo.UserVO;
import com.iboray.lms.infrastructure.dao.MResourceMapper;
import com.iboray.lms.infrastructure.dao.MResourceRoleMapper;
import com.iboray.lms.infrastructure.dao.RoleMapper;
import com.iboray.lms.infrastructure.dao.UserMapper;
import com.iboray.lms.infrastructure.dao.UserRoleMapper;
import com.iboray.lms.infrastructure.utils.ArrayUtil;
import com.iboray.lms.infrastructure.utils.DateFormatUtil;
import com.iboray.lms.infrastructure.utils.UUIDHexGenerator;
import com.iboray.lms.userinterface.common.Pager;


public class UserActivity {

	static Logger logger = Logger.getLogger(UserActivity.class.getName());
	
	private UserMapper userMapper;
	
	private UserRoleMapper userRoleMapper;
	
	private MResourceRoleMapper mResourceRoleMapper;
	
	private RoleMapper roleMapper;
	
	private MResourceMapper  mResourceMapper;
	
	private Mapper mapper ;
	
	private RoleActivity roleActivity;

	public UserVO findUserByNameAndPwd(String name,String password){
		logger.info("UserActivity.findUserByNameAndPwd :" +  name + ":" + password);
		
		if(StringUtils.isEmpty(name)||StringUtils.isEmpty(password))
			throw new RuntimeException("UserName and Password is Required");
		
		UserExample ue = new UserExample();
		ue.or().andUsernameEqualTo(name).andPasswordEqualTo(password);
		List<User> users = new ArrayList<User>();
		users = userMapper.selectByExample(ue);
		if(users == null || users.size() == 0)
			throw new RuntimeException("UserName or Password is error");
		if(users.size()>1)
			throw new RuntimeException("Server ERROR:10001:There are many records by user");
		UserVO uv = mapper.map(users.get(0), UserVO.class);
		
		return uv;
	}
	public UserVO findUserByName(String name){
		logger.info("UserActivity.findUserByNameAndPwd :" +  name);
		
		if(StringUtils.isEmpty(name)){
			logger.error("UserName is null" +  name);
			return null;
		}
		UserExample ue = new UserExample();
		ue.or().andUsernameEqualTo(name);
		List<User> users = new ArrayList<User>();
		users = userMapper.selectByExample(ue);
		if(users == null || users.size() == 0)
			return null;
		if(users.size()>1){
			logger.error("SEARCH ERROR:There are many records by user" +  name);
			return null;
		}
		UserVO uv = mapper.map(users.get(0), UserVO.class);
		return uv;
	}

	public UserRoleVO findRolesByUserNo(String userNo){
		logger.info("UserActivity.findRolesByUserNo  params:userNo:"+userNo);
		List<UserRole> urs = findUserRoleByUserNo(userNo);
		if(urs==null || urs.size()==0)
			return null;
		List<RoleVO> roleList = new ArrayList<RoleVO>();
		List<MResource> mResourceList = new ArrayList<MResource>();
		for(UserRole ur : urs){
			
			roleList.add(mapper.map(roleMapper.selectByNo(ur.getFkRoleno()),RoleVO.class));
			
			MResourceRoleExample mrre = new MResourceRoleExample();
			mrre.or().andFkRolenoEqualTo(ur.getFkRoleno());
			List<MResourceRole> mResourceRoles = mResourceRoleMapper.selectByExample(mrre);
			for(MResourceRole mrr : mResourceRoles){
				MResourceExample mre = new MResourceExample();
				mre.or().andMresourcenoEqualTo(mrr.getFkMresourceno());
				List<MResource> mResources = new ArrayList<MResource>();
				mResources = mResourceMapper.selectByExample(mre);
				mResourceList.addAll(mResources);
			}
		}
		Set<RoleVO> roleSet = new HashSet<RoleVO>(roleList);
		Set<MResource> mResourceSet = new HashSet<MResource>(mResourceList);
		Set<MResourceVO> mResourceVOSet = new HashSet<MResourceVO>();
		for(Iterator<MResource> it = mResourceSet.iterator();it.hasNext();){
			mResourceVOSet.add(mapper.map(it.next(), MResourceVO.class));
		}
		UserRoleVO urv = new UserRoleVO();
		urv.setUserVO(findUserVOBYUserNo(userNo));
		urv.setRoleVOs(roleSet);
		urv.setMresourceVOs(mResourceVOSet);
		return urv;
	}
	public int createUser(UserRoleVO urv){
		UserVO uv = urv.getUserVO();
		if(uv == null)
			return 0;
		uv.setUserno(UUIDHexGenerator.generator());
		uv.setInvalid(String.valueOf(BaseStateEnum.VALID.getCode()));
		String cd = DateFormatUtil.now2Str();
		uv.setCreatetime(cd);
		uv.setUpdatetime(cd);
		User urecord = mapper.map(uv, User.class);
		if(urecord==null)
			throw new RuntimeException("CREATE ERROR 10002:user is null");
		userMapper.insertSelective(urecord);
		Set<RoleVO> roleSet = urv.getRoleVOs();
		if(roleSet!=null && roleSet.size()>0  ){
			for(Iterator<RoleVO> it = roleSet.iterator();it.hasNext(); ){
				UserRole record = new UserRole();
				record.setInvalid(String.valueOf(BaseStateEnum.VALID.getCode()));
				record.setCreatetime(cd);
				record.setUpdatetime(cd);
				record.setFkUserno(uv.getUserno());
				record.setFkRoleno(it.next().getRoleno());
				userRoleMapper.insert(record);
			}
		}
		return 1;
	}
	
	public Pager<UserVO> findAll(int offset,int limit){
		UserExample ue = null;
		if(limit>0){
			ue =new UserExample();
			ue.setOffset(offset);
			ue.setLimit(limit);
			ue.or();
		}
		Pager<UserVO> userPager = new  Pager<UserVO>();
		userPager.setTotalNum(userMapper.countByExample(null));
		List<User> ul = userMapper.selectByExample(ue);
		List<UserVO> uvl = new ArrayList<UserVO>();
		for(User u : ul){
			UserVO uv = mapper.map(u, UserVO.class);
			List<UserRole> urlist = findUserRoleByUserNo(uv.getUserno());
			if(urlist !=null && urlist.size()>0){
				Set<RoleVO> roleVOs  = new HashSet<RoleVO>();
				for(UserRole ur : urlist){
					RoleVO rv = roleActivity.findByNo(ur.getFkRoleno());
					if(rv!=null){
						roleVOs.add(rv);
					}
				}
				uv.setRoleVOs(roleVOs);
			}
			
			uvl.add(uv);
		}
		userPager.setPageList(uvl);
		return userPager;
		
	}
	private List<UserRole> findUserRoleByUserNo(String userNo){
		logger.info("UserActivity.findUserRoleByUserNo  params:userNo:"+userNo);
		if(StringUtils.isEmpty(userNo))
			return null;
		UserExample ue = new UserExample();
		ue.or().andUsernoEqualTo(userNo);
		User u = userMapper.selectByNo(userNo);
		if(u==null)
			throw new RuntimeException("userNo is not find");
		UserRoleExample ure = new UserRoleExample();
		ure.or().andFkUsernoEqualTo(userNo);
		List<UserRole> urs = userRoleMapper.selectByExample(ure);
		if(urs==null || urs.size()==0)
			return null;
		return urs;
	}
	private UserVO findUserVOBYUserNo(String userNo){
		logger.info("UserActivity.findUserRoleByUserNo  params:userNo:"+userNo);
		if(StringUtils.isEmpty(userNo))
			return null;
		UserExample ue = new UserExample();
		ue.or().andUsernoEqualTo(userNo);
		User u = userMapper.selectByNo(userNo);
		if(u==null)
			throw new RuntimeException("userNo is not find");
		return mapper.map(u, UserVO.class);
	}
	public int deleteByNos(String[] nos){
		User user = new User();
		user.setInvalid(String.valueOf(BaseStateEnum.DELETE.getCode()));
		UserExample ue = new UserExample();
		ue.or().andUsernoIn(ArrayUtil.Strs2List(nos));
		return userMapper.updateByExampleSelective(user, ue);
	}
	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public UserRoleMapper getUserRoleMapper() {
		return userRoleMapper;
	}

	public void setUserRoleMapper(UserRoleMapper userRoleMapper) {
		this.userRoleMapper = userRoleMapper;
	}

	public MResourceRoleMapper getmResourceRoleMapper() {
		return mResourceRoleMapper;
	}

	public void setmResourceRoleMapper(MResourceRoleMapper mResourceRoleMapper) {
		this.mResourceRoleMapper = mResourceRoleMapper;
	}

	public RoleMapper getRoleMapper() {
		return roleMapper;
	}

	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
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
	public RoleActivity getRoleActivity() {
		return roleActivity;
	}
	public void setRoleActivity(RoleActivity roleActivity) {
		this.roleActivity = roleActivity;
	}
	
}
