package com.repository;

import com.entity.Document;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FileRepository extends CrudRepository<Document, Long>{
    List<Document> findByUsername(String documentOwner);
}

