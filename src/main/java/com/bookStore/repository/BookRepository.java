package com.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookStore.dto.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
