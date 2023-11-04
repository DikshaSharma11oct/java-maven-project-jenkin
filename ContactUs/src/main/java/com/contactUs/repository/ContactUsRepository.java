package com.contactUs.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.contactUs.model.entity.ContactUsEntity;
import com.contactUs.model.response.ContactUsResponse;



@Repository
public interface ContactUsRepository extends JpaRepository<ContactUsEntity,Long>{

    // @Autowired
    // EntityManager em;
     

    // public static List<ContactUsEntity> getContactinfo(Long input){
    //     return em.createNamedStoredProcedureQuery("firstProcedure").setParameter("contact_id",input).getResultList();
    // }

    @Procedure(name="firstProcedure")
    ContactUsResponse getContactinfo(@Param("contact_id") Long id);
    // @Procedure(name="get_All_Contacts")
    // ContactUsResponse getContactinfo(@Param("contact_id") Long id);


}
