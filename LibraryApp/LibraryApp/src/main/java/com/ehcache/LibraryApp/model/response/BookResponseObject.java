package com.ehcache.LibraryApp.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseObject {

    public Long bookId;
    public String BookName;
    public String BookAuthor;
    
}
