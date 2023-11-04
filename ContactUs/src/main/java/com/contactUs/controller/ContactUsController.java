package com.contactUs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.contactUs.model.request.ContactUsRequestObject;
import com.contactUs.model.response.ContactUsResponse;
import com.contactUs.model.response.ContactUsResponseObject;
import com.contactUs.repository.ContactUsRepository;
import com.contactUs.service.ContactUsService;

@RestController
@RequestMapping("/contactus")
public class ContactUsController {

    @Autowired
    private ContactUsService contactUsservice;

    // @Autowired
    // private ContactUsRepository contactUsRepo;

    @PostMapping("/create-contacts")
    public ResponseEntity<ContactUsResponseObject> createContacts(@RequestBody ContactUsRequestObject contactUsRequestObject ){
        ContactUsResponseObject contactsResponse=contactUsservice.createContacts(contactUsRequestObject);
        return  ResponseEntity.status(HttpStatus.CREATED).body(contactsResponse);

    }
    // localhost:9010/contactus/getAllcontacts
	// localhost:9010/contactus/getAllcontacts?pageNo=0&pageSize=5&sortBy=id&sortDir=asc
    @GetMapping("/getAllcontacts")
    public ResponseEntity<ContactUsResponse> getAllContacts(@RequestParam(value = "pageNo") int pageNo,@RequestParam(value = "pageSize") int pageSize,@RequestParam(value = "sortBy") String sortBy,@RequestParam(value = "sortDir") String sortDir){
        ContactUsResponse contactsResponse=contactUsservice.getAllContact(pageNo, pageSize, sortBy, sortDir);
        return  ResponseEntity.status(HttpStatus.OK).body(contactsResponse);

    }

    @GetMapping("/getContactsAll/{id}")
    public ResponseEntity<ContactUsResponse> getAllContact(@PathVariable("id") Long id){
        ContactUsResponse contactService=contactUsservice.getAllContacts(id);
        return  ResponseEntity.status(HttpStatus.OK).body(contactService);

    }

    @GetMapping("/deleteContacts/{id}")
    public ResponseEntity<String> deleteContacts(@PathVariable("id")Long id){
        contactUsservice.deleteContact(id);
        return  ResponseEntity.status(HttpStatus.OK).body("User Info gets deleted successfully");

    }

    @PutMapping("/updateContacts/{id}")
    public ResponseEntity<ContactUsResponseObject> getAllContacts(@PathVariable("id") Long id,@RequestBody ContactUsRequestObject contactUsRequestObject){
        ContactUsResponseObject contactsResponse=contactUsservice.updateContacts(contactUsRequestObject);
        return  ResponseEntity.status(HttpStatus.OK).body(contactsResponse);

    }

    @GetMapping("/getOneContact/{id}")
    public ResponseEntity<ContactUsResponseObject> getOneContact(@PathVariable("id")Long id){
        ContactUsResponseObject contactsResponse=contactUsservice.getOneRecord(id);
        return  ResponseEntity.status(HttpStatus.OK).body(contactsResponse);

    }


    
}
