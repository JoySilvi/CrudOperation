package com.Crud.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Crud.Entity.User;

public interface UserRepo extends JpaRepository<User,Integer> {

}
