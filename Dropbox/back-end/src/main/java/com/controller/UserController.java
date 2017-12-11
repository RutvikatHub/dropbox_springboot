package com.controller;

import com.entity.Groups;
import com.entity.User;
import com.entity.Document;
import com.service.FileService;
import com.service.GroupService;
import com.service.UserService;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.html.HTMLParagraphElement;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller    // This means that this class is a Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/user") // This means URL's start with /demo (after Application path)
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private FileService fileService;
    @Autowired
    private GroupService groupService;

    String absolutePath = System.getProperty("user.dir");

    @PostMapping(path="/signup",consumes = MediaType.APPLICATION_JSON_VALUE) // Map ONLY POST Requests
    public  ResponseEntity<?> addNewUser (@RequestBody User user) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        userService.addUser(user);
        System.out.println("Saved");

        Map res_message = new HashMap();

        //status 201 for created
        res_message.put("status", 201);

        new File(absolutePath + "\\src\\main\\public\\uploads\\" + user.getUsername()).mkdir();

        //return new ResponseEntity(null,HttpStatus.CREATED);
        return new ResponseEntity(res_message, HttpStatus.CREATED);
    }

    @GetMapping(path="/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON with the users
        return userService.getAllUsers();
    }

    @PostMapping(path="/login",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody String user, HttpSession session)
    {

        JSONObject jsonObject = new JSONObject(user);
        session.setAttribute("name",jsonObject.getString("username"));
        System.out.println("Session created for :");
        System.out.println(session.getAttribute("name").toString());
        System.out.println(jsonObject);

        Map res_message = new HashMap();

        res_message.put("status", 200);

//        String absolutePath = UserController.class.getResource("").getPath();

//        res_message.put("username", );
//        res_message.put("firstname", );
//        res_message.put("lastname", );

        System.out.println("Here is the list");
        System.out.println(userService.login(jsonObject.getString("username"),jsonObject.getString("password")).get(0).getUsername());

//        System.out.println(absolutePath + "\\src\\public\\uploads\\" + session.getAttribute("name") + "\\");

        return new ResponseEntity(res_message,HttpStatus.OK);
    }

    @PostMapping(path="/getFiles",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getFiles(HttpSession session)
    {
//        JSONObject jsonObject = new JSONObject(payload);
//        System.out.println("This is the JSONObject");
//        System.out.println(jsonObject);
        List<Document> list = fileService.getFiles((session.getAttribute("name")).toString());
//        List<Document> list = fileService.getFiles("bhavan@b.com","/public/bhavan@b.com/");
//        System.out.println("List : " + list);

//        System.out.println("Session exists for :");
//        System.out.println((session.getAttribute("name")).toString());

        System.out.println("List Details");
        System.out.println(list.size());

        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping(path = "/uploadFile")
    public ResponseEntity<?> uploadFiles(@RequestParam("file") MultipartFile file, HttpSession session)
    {
        System.out.println("In upload files");
        if (file.isEmpty()) {
            Map res_message = new HashMap();
            res_message.put("status", 400);

            return new ResponseEntity(res_message,HttpStatus.BAD_REQUEST);
        }
        try {

            System.out.println("In upload files TRY");

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(absolutePath + "\\src\\main\\public\\uploads\\" + session.getAttribute("name") + "\\" + file.getOriginalFilename());
            Files.write(path, bytes);

            final MimetypesFileTypeMap fileTypeMap = new MimetypesFileTypeMap();
            //Files.probeContentType(path);
            //fileTypeMap.getContentType(file.getOriginalFilename())

            fileService.addFiles(new Document(session.getAttribute("name").toString(), file.getOriginalFilename(), "file", path.toString(), session.getAttribute("name").toString()));

        } catch (IOException e) {
            e.printStackTrace();
        }

        Map res_message = new HashMap();
        res_message.put("status", 201);
        System.out.println("This is message : " + res_message);
        return new ResponseEntity(res_message,HttpStatus.OK);
    }

    @PostMapping(value = "/logout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> logout(HttpSession session) {
        System.out.println("In Logout");
        System.out.println(session.getAttribute("name"));
        session.invalidate();

        Map res_message = new HashMap();
        res_message.put("status", 200);

        return new ResponseEntity(res_message, HttpStatus.OK);
    }

    @PostMapping(path="/fileShare",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> fileShare (@RequestBody String payload, HttpSession session) {


        System.out.println("In File Share");

        JSONObject jsonObject = new JSONObject(payload);

        fileService.addFiles(new Document(jsonObject.getString("sharedWith"), jsonObject.getString("documentName"), jsonObject.getString("documentType"), jsonObject.getString("path"), jsonObject.getString("username")));

        Map res_message = new HashMap();
        res_message.put("status", 201);
        System.out.println("This is message : " + res_message);

        return new ResponseEntity(res_message,HttpStatus.OK);
    }

    @PostMapping(path="/createGroup",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createGroup (@RequestBody String payload, HttpSession session) {


        System.out.println("In Group Share");

        JSONObject jsonObject = new JSONObject(payload);

        groupService.addGroups(new Groups((session.getAttribute("name")).toString(), jsonObject.getString("groupname"), ""));

        Map res_message = new HashMap();
        res_message.put("status", 201);
        System.out.println("This is message : " + res_message);

        return new ResponseEntity(res_message,HttpStatus.OK);
    }

    @GetMapping(path="/getGroups",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getGroups (HttpSession session) {


        System.out.println("In Get Group");

        List<Groups> groupslist = groupService.getGroups((session.getAttribute("name")).toString());

        System.out.println(groupslist);
        System.out.println(groupslist.size());

        return new ResponseEntity(groupslist, HttpStatus.OK);
    }

    @GetMapping(path="/updateUsernames",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateUsernames (@RequestBody String payload, HttpSession session) {


        System.out.println("In Update Usernames");

        JSONObject jsonObject = new JSONObject(payload);

        groupService.updateUsernames(new Groups((session.getAttribute("name")).toString(), jsonObject.getString("groupname"), jsonObject.getString("usernames")));

        Map res_message = new HashMap();
        res_message.put("status", 201);
        System.out.println("This is message : " + res_message);

        return new ResponseEntity(res_message, HttpStatus.OK);
    }

}