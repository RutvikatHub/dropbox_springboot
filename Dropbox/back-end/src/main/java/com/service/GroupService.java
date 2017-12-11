package com.service;

import com.entity.Groups;
import com.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    public List<Groups> getGroups(String username) {
        return groupRepository.findByOwner(username);
    }

    public void addGroups(Groups groups) {
        groupRepository.save(groups);
    }

    public void updateUsernames(Groups groups) {
        groupRepository.save(groups);
    }

    public void removeGroup(Groups groups) {
        groupRepository.delete(groups);
    }
}
