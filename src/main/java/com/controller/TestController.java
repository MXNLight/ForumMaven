package com.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.User;
import com.service.UserService;

@Controller
@RequestMapping("/first")
public class TestController {
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/ajax")
	public String Ajax(String name) throws UnsupportedEncodingException{
		System.out.println(name);//已经成功接受到Allen这个值
		//model.addAttribute("name", name);
		return "欢迎Mr."+name;
	}

	
	@ResponseBody
	@RequestMapping("/ajaxclass")
	public User AjaxClass(@RequestBody User user){
		System.out.println(user.getLoginId()+"  "+user.getLoginPsd());//已经成功接受到Allen这个值
		//model.addAttribute("name", name);
		return user;
	}
}
