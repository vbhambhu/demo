package com.example;

import com.example.entity.Project;
import com.example.entity.Resource;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/**
 * Created by vkumar on 12/04/2017.
 */
@Controller
public class SetupController {

    @Autowired
    MongoOperations mongoOperation;

    @RequestMapping(value="/install", method= RequestMethod.GET)
    public void setup() {

        //delete if exists
        mongoOperation.getCollection("users").drop();
        mongoOperation.getCollection("resources").drop();
        mongoOperation.getCollection("projects").drop();



        User user = new User();
        user.setFirstName("Vinod");
        user.setLastName("Kumar");
        user.setEmail("vinod@test.com");
        user.setUsername("spadmin");
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode("admin"));

        user.setRole("ROLE_USER");
        user.setRole("ROLE_ADMIN");
        user.setGroup("ALL_USERS");
        mongoOperation.save(user);




        Resource res = new Resource();
        res.setName("Meeting room 1");
        mongoOperation.save(res);

        for(int i=2; i<10; i++){
            res = new Resource();
            res.setName("Resource " + i);
            mongoOperation.save(res);
        }



        Project project = new Project();
        project.setName("Project 1");
        mongoOperation.save(project);

        for(int i=2; i<6; i++){
            project = new Project();
            project.setName("Resource " + i);
            mongoOperation.save(project);
        }

    }
}
