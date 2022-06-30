package com.whatsapp.controller;

import com.whatsapp.VO.ContactList;
import com.whatsapp.VO.ContactVO;
import com.whatsapp.VO.UserVO;
import com.whatsapp.entity.User;
import com.whatsapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/")
    public List<User> getListOfUser() {
        return service.getListOfUser();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Integer userId) {
        return service.getUserById(userId);
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        return service.updateUser(user);
    }

    @PatchMapping("/patch")
    public User patchUser(@RequestBody User user) {
        return service.patchUser(user);
    }

    @GetMapping("/contact/{contactId}")
    public  ContactVO getAllDetails(@PathVariable Integer contactId) {
        return service.getAllDetails(contactId);
    }

    @GetMapping("/contact")
    public ContactList getAllContact() {
        return service.getAllContact();
    }
    @GetMapping("/all/{contactId}")
    public UserVO getUserByIdwithContact(@PathVariable Integer contactId){
        return service.getUserByIdwithContact(contactId);

    }

}
