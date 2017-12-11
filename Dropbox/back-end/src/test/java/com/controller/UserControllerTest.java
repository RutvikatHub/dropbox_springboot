package com.controller;

import com.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserControllerTest {

    @Autowired
    private UserService userService;

    @Test
    public void login() {
        Assert.assertNotNull("Must return files for specified username", userService.login("a@b.com","b"));
    }
}
