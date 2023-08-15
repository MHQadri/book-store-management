package com.bookStore.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MyBooks")
public class MyBookList {

	@Id
	@Column(name = "book_id")
	private int id;
	private String name;
	private String author;
	private String price;
}
