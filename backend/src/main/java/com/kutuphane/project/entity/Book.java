package com.kutuphane.project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="books")
public class Book {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bookID")
	private int id;
	
	private String title;
	private int stock;
	
	@ManyToOne
	@JoinColumn(name="author_id")//foreign sütununu belirlledik
	private Author author;
	
	@ManyToOne
	@JoinColumn(name="categorie_id")
	private Category category;
}
