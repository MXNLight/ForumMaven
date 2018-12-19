package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.UserService;
import com.pojo.*;

@Controller
@RequestMapping("/")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/list")
	public String User(Model model){
		List<User> list=userService.ReadAll();
		model.addAttribute("list", list);
		return "list";
	}
	
	@RequestMapping("/listone")
	public String Userone(HttpServletRequest request,Model model){
		String id=request.getParameter("selectid");
		List<User> list=userService.FindById(id);
		model.addAttribute("list", list);
		return "listone";
	}
	@RequestMapping("/insert")
	public String Add(@ModelAttribute("user")User user,Model model){
		if(userService.Insert(user) != null){
		List<User> list=userService.ReadAll();
		model.addAttribute("list", list);
		return "list";
		}
		else 
			return null;
	}
	
	@RequestMapping("/delete")
	public String Delete(HttpServletRequest request,Model model){
		if(userService.DeleteById(request.getParameter("deleteid")) != null){
		List<User> list=userService.ReadAll();
		model.addAttribute("list", list);
		return "list";
		}
		else 
			return null;
	}
	
	@RequestMapping("/updateindex")
	public String findone(HttpServletRequest request,Model model){
		String id=request.getParameter("updateid");
		List<User> list=userService.FindById(id);
		for(User user:list){
			model.addAttribute("user", user);//反正只有这么一个，我才不管呢
		}
		return "update";
	}
	@RequestMapping("/update")
	public String Update(@ModelAttribute("user")User user,Model model){
		if(userService.UpdateById(user) != null){
			List<User> list=userService.ReadAll();
			model.addAttribute("list", list);
			return "list";
		}
		else 
			return null;
		
	}
	
}
