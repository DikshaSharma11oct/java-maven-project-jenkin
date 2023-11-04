package com.contactUs.model.response;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContactUsResponseObject implements Serializable {
    
    private Long id;
    private String UserName;  
    private String emailId;   
    private Long mobileNumber;   
    private String address;    
    private Boolean ActiveInd;
    private Long createdBy;   
    private Long updatedBy;    
    private LocalDateTime createdDate;    
    private LocalDateTime updatedDate;
    
    
}
