package com.kutuphane.project.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment kullancağımızı söyler
    @Column(name="userID")
	private int id;
	private String username;
	private String password;
	private String email;
	private String role;
}
