package com.bookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookStore.dao.MyBookListDao;

@Controller
public class MyBookListController {

	@Autowired
	private MyBookListDao myBookListDao;
	
	@RequestMapping("/deleteMyList/{id}")
	public String deletMyList(@PathVariable("id") int id) {
		myBookListDao.deleteById(id);
		return "redirect:/my_books";
	}
}
