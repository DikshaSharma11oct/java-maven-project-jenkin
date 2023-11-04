package com.ehcache.LibraryApp.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData {
   
    private String FileName;
    private String fileType;
    private Long  fileSize;
    private String downloadUrl;
    

    
}
