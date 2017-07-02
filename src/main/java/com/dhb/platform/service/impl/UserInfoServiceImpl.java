package com.dhb.platform.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.dhb.platform.dao.JbdpUserMapper;
import com.dhb.platform.entity.JbdpUser;
import com.dhb.platform.entity.User;
import com.dhb.platform.service.IUserInfoService;

@Service
public class UserInfoServiceImpl implements IUserInfoService {
	
	@Resource
	JdbcTemplate jdbcTemplate;
	
	@Resource
	JbdpUserMapper dao;
	
	/**
	 * jdbcTemplate
	 */
	@Override
	public User loginUser(String name, String passwd) {
	    final String sql = "select * from user where name=? and passwd=?";
	    User user = null;
	    try{
	        user = jdbcTemplate.queryForObject(sql, new Object[]{name,passwd}, new BeanPropertyRowMapper<User>(User.class));
	        return user;
	    }catch(Exception ex){
	        System.out.print("select user by name and passwd error:"+ex);
	    }
	    return user;
	}
	
	public JbdpUser loginUserByMybatis(String userId,String password){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("password", password);
		JbdpUser user = dao.selectByIdAndPass(params);
		return user;
	}

	@Override
	public void addUser(String name, String passwd, String account) {
		/*
		 * 1.jdbcTemplate
		final String sql = "insert into user(name,passwd,sex,address,mem) values(?,?,?,?,?)";
		jdbcTemplate.update(sql, 
							new Object[]{name,passwd,account,address,mem},   
							new int[]{java.sql.Types.VARCHAR,java.sql.Types.VARCHAR,java.sql.Types.TINYINT,java.sql.Types.VARCHAR,java.sql.Types.VARCHAR});
		 */
		
		//2.mybatis
		JbdpUser jbdpUser = new JbdpUser();
		jbdpUser.setAccount(account);
		jbdpUser.setPassword(passwd);
		jbdpUser.setUserName(name);
		jbdpUser.setDelFlag((short) 1);
		jbdpUser.setState((short) 1);
		jbdpUser.setJbdpType("EMPLOYEE");
		jbdpUser.setTargetId("8a8a82eb56e3fc310156e3fe7a050002");
		int row = dao.insert(jbdpUser);
		String userid = jbdpUser.getUserId();
		System.out.println(row+"------------------"+userid);
	}
	
    @Override
    public List<User> getAllUsers() {
        final String sql = "select * from user order by id";
        List<User> userList = (List<User>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }
    
    @Override
    public List<JbdpUser> getAllUsersByMybatis(){
    	List<JbdpUser> userList = dao.selectAllUsersByMybatis();
    	return userList;
    }


	@Override
	public JbdpUser getUserById(String userId) {
		JbdpUser user = dao.selectByPrimaryKey(userId);
		return user;
	}
	
	
	@Override
	public List<JbdpUser> getUsersByParam(Map<String, Object> params) {
		List<JbdpUser> userList = dao.selectUsersByParams(params);
		return userList;
	}
	

	@Override
	public boolean updateByPrimaryKey(JbdpUser user) {
		boolean flag = true;
		try{
			dao.updateByPrimaryKey(user);
		}catch(Exception ex){
			flag = false;
			ex.printStackTrace();
		}
		return flag;
	}

	@Override
	public void deleteUserById(String userId) {
		dao.deleteByPrimaryKey(userId);
	}
}
