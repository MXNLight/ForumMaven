package com.service.impl;

import java.util.List;

import com.mapper.UserMapper;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pojo.User;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	@Override
	public List<User> ReadAll() {
		List<User> list=userMapper.ReadAll();
		
		return list;
	}
	@Override
	public List<User> FindById(String id) {
		List<User> list=userMapper.FindById(id);
		return list;
	}
	@Override
	public Integer Insert(User user) {
		return userMapper.Insert(user);
	}
	@Override
	public Integer DeleteById(String id) {
		return userMapper.DeleteById(id);
	}
	@Override
	public Integer UpdateById(User user) {
		return userMapper.UpdateById(user);
	}

}
