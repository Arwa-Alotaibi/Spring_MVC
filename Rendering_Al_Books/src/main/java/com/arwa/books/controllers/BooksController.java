package com.arwa.books.controllers;

import java.util.List;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.arwa.books.models.Book;
import com.arwa.books.services.BookService;

@Controller
public class BooksController {
	    private final BookService bookService;
	    
	    public BooksController(BookService bookService) {
	        this.bookService = bookService;
	    }
	    
	    @RequestMapping("/books")
	    public String Display(Model model) {
	        List<Book> books = bookService.allBooks();
	        model.addAttribute("books", books);
	        return "index.jsp";
	    }
	    
	  
		//Ninja Bonus: Make each title a link that navigates to the details page for that particular book :).
		@RequestMapping(value="/books/{id}",method = RequestMethod.GET)
		public String DisplayInformation(Model model,@PathVariable("id") Long id) {
			Book book = bookService.findBook(id);
			model.addAttribute("book",book);
			return "show.jsp";
			
			
	}
}

