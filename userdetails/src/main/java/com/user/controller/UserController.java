package com.user.controller;

import com.user.entity.Contact;
import com.user.entity.User;
import com.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/{userid}")
    public User getUser(@PathVariable("userid") long userid){
        User user = this.userService.getUser(userid);
        // Before eureka server use URL http://localhost:9002/contact/user/
        // After eureka server use URL http://contact-service/contact/user/
        List contacts = this.restTemplate.getForObject("http://contact-service/contact/user/"+user.getUserId(), List.class);
        user.setContacts(contacts);
        return user;
//        return this.userService.getUser(userid);
    }
}
