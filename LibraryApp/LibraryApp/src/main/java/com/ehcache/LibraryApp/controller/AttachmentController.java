package com.ehcache.LibraryApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ehcache.LibraryApp.model.Attachment;
import com.ehcache.LibraryApp.model.response.ResponseData;
import com.ehcache.LibraryApp.service.AttachmentService;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;

    //will create two methods 1.to upload the file 2.to download the file
    @PostMapping("/upload")
    public ResponseData uploadFile(@RequestParam("file") MultipartFile file) throws Exception{
        //file can be converted intobyte array and save in to database
        Attachment attachment=null;
        String downloadUrl="";
        attachment=attachmentService.saveAttachment(file);
        ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/download/")
            .path(attachment.getId())
            .toUriString();

        return new ResponseData(attachment.getFileName(), file.getContentType(), file.getSize(),downloadUrl);    

    }

    //make /download/ url to download the data
    @GetMapping("/download/{fieldId}")
    // @PreAuthorize("hasAuthority(ROLE_ADMIN)")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fieldId) throws Exception{
        Attachment attachment=null;
        attachment=attachmentService.getAttachment(fieldId);
        return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType(attachment.getFileType()))
            .header(HttpHeaders.CONTENT_DISPOSITION,"attachment;fileName=\"" +attachment.getFileName() +"\"")
            .body(new ByteArrayResource(attachment.getData()));

    }
    
}
