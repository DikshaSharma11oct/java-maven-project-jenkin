package com.ehcache.LibraryApp.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestObject {

    public Long bookId;
    @NotBlank(message="BookName can't be empty")
    public String BookName;
    public String BookAuthor;
    
}
