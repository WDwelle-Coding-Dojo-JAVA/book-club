package com.wdwelle.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.wdwelle.bookclub.models.Book;
import com.wdwelle.bookclub.services.MainService;

@Controller
public class BookController {
	
	@Autowired
	private MainService mainService;
	
	@GetMapping("/books/add")
	public String newBookForm(@ModelAttribute("book")Book book, HttpSession session) {	
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		return "addBook.jsp";
	}
	
	@PostMapping("/books/add")
	public String processCreateBook(@Valid @ModelAttribute("book")Book book, 
			BindingResult result, HttpSession session){
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			return "addBook.jsp";
		}else {
			mainService.saveBook(book);
			return "redirect:/books";
		}
	}
	
	@GetMapping("/books/{id}/edit")
	public String editBookForm(@PathVariable("id")Long id, HttpSession session, Model model) {
		Book book = mainService.findOneBook(id);
		Long userId = (Long) session.getAttribute("userId");
		if(!book.getAuthor().getId().equals(userId)) {
			return "redirect:/books";
		}
		model.addAttribute("book", book);
		return "editBook.jsp";
	}
	
	@PutMapping("/books/{id}/edit")
	public String processEditProject(@Valid @ModelAttribute("project")Book book, 
			BindingResult result, HttpSession session){
		Long userId = (Long) session.getAttribute("userId");
		if(!book.getAuthor().getId().equals(userId)) {
			return "redirect:/books";
		}
		if(result.hasErrors()) {
			return "editBook.jsp";
		}else {
			mainService.editBook(book);
			return "redirect:/books";
		}
	}
	
	@DeleteMapping("/books/{id}/delete")
	public String bookDelete(@PathVariable("id")Long id, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		mainService.deleteBook(id);
		return "redirect:/books";
		
	}
	
	@GetMapping("/books/{id}")
	public String showOneBook(@PathVariable("id")Long id,Model model,  HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		Book book = mainService.findOneBook(id);
		model.addAttribute("book", book);
		return "showBook.jsp";
		
	}
}
