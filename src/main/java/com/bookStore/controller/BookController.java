package com.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.dao.MyBookListDao;
import com.bookStore.dto.Book;
import com.bookStore.dto.MyBookList;
import com.bookStore.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService service;

	@Autowired
	private MyBookListDao myBookListDao;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/book_register")
	public String bookRegister() {

		return "bookRegister";
	}

	@GetMapping("/avialable_book")
	public ModelAndView getAllBook() {

		List<Book> list = service.getAllBook();
		ModelAndView view = new ModelAndView();
		view.setViewName("bookList");
		view.addObject("book", list);
		return view;
	}

	@PostMapping("/save")
	public String addBook(@ModelAttribute Book book) {

		service.saveBook(book);

		return "redirect:/avialable_book";
	}

	@GetMapping("/my_books")
	public String getMyBooks(Model model) {

		List<MyBookList> list = myBookListDao.getAllMyBooks();
		model.addAttribute("book", list);
		return "myBooks";
	}

	@RequestMapping("/myList/{id}")
	public String getMyList(@PathVariable("id") int id) {

		Book b = service.getBookById(id);
		MyBookList myl = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
		myBookListDao.saveMyBooks(myl);

		return "redirect:/my_books";
	}

	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {

		Book b = service.getBookById(id);
		model.addAttribute("book", b);
		return "bookEdit";
	}

	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {

		service.deleteById(id);
		return "redirect:/avialable_book";
	}
}
