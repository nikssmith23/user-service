package com.whatsapp.service;

import com.whatsapp.VO.ContactList;
import com.whatsapp.VO.ContactVO;
import com.whatsapp.VO.UserVO;
import com.whatsapp.entity.User;
import com.whatsapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private RestTemplate restTemplate;

    public List<User> getListOfUser() {
        return repository.findAll();
    }

    public User getUserById(Integer userId) {
        User user = null;
        List<User> userList = repository.findAll();

        for (User user1 : userList) {
            if (user1.getUserId().equals(userId))
                user = user1;
        }
        return user;
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public User updateUser(User user) {
        return repository.save(user);
    }

    public User patchUser(User user) {
        return repository.save(user);
    }

    public ContactVO getAllDetails(Integer contactId) {
        return restTemplate.getForObject("http://CONTACT-SERVICE/contact/" + contactId, ContactVO.class);
    }

    public ContactList getAllContact() {
        return restTemplate.getForObject("http://CONTACT-SERVICE/contact/", ContactList.class);
    }

    public UserVO getUserByIdwithContact(Integer contactId) {
        UserVO userVO = new UserVO();
        ContactList list1 = new ContactList();
        list1 = restTemplate.getForObject("http://CONTACT-SERVICE/contact/user/" + contactId, ContactList.class);
        System.out.println(list1);
        userVO.setUser(repository.findAll().stream().filter(a -> a.getUserId().equals(contactId)).findFirst().orElse(null));
        userVO.setContact(list1);
        return userVO;

    }
}
