package com.Crud.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Crud.Entity.User;
import com.Crud.Repo.Repo;
import com.Crud.Repo.UserRepo;

@Service
public class UserService implements Repo {
	@Autowired
	private UserRepo repo;

	@Override
	public User createUser(User user) {
	
		return repo.save(user);
	}

	@Override
	public User getUserById(Integer id) {
		User u=null;
		Optional<User> byId = repo.findById(id);
		if(byId.isPresent())
		{
		u=byId.get();
		
		}
		return u;
		
		
	}

	@Override
	public List<User> getAllUsers() {

		return repo.findAll();
	}

	@Override
	public User updateUser(Integer id, User user) {
		User u=getUserById(id);
		u.setName(user.getName());
		u.setEmail(user.getEmail());
		u.setAge(user.getAge());
		
		
		return repo.save(u);
	}

	@Override
	public String deleteUser(Integer id) {
		repo.deleteById(id);
		return "deleted successfully";
		
	}
	
	 

}
