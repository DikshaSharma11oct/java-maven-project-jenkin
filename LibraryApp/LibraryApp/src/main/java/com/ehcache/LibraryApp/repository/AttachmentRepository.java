package com.ehcache.LibraryApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ehcache.LibraryApp.model.Attachment;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment,String>{
    
}
