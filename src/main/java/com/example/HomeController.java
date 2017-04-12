package com.example;


import com.example.Entities.Resource;
import org.codehaus.groovy.control.io.ReaderSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired
    MongoOperations mongoOperation;

    @RequestMapping(value={"", "/", "dashboard"}, method= RequestMethod.GET)
    public String welcome(){




        return "home";
    }


}
