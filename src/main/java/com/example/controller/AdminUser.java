package com.example.controller;


import com.example.entity.Resource;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AdminUser {

    @Autowired
    MongoOperations mongoOperation;

    @RequestMapping(value="/admin/users", method= RequestMethod.GET)
    public String listResources(Model model) {

        List<User> users = mongoOperation.findAll(User.class);
        model.addAttribute("users", users);
        return "user/admin/list";

    }


    @RequestMapping(value="/admin/user/create", method= RequestMethod.GET)
    public String createUser(User user) {

        return "user/admin/create";

    }


}
