package com.bookStore.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookStore.dto.MyBookList;
import com.bookStore.repository.MyBookRepository;

@Repository
public class MyBookListDao {
	
	@Autowired
	private MyBookRepository myBookRepository;
	
	public void saveMyBooks(MyBookList book) {
		
		myBookRepository.save(book);
	}
	
	public List<MyBookList> getAllMyBooks(){
		
		return myBookRepository.findAll();
	}
	
	public void deleteById(int id) {
		
		myBookRepository.deleteById(id);
	}
}
