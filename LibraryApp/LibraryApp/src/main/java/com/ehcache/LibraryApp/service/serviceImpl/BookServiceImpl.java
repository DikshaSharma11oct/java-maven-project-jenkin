package com.ehcache.LibraryApp.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ehcache.LibraryApp.model.BookEntity;
import com.ehcache.LibraryApp.model.UserLoginEntity;
import com.ehcache.LibraryApp.model.response.BookResponseObject;
import com.ehcache.LibraryApp.repository.BookRepository;
import com.ehcache.LibraryApp.repository.UserRepository;
import com.ehcache.LibraryApp.service.BookService;

@Service
public class BookServiceImpl  implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public BookResponseObject getOneBookDetail(Long id) {
        BookEntity entity=bookRepository.findBybookId(id);
        return entity.getAsObject();
               
    }

    @Override
    public List<BookResponseObject> getAllBookDetail() {
        List<BookEntity> bookEntities = bookRepository.findAll();
        List<BookResponseObject> response = bookEntities.stream()
            .map(BookEntity -> {
                BookResponseObject getBookResponse = new BookResponseObject();
                getBookResponse.setBookId(BookEntity.getBookId());
                getBookResponse.setBookAuthor(BookEntity.getBookAuthor());
                getBookResponse.setBookName(BookEntity.getBookName());               
                return getBookResponse;
            })
            .collect(Collectors.toList());
        
        return response;
       
    }

    public String addUser(UserLoginEntity userInfo){
        userInfo.setUserPassword(passwordEncoder.encode(userInfo.getUserPassword()));
        userRepo.save(userInfo);
        return "user added to system";
    }
    
}
