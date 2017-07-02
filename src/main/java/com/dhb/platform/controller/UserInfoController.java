package com.dhb.platform.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dhb.platform.entity.JbdpUser;
import com.dhb.platform.service.IUserInfoService;

@Controller
@RequestMapping("/user")
public class UserInfoController {
    
    @Resource
    IUserInfoService userInfoService;
    
    @Resource
    HttpServletRequest request;

    String loginPageUrl = "login";
    String successPageUrl = "moduleIndex";
    String addUrl = "user/adduser";
    String upUrl = "user/upduser";
    
    @RequestMapping("/toadd")
    public ModelAndView toAdd(){
        return new ModelAndView(addUrl);
    }

    @RequestMapping("/adduser")
    public ModelAndView addUser(){
        String name = request.getParameter("name");
        String passwd = request.getParameter("passwd");
        String account = request.getParameter("account");
        userInfoService.addUser(name, passwd, account);
        return getAllUsers();
    }
    
    @RequestMapping("/toupdate")
    public ModelAndView toUpUser(){
    	String userId = request.getParameter("id");
    	JbdpUser user = userInfoService.getUserById(userId);
    	return new ModelAndView(upUrl,"user",user);
    }
    
    @RequestMapping("/update")
    public ModelAndView upUser(){
    	String userid = request.getParameter("id");
    	JbdpUser user = userInfoService.getUserById(userid);
        user.setUserName(request.getParameter("name"));
        user.setPassword(request.getParameter("passwd"));
        user.setAccount(request.getParameter("account"));
    	boolean flag = userInfoService.updateByPrimaryKey(user);
//    	if(!flag){
//    		return new ModelAndView(upUrl,"user",user);
//    	}
    	return getAllUsers();
    }
    
    @RequestMapping("/tosearch")
    public ModelAndView toSearchUser(){
    	String uname = request.getParameter("uname");
    	String uaccount = request.getParameter("uaccount");
    	if(StringUtils.isBlank(uname))
    		uname = "";
    	if(StringUtils.isBlank(uaccount))
    		uaccount = "";
    	Map<String,Object> params = new HashMap<String,Object>();
    	params.put("uname", uname);
    	params.put("uaccount", uaccount);
    	
    	List<JbdpUser> users = (List<JbdpUser>) userInfoService.getUsersByParam(params);
        return new ModelAndView(successPageUrl,"users",users);
    }
    
    @RequestMapping("/getall")
    public ModelAndView getAllUsers(){
        List<JbdpUser> users = (List<JbdpUser>) userInfoService.getAllUsersByMybatis();
        return new ModelAndView(successPageUrl,"users",users);
    }
    
    @ResponseBody
    @RequestMapping("/getjson")
    public List<JbdpUser> getUserToJson(){
        List<JbdpUser> users = (List<JbdpUser>) userInfoService.getAllUsersByMybatis();
        return users;
    }
    
    @RequestMapping("/delete")
    public ModelAndView delUserById(HttpServletRequest request){
        String userId = request.getParameter("id");
        userInfoService.deleteUserById(userId);
        return getAllUsers();
    }

}