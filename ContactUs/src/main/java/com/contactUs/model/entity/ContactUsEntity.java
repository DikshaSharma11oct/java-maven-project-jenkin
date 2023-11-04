package com.contactUs.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;



import com.contactUs.model.response.ContactUsResponseObject;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;
 import lombok.Data;

@Data
@Table
@Entity
@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(name="firstProcedure",procedureName = "get_All_Contacts", 
    parameters={@StoredProcedureParameter(mode=ParameterMode.IN,name="contact_id",type=Long.class)})})
public class ContactUsEntity implements Serializable{

    @Id
    //@Column(name="CONTACT_US_ID")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;    
    private String UserName; 
    private String emailId;  
    private long mobileNumber;
    private String address;    
    private Boolean ActiveInd;   
    private Long createdBy;
    private Long updatedBy;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;


//create a response using builder
    public ContactUsResponseObject getasobject(){
        ContactUsResponseObject.ContactUsResponseObjectBuilder builder=ContactUsResponseObject.builder()
                                                                        .ActiveInd(this.ActiveInd)
                                                                        .id(this.id)
                                                                        .UserName(this.UserName)
                                                                        .address(this.address)
                                                                        .createdBy(this.createdBy)
                                                                        .createdDate(this.createdDate)
                                                                        .emailId(this.emailId)
                                                                        .mobileNumber(this.mobileNumber)
                                                                        .updatedBy(this.updatedBy)
                                                                        .updatedDate(this.updatedDate);
       return builder.build();                                                                 
                                                                        
    }   
    //https://www.youtube.com/watch?v=MZe1HbHQq78&ab_channel=Appdev

}