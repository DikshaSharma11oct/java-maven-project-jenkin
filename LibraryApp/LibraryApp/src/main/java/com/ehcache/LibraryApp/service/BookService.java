package com.ehcache.LibraryApp.service;

import java.util.List;

import com.ehcache.LibraryApp.model.UserLoginEntity;
import com.ehcache.LibraryApp.model.response.BookResponseObject;

public interface BookService {

    public BookResponseObject getOneBookDetail(Long id);

    public List<BookResponseObject> getAllBookDetail();

    public String addUser(UserLoginEntity userLoginEntity);
    
}
