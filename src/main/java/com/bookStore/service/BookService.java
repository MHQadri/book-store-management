package com.bookStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.dao.BookDao;
import com.bookStore.dto.Book;

@Service
public class BookService {

	@Autowired
	private BookDao bookDao;

	/*
	 * save book
	 */
	public void saveBook(Book book) {

		bookDao.saveBook(book);
	}

	/*
	 * getAllBooks
	 */
	public List<Book> getAllBook() {

		return bookDao.getAllBook();
	}

	public Book getBookById(int id) {

		return bookDao.getBookById(id);
	}

	public void deleteById(int id) {
		
		bookDao.deleteById(id);
	}
}
