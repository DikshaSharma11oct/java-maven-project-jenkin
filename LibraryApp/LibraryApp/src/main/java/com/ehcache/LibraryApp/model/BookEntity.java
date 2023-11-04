package com.ehcache.LibraryApp.model;

import com.ehcache.LibraryApp.model.response.BookResponseObject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="book_table")
@Entity
public class BookEntity {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    public Long bookId;
    public String BookName;
    public String BookAuthor;


    //set response Object
    public BookResponseObject getAsObject(){
        BookResponseObject response=new BookResponseObject();
        response.setBookId(this.bookId);
        response.setBookAuthor(this.BookAuthor);
        response.setBookName(this.BookName);

        return response;

    }
    
}
