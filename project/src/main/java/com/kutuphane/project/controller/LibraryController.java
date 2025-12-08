package com.kutuphane.project.controller;

import com.kutuphane.project.entity.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kutuphane.project.service.LibraryService;

@RestController
@RequestMapping("/api")//bütün endpointler /api ile başlar
public class LibraryController {
	
	@Autowired
	private LibraryService libraryService;
	
	
	//listeler
	@GetMapping("/books")
public List<Book> getBooks(){
	return libraryService.getAllBooks();
	
}
	
	//ekler
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		return libraryService.addBook(book);
		
	}
	
	//ödünc (stock_conrole prosedürünü çalıştırıyoruz)
	@PostMapping("/borrow")
	public ResponseEntity<String>borrowBook(@RequestParam Integer userId,@RequestParam int bookId ){
		try {//hatayı ayıklıyoruz
			libraryService.borrowBook(userId, bookId);
			return ResponseEntity.ok("stok kontrol edildi. Ödünc alma işlemi gerçeklesti");
		}catch (Exception e) {
			return ResponseEntity.badRequest().body("hata:"+e.getMessage());
			
		}
		
		
	}
		
	
	@PostMapping("/return/{loanId}")
	public ResponseEntity<String> returnBook(@PathVariable int loanId){
	try {
		libraryService.returnBook(loanId);
		return ResponseEntity.ok("kitap iade edildi.Eğer gecikme yapmışsa ceza tablosuna işlendi");
		
	}catch (Exception e) {
return ResponseEntity.badRequest().body("hata:"+ e.getMessage());
	}
	
	
	
	
	}
	
	
	
	}
	
	
	
	



	

