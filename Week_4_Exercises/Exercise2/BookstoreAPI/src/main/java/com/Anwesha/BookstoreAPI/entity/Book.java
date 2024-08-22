package com.Anwesha.BookstoreAPI.entity;



import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Book {

	private long id;
	private String title;
	private String author;
	private double price;
	private String isbn;
}
