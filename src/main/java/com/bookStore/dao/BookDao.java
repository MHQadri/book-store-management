package com.bookStore.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookStore.dto.Book;
import com.bookStore.repository.BookRepository;

@Repository
public class BookDao {

	@Autowired
	private BookRepository bookRepository;

	/*
	 * save book
	 */
	public void saveBook(Book book) {

		bookRepository.save(book);
	}

	/*
	 * getAllBooks
	 */
	public List<Book> getAllBook() {

		return bookRepository.findAll();
	}

	public Book getBookById(int id) {

		return bookRepository.findById(id).get();
	}
	
	public void deleteById(int id) {
		
		bookRepository.deleteById(id);
	}

}
