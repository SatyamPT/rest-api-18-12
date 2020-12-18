package com.ssi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssi.entities.Book;
import com.ssi.service.BookService;

@RestController
@RequestMapping("book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@DeleteMapping(value="{id}",produces="application/json")
	public Book saveBook(@PathVariable("id") int code) {
		Book book=bookService.deleteBookByCode(code);
		return book;
	}
	
	@PutMapping(produces="application/json", consumes="application/json")
	public Book changeBook(@RequestBody Book book) {
		bookService.saveBook(book);
		return book;
	}
	
	@PostMapping(produces="application/json", consumes="application/json")
	public Book saveBook(@RequestBody Book book) {
		bookService.saveBook(book);
		return book;
	}
	
	@GetMapping(value="json/{low}/{high}", produces="application/json")
	public List<Book> getAllBooksAsJsonInPriceRange(@PathVariable("low") int min, @PathVariable("high") int max){
		return bookService.getAllBooksInPriceRange(min,max);
	}
	@GetMapping(value="json", produces="application/json")
	public List<Book> getAllBooksAsJson(){
		return bookService.getAllBooks();
	}
	@GetMapping(value="xml", produces="application/xml")
	public List<Book> getAllBooksAsXml(){
		return bookService.getAllBooks();
	}
	@GetMapping(value="{id}")
	public String getSingleBook(@PathVariable("id") int code) {
		Book book=bookService.getBookByCode(code);
		return book.toString();
	}

	@GetMapping(value="json/{id}", produces="application/json")
	public Book getSingleBookAsJson(@PathVariable("id") int code) {
		Book book=bookService.getBookByCode(code);
		return book;
	}


	@GetMapping(value="xml/{id}", produces="application/xml")
	public Book getSingleBookAsXml(@PathVariable("id") int code) {
		Book book=bookService.getBookByCode(code);
		return book;
	}

	/*
	public List<Book> getAllBooks(){
		return null;
	}
	
	public String addNewBook() {
		
	}
	
	public String updateBook() {
		
	}
	
	public String deleteBook() {
		
	}
	*/
}
