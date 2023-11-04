package com.contactUs.model.request;

import java.time.LocalDateTime;

// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactUsRequestObject {

    private Long id; 
    @NotBlank(message="username can't be empty")
    private String UserName;
    @NotBlank(message="emaild can't  be empty")
    private String emailId; 
    @NotBlank(message="Please enter 10 digit mobile number")
    private Long mobileNumber;
    @NotBlank(message="Please enter address")
    private String address;
    @NotBlank(message="ActiveInd can't be null")
    private Boolean ActiveInd;
    //String type-> use notBlank and for Long->UseNotNull
    @NotNull(message="CreatedBy can't be Blank")
    private Long createdBy;
    @NotNull(message="Updated can't be Blank")
    private Long updatedBy;
    @NotBlank(message="Please enter 10 digit mobile number")
    private LocalDateTime createdDate;
    @NotBlank(message="Please enter 10 digit mobile number")
    private LocalDateTime updatedDate;
    
}
