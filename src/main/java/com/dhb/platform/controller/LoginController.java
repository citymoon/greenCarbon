package com.dhb.platform.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.jasper.tagplugins.jstl.core.Redirect;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dhb.platform.entity.JbdpUser;
import com.dhb.platform.entity.User;
import com.dhb.platform.service.IUserInfoService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Resource
	HttpServletRequest request;
	
	@Resource
	IUserInfoService service;

//	@RequestMapping("/process")
//	public ModelAndView processLogin() {
//
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("message", "welcome,Hello World...............!");
//		// 设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
//		mv.setViewName("success");
//		return mv;
//
//	}
	
	@RequestMapping("/loginto")
	public ModelAndView valideLogin(Model model){
		String loginPageUrl = "index";
		String successPageUrl = "success";
		
		String uname = request.getParameter("userId");
		String upasswd = request.getParameter("password");
		model.addAttribute("userId", uname);
		model.addAttribute("password", upasswd);
		
		if(StringUtils.isBlank(uname)){
		    model.addAttribute("error", "用户名不能为空");
			return new ModelAndView(loginPageUrl,"model",model);
		}else if(StringUtils.isBlank(upasswd)){
		    model.addAttribute("error", "密码不能为空");
			return new ModelAndView(loginPageUrl, "model",model);
		}else{
			//jdbcTemplate
			//User user = service.loginUser(uname, upasswd);
			//mybatis
			JbdpUser user = service.loginUserByMybatis(uname, upasswd);
			if(null==user || StringUtils.isBlank(user.getUserId())){
			    model.addAttribute("error", "用户名或密码不匹配！");
				return new ModelAndView(loginPageUrl, "model",model);
			}else{ 
				//jdbcTemplate
				//return new ModelAndView(successPageUrl,"users",service.getAllUsers());
//				return new ModelAndView(successPageUrl,"users",service.getAllUsersByMybatis());
			    return new ModelAndView(successPageUrl);
			}
		}
	}
	
	@RequestMapping("/index")
	public ModelAndView index(){
		return new ModelAndView("index");
	}

}
