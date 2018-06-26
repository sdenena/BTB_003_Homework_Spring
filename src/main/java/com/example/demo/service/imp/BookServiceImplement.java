package com.example.demo.service.imp;

import com.example.demo.model.Book;
import com.example.demo.repositories.BookRepository;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImplement implements BookService {
	private BookRepository bookRepository;
	@Autowired
	public BookServiceImplement(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@Override
	public List<Book> getAllRecord() {
		return this.bookRepository.getRecord();
	}

	@Override
	public Book findOneRecord(Integer id) {
		return this.bookRepository.findOneRecord(id);
	}

	@Override
	public boolean create(Book book) {
		return this.bookRepository.create(book);
	}

	@Override
	public boolean update(Book book) {
		return this.bookRepository.update(book);
	}

	@Override
	public boolean delete(Integer id) {
		return this.bookRepository.delete(id);
	}
}
