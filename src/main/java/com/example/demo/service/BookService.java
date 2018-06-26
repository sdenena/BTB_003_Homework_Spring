package com.example.demo.service;

import com.example.demo.model.Book;

import java.util.List;

public interface BookService {
	List<Book> getAllRecord();
	
	Book findOneRecord(Integer id);
	
	boolean create(Book book);
	
	boolean update(Book book);
	
	boolean delete(Integer id);
	
}
