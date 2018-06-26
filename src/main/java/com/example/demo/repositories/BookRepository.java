package com.example.demo.repositories;

import com.example.demo.model.Book;
import com.example.demo.repositories.provider.BookProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository {
	////@Select("select *from tbbook ORDER BY id ASC") use mybatish inline
	@SelectProvider(type = BookProvider.class,method = "getAllProvider")
	List<Book> getRecord();

	///@Select("SELECT *FROM tbbook b INNER JOIN category c ON b.cat_id=c.id WHERE b.id=#{id}")
	@Select("SELECT * FROM tbbook WHERE id=#{id}")
	public Book findOneRecord(Integer id);

	//@Update("UPDATE tbbook SET title=#{title},author=#{author},publisher=#{publisher},thumnail=#{thumnail}} WHERE id=#{id}")

	@UpdateProvider(type = BookProvider.class,method = "updateBook")
	public boolean update(Book book);

	@Delete("DELETE FROM tbbook WHERE id=#{id}")
	public boolean delete(Integer id);

	//@Insert("INSERT INTO tbbook(title,author,publisher) VALUES(#{title},#{author},#{publisher})")
	@InsertProvider(type = BookProvider.class,method = "createNewBook")
	public boolean create(Book book);

//	Faker faker=new Faker();
//
//	List<Book> bookList=new ArrayList<>();
//	{
//		for(int i=1;i<11;i++) {
//			Book book=new Book();
//
//			book.setId(i);
//			book.setTitle(faker.book().title());
//			book.setAuthor(faker.book().author());
//			book.setPublisher(faker.book().publisher());
//
//			bookList.add(book);
//		}
//	}
//
//	public List<Book> getRecord(){
//		return this.bookList;
//	}
//
//	public Book findOneRecord(Integer id) {
//		for(int i=0;i<bookList.size();i++) {
//			if(bookList.get(i).getId()==id) {
//				return bookList.get(i);
//			}
//		}
//		return null;
//	}
//
//	public boolean update(Book book) {
//		for(int i=0;i<bookList.size();i++) {
//			if(bookList.get(i).getId()==book.getId()) {
//				bookList.set(i, book);
//				return true;
//			}
//		}
//		return false;
//	}
//	public boolean delete(Integer id) {
//		for(int i=0;i<bookList.size();i++) {
//			if(bookList.get(i).getId()==id) {
//				bookList.remove(i);
//				return true;
//			}
//		}
//		return false;
//	}
//
//	public boolean create(Book book) {
//		bookList.add(book);
//		return true;
//	}
	
	
	
}
