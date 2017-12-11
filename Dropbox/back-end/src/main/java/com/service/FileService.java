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
        return fileRepository.findByFileOwner(documentOwner);
    }

    public void addFiles(Document document) {
        fileRepository.save(document);
    }
}
