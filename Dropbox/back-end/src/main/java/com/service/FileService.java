package com.service;

import com.entity.Document;
import com.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {
    @Autowired
    private FileRepository fileRepository;

    public List<Document> getFiles(String documentOwner) {
        return fileRepository.findByUsername(documentOwner);
    }

    public void addFiles(Document document) {
        fileRepository.save(document);
    }

    public void removeFiles(Document document) {
        fileRepository.delete(document);
    }

    public void starFiles(Document document) {
        fileRepository.save(document);
    }

}
