package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import com.example.demo.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BookController {
	private BookService bookService;

	@Autowired
	private UploadService uploadService;

	@Autowired
	public BookController(BookService bookService) {
		super();

		this.bookService = bookService;
	}
	
	@GetMapping({"/","/index"})
	public String getIndex(Model model) {
		List<Book> bookList=this.bookService.getAllRecord();
		System.out.println(bookList.get(0).getThumbnail());
		model.addAttribute("books", bookList);
		return "book/index";
	}
	
	@GetMapping("view/{id}")
	public String view(@PathVariable("id") Integer id, Model model) {
		System.out.println("ID"+id);
		Book book=this.bookService.findOneRecord(id);
		model.addAttribute("book",book);
		return "book/view-detail";
	}
	
	@GetMapping("/update-book/{id}")
	public String showFormupdate(@PathVariable Integer id, Model model) {
		System.out.println(id);
		Book book=this.bookService.findOneRecord(id);
		model.addAttribute("book",book);
		return "book/update-book";
	}
	@PostMapping("update/submit")
	public String updateSubmit(@ModelAttribute Book book,BindingResult bindingResult, MultipartFile file) {
		String fileName=this.uploadService.singleFileUpload(file,null);

		System.out.println(fileName);
		book.setThumbnail("/btb/"+fileName);
		if(bindingResult.hasErrors()) {
			return "book/update-book";
		}
		System.out.println(book);
		System.out.println(book);
		this.bookService.update(book);
		return "redirect:/index";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		System.out.println(id);
		this.bookService.delete(id);
		return "redirect:/index";
	}
	
	
	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("book",new Book());
		return "book/create-book";
	}
	@PostMapping("/create-book/submit")
	public String create(@Valid Book book, BindingResult bindingResult, MultipartFile file) {
		String fileName=this.uploadService.singleFileUpload(file,null);

		System.out.println(fileName);
		book.setThumbnail("/btb/"+fileName);
		if(bindingResult.hasErrors()) {
			return "book/create-book";
		}
		System.out.println(book);
		this.bookService.create(book);
		return "redirect:/index";
	}
}
