package com.example.demo.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Book {
	//@NotNull
	private Integer id;
//	@Size(min=5,max=255)
//	@Email
	private String title;
	private String author;
	private String publisher;
	private String thumbnail;

	private Category category;
	
	public Book() {}

	@Override
	public String toString() {
		return "Book{" +
				"id=" + id +
				", title='" + title + '\'' +
				", author='" + author + '\'' +
				", publisher='" + publisher + '\'' +
				", thumbnail='" + thumbnail + '\'' +
				", category=" + category +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Book(@NotNull Integer id, @Size(min = 5, max = 255) @Email String title, String author, String publisher, String thumbnail, Category category) {

		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.thumbnail = thumbnail;
		this.category = category;
	}
}
