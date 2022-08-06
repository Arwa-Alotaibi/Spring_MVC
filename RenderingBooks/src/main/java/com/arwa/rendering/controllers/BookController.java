package com.arwa.rendering.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.arwa.rendering.models.Book;

import com.arwa.rendering.repositories.BookRepository;
import com.arwa.rendering.services.BookService;

@Controller 
public class BookController {	
	@Autowired
	BookService bookService;
	
	
	
	//Add a route in your controller for "/books/3",
	//where the number is a variable for the ID of the book.
	
	@RequestMapping(value="/books/{id}",method = RequestMethod.GET)
	public String DisplayInformation(Model model,@PathVariable("id") Long id) {
		Book book = bookService.findBook(id);
		
		model.addAttribute("book",book);
		
		return "show.jsp";
		
		
	}
}
