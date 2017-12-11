package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;
    private String documentName;
    private String documentType;
    private String path;
    private String fileOwner;

    public Document() {

    }

    public Document(String username, String documentName, String documentType, String path, String fileOwner) {
        this.username = username;
        this.documentName = documentName;
        this.documentType = documentType;
        this.path = path;
        this.fileOwner = fileOwner;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileOwner() {
        return fileOwner;
    }

    public void setFileOwner(String fileOwner) {
        this.fileOwner = fileOwner;
    }
}
