package com.contactUs.model.response;

import java.util.List;
import com.contactUs.model.entity.ContactUsEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContactUsResponse {

   private List<ContactUsResponseObject> ContactUsResponseObject;
   private List<ContactUsEntity> Contacts;
   private int pageNo;
   private int pageSize;
   private long totalElement;
   private int totalPages;
   private boolean last;
 
}

    

