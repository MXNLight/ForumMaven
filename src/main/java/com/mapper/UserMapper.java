package com.mapper;

import java.util.List;

import com.github.abel533.mapper.Mapper;
import com.pojo.User;

public interface UserMapper extends Mapper<User>{
	public List<User> ReadAll();
	public List<User> FindById(String id);
	public Integer Insert(User user);
	public Integer DeleteById(String id);
	public Integer UpdateById(User user);
}
