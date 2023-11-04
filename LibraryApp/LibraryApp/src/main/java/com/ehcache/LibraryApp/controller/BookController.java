package com.ehcache.LibraryApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ehcache.LibraryApp.model.UserLoginEntity;
import com.ehcache.LibraryApp.model.response.BookResponseObject;
import com.ehcache.LibraryApp.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/welcome")
    public String welCome(){
        return "Welcome to book Controller";
    }

    @GetMapping("/getbook")
    public String getOneBookdetail(){
        return "Welcome to book Controller for authorized user";
    }

    @GetMapping("/getbook/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")  //to use these annotation use @EnableMethodSecurity
    public ResponseEntity<BookResponseObject> getOneBookDetail(@PathVariable("id") Long id){
        BookResponseObject response=bookService.getOneBookDetail(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);       
    }
    
    @GetMapping("/getAllbook")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<List<BookResponseObject>> getAllBookDetail(){
       List<BookResponseObject> response=bookService.getAllBookDetail();
        return ResponseEntity.status(HttpStatus.OK).body(response);       
    }

    @PostMapping("/addUser")
    public String addNewUser(@RequestBody UserLoginEntity userLoginEntity){
       return  bookService.addUser(userLoginEntity);

    }

    
    
}
