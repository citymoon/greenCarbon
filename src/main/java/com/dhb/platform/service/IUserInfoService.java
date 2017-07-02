package com.dhb.platform.service;

import java.util.List;
import java.util.Map;

import com.dhb.platform.entity.JbdpUser;
import com.dhb.platform.entity.User;

public interface IUserInfoService {
	
    public User loginUser(String name,String passwd);
    
    public JbdpUser loginUserByMybatis(String userId,String password);

    public void addUser(String name,String passwd,String account);
	
	public List<User> getAllUsers();
	
	public List<JbdpUser> getAllUsersByMybatis();
	
	public JbdpUser getUserById(String userId);
	
	public List<JbdpUser> getUsersByParam(Map<String, Object> map);
	
	public boolean updateByPrimaryKey(JbdpUser user);
	
	public void deleteUserById(String userId);

}
