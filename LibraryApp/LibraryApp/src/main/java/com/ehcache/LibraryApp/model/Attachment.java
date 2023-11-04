package com.ehcache.LibraryApp.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Attachment {

    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid",strategy ="uuid2")
    private String id;

    private String FileName;
    private String fileType;
    @Lob
    //Can store first data into directory after that directory can store in db
    //can store the file on cloud and that cloud file can be stored later in db
    private byte[] data;

    public Attachment(String fileName, String fileType, byte[] data) {
        FileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }
    
}
