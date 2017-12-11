package com.repository;

import com.entity.Groups;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupRepository extends CrudRepository<Groups, Long>{
    List<Groups> findByOwner(String username);


}

