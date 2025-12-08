package com.kutuphane.project.repository;



import java.util.List;
import com.kutuphane.project.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReposiyory extends JpaRepository<Book, Integer>{

	

}
