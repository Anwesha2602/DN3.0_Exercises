package com.library.service;
import com.library.repository.BookRepository;

public class BookService {
	private BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}
	
	public void bookService() {
		System.out.println("Book servicing...");
		bookRepository.repositoryTask();
	}
}
