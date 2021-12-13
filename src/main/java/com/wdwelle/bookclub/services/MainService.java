package com.wdwelle.bookclub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wdwelle.bookclub.models.Book;
import com.wdwelle.bookclub.models.User;
import com.wdwelle.bookclub.repositories.BookRepository;
import com.wdwelle.bookclub.repositories.UserRepository;



@Service
public class MainService {
	@Autowired
	BookRepository bookRepo;
	
	@Autowired
	UserRepository userRepo;
	
	public List<Book> allBooks(){
		return bookRepo.findAll();
	}
	public Book saveBook(Book book) {
		return bookRepo.save(book);
	}
	public User saveUser(User user) {
		return userRepo.save(user);
	}
}
