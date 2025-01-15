package com.Crud.Repo;

import java.util.List;

import com.Crud.Entity.User;

public interface Repo {
	
	public User createUser(User user);
	public User getUserById(Integer id);
	public List<User> getAllUsers();
	public User updateUser(Integer id,User user);
	public String deleteUser(Integer id);

}
