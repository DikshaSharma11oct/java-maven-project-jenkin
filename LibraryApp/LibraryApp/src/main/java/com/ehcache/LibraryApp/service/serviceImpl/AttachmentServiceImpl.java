package com.ehcache.LibraryApp.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ehcache.LibraryApp.model.Attachment;
import com.ehcache.LibraryApp.repository.AttachmentRepository;
import com.ehcache.LibraryApp.service.AttachmentService;


@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    private AttachmentRepository attachmentRepository;

    @Override
    public Attachment saveAttachment(MultipartFile file) throws Exception {
       String fileName= StringUtils.cleanPath(file.getOriginalFilename());
       try{
        //any invalid character
        if(fileName.contains("..")){
            throw new Exception("fileName contains invalid path" +fileName);
        }
        Attachment attachment=
            new Attachment(fileName,file.getContentType(),file.getBytes());
            return attachmentRepository.save(attachment);

       }
       catch(Exception e){

        throw new Exception("couldn't save file" +fileName);


       }
      
    }

    @Override
    public Attachment getAttachment(String fieldId) throws Exception {
       return attachmentRepository.
            findById(fieldId).
            orElseThrow(()-> new Exception("FileName not found:" +fieldId));
    }

    
}
