package com.Crud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Crud.Entity.User;
import com.Crud.Service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping("/post")
	public ResponseEntity<User> createUser(@RequestBody User u)
	{
		User user = service.createUser(u);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
    	User userById = service.getUserById(id);
        return new ResponseEntity<User>(userById,HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<User>> getAllUsers() {
       List<User> allUsers = service.getAllUsers();
       return new ResponseEntity<>(allUsers,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user) {
    	User updateUser = service.updateUser(id, user);
		return new ResponseEntity<User>(updateUser,HttpStatus.OK);
       
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        String deleteUser = service.deleteUser(id);
        return new ResponseEntity<>(deleteUser, HttpStatus.OK);
    }

	
	

}
