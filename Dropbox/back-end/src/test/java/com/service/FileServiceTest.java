package com.service;

import com.entity.Document;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class FileServiceTest {

    @Autowired
    private FileService fileService;

    @org.junit.Test
    public void getFiles() {
        List<Document> list = fileService.getFiles("a@b.com");
        Assert.assertNotNull("Must return files for specified username", list);
    }

    @org.junit.Test
    public void addFiles() {
    }
}
