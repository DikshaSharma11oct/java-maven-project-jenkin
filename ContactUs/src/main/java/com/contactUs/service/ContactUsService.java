package com.contactUs.service;

import com.contactUs.model.request.ContactUsRequestObject;
import com.contactUs.model.response.ContactUsResponse;
import com.contactUs.model.response.ContactUsResponseObject;

public interface ContactUsService {

    //methods are public default
    ContactUsResponseObject createContacts(ContactUsRequestObject contactUsRequestObject);

    //Get All Contacts
    ContactUsResponse getAllContact(int pageno, int pagesize, String sortBy, String sortDir);
    //stored Procedure
     ContactUsResponse getAllContacts(Long id);

    //deleteContact
    void deleteContact(Long id);

    //getOnerecord
    ContactUsResponseObject getOneRecord(Long id);

    //updateContactUs
    ContactUsResponseObject updateContacts(ContactUsRequestObject contactUsRequestObject);


    
}
