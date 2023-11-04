package com.ehcache.LibraryApp.service;

import org.springframework.web.multipart.MultipartFile;

import com.ehcache.LibraryApp.model.Attachment;

public interface AttachmentService {

    Attachment saveAttachment(MultipartFile file) throws Exception;

    Attachment getAttachment(String fieldId) throws Exception;
    
}
