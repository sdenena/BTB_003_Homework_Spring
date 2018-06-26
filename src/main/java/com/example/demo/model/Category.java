package com.example.demo.model;

import java.util.List;

public class Category {
    private Integer id;
    private String name;

    public Category(){}
    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Category(int id, String name, List<Book> books) {

        this.id = id;
        this.name = name;
        this.books = books;
    }

    private List<Book> books;



}
