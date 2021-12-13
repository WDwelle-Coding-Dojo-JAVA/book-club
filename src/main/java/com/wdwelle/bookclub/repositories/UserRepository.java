package com.wdwelle.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wdwelle.bookclub.models.User;
public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findAll();
}
