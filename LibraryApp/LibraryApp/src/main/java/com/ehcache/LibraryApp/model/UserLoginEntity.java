package com.ehcache.LibraryApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name=" User_Login")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginEntity {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String roles;
   
    
}
