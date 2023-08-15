package com.bookStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookStore.dto.MyBookList;

public interface MyBookRepository extends JpaRepository<MyBookList, Integer>{

}
