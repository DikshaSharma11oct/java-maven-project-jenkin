package com.ehcache.LibraryApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ehcache.LibraryApp.model.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity,Long> {

    BookEntity findBybookId(Long id);

    
    
}
