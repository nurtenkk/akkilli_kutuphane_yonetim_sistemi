package com.kutuphane.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import com.kutuphane.project.entity.Loan;
import org.springframework.transaction.annotation.Transactional;

public interface LoanRepository extends JpaRepository<Loan, Integer>{
//stok kontrolü yapıp varsa düşer ve loan tablosuna ekler
	@Modifying //delete update gibi işlemler olduğu için
	@Transactional//hata olursa yapılanı geri alır
	@Query(value = "CALL stock_controle(:userId,:bookId)",nativeQuery = true)
	void callStockControle(@Param("userId")int userId,@Param("bookId") int bookId);
	
	
	
	//iade tarihi ve ceza hesaplar
	@Modifying 
	@Transactional
	@Query(value = "CALL return_book_fines(:loanId)", nativeQuery = true)
	void callReturnBookFines(@Param("loanId")int loanId);

	

}
