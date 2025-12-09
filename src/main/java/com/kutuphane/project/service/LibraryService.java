package com.kutuphane.project.service;

import java.util.List;

import com.kutuphane.project.entity.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kutuphane.project.repository.BookReposiyory;
import com.kutuphane.project.repository.LoanRepository;

@Service
public class LibraryService {

	@Autowired //kendisi new nesne olusturur
	private BookReposiyory bookReposiyory;
	
	@Autowired
	private LoanRepository loanRepository;
	
	//kitapları getiriyoruz
	public List<Book> getAllBooks(){
		return (List<Book>) bookReposiyory.findAll();
	}
	
	//kitap ekliyoruz
	public Book addBook(Book book) {
		return bookReposiyory.save(book);
	}
	
	//kitap ödünc aldık
	public void borrowBook(Integer userId,Integer bookId) {
		loanRepository.callStockControle(userId, bookId);
	}
	
	//iade
	public void returnBook(int loanId) {
		loanRepository.callReturnBookFines(loanId);
	}
	
}
