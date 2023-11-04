package com.contactUs.service.impl;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.contactUs.exception.EntityNotFoundException;
import com.contactUs.model.entity.ContactUsEntity;
import com.contactUs.model.request.ContactUsRequestObject;
import com.contactUs.model.response.ContactUsResponse;
import com.contactUs.model.response.ContactUsResponseObject;
import com.contactUs.repository.ContactUsRepository;
import com.contactUs.service.ContactUsService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ContactUsServiceImpl implements ContactUsService{

    @Autowired
    private ContactUsRepository contactUsRepository;

    @Override
    public ContactUsResponseObject createContacts(ContactUsRequestObject contactUsRequestObject) {

        ContactUsEntity contactUsEntitity =new ContactUsEntity();

        contactUsEntitity.setActiveInd(contactUsRequestObject.getActiveInd());
        contactUsEntitity.setUserName(contactUsRequestObject.getUserName());
        contactUsEntitity.setAddress(contactUsRequestObject.getAddress());
        contactUsEntitity.setCreatedBy(contactUsRequestObject.getCreatedBy());
        contactUsEntitity.setCreatedDate(LocalDateTime.now());
        contactUsEntitity.setEmailId(contactUsRequestObject.getEmailId());
        contactUsEntitity.setMobileNumber(contactUsRequestObject.getMobileNumber());

        ContactUsEntity savedEntity=contactUsRepository.save(contactUsEntitity);
        ContactUsResponseObject response=new ContactUsResponseObject();

        if(savedEntity!=null){
            
            response=savedEntity.getasobject();

        }
        return response;

       
    }

    @Override
    public ContactUsResponse getAllContact(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<ContactUsEntity> pageContacts=contactUsRepository.findAll(pageable);
		List<ContactUsEntity> allContacts = pageContacts.getContent();
		ContactUsResponse contactUsResponse = new ContactUsResponse();
        contactUsResponse.setContactUsResponseObject(null);
        contactUsResponse.setContacts(allContacts);
        contactUsResponse.setPageNo(pageContacts.getNumber());
        contactUsResponse.setPageSize(pageContacts.getSize());
        contactUsResponse.setTotalElement(pageContacts.getTotalElements());
        contactUsResponse.setTotalPages(pageContacts.getTotalPages());
        contactUsResponse.setLast(pageContacts.isLast());
        return contactUsResponse;
 
    }

    @Override
    @CacheEvict(cacheNames = "contactUs",key="#id")
    public void deleteContact(Long id) {
        ContactUsEntity contactactUsEntity = contactUsRepository.findById(id).get();
        if(contactactUsEntity==null){
            throw new EntityNotFoundException(HttpStatus.NOT_FOUND,"USER Not FOUND");

        }

       contactUsRepository.delete(contactactUsEntity);

       
    }

    @Override
    @CachePut(cacheNames = "contactUs",key="#contactUsRequestObject.id")
    public ContactUsResponseObject updateContacts(ContactUsRequestObject contactUsRequestObject) {
      ContactUsEntity contactactUsEntity = contactUsRepository.findById(contactUsRequestObject.getId()).get();
       if(contactactUsEntity==null){
            throw new EntityNotFoundException(HttpStatus.NOT_FOUND,"USER Not FOUND");

        }

        contactactUsEntity.setActiveInd(contactUsRequestObject.getActiveInd());
        contactactUsEntity.setUserName(contactUsRequestObject.getUserName());
        contactactUsEntity.setAddress(contactUsRequestObject.getAddress());
        contactactUsEntity.setUpdatedBy(contactUsRequestObject.getUpdatedBy());
        contactactUsEntity.setUpdatedDate(LocalDateTime.now());
        contactactUsEntity.setEmailId(contactUsRequestObject.getEmailId());
        contactactUsEntity.setMobileNumber(contactUsRequestObject.getMobileNumber());

        ContactUsEntity savedEntity=contactUsRepository.save(contactactUsEntity);
        ContactUsResponseObject response=new ContactUsResponseObject();

        if(savedEntity!=null){
            
            response=savedEntity.getasobject();

        }
        return response; 

        
    }

    @Override
    @Cacheable(cacheNames = "contactUs",key="#id")
    public ContactUsResponseObject getOneRecord(Long id) {
        log.info("getting details from db");
        ContactUsEntity contactactUsEntity = contactUsRepository.findById(id).get();
        ContactUsResponseObject response=contactactUsEntity.getasobject();
        return response;

    
    }

    @Override
    public ContactUsResponse getAllContacts(Long id) {
        return contactUsRepository.getContactinfo(id);
      
    }

   
    
}
