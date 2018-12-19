package com.service;

import java.util.List;

import com.pojo.User;

public interface UserService {
	public List<User> ReadAll();
	public List<User> FindById(String id);
	public Integer Insert(User user);
	public Integer DeleteById(String id);
	public Integer UpdateById(User user);
}
