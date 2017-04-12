package com.example;

import com.example.Entities.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        mongoOperation.getCollection("resources").drop();

        Resource res = new Resource();
        res.setName("Meeting room 1");
        mongoOperation.save(res);

        for(int i=2; i<10; i++){
            res = new Resource();
            res.setName("Resource " + i);
            mongoOperation.save(res);
        }

    }
}
