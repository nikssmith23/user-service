package com.whatsapp;

import com.whatsapp.entity.User;
import com.whatsapp.repository.UserRepository;
import com.whatsapp.service.UserService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {UserServiceTest.class})
public class UserServiceTest {
    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserService service;

    @Test
    @Order(1)
    public void test_getAllUser() {
        List<User> userList= new ArrayList<>();
        userList.add(new User(1,"Nikit","9890966026"));
        userList.add(new User(2,"Uday","9665435828"));
        when(repository.findAll()).thenReturn(userList);
        assertEquals(2,service.getListOfUser().size());
    }
}
