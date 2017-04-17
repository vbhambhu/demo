package com.example.controller;

import com.example.entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by vinodkumar on 16/04/2017.
 */
@Controller
public class AdminResource {

    @Autowired
    MongoOperations mongoOperation;

    @RequestMapping(value="/admin/resources", method= RequestMethod.GET)
    public String listResources(Model model) {

        List<Resource> resources = mongoOperation.findAll(Resource.class);
        model.addAttribute("resources", resources);
        return "resource/admin/list";

    }

    @RequestMapping(value="/admin/resource/edit", method= RequestMethod.GET)
    public String editResource(@RequestParam("id") String id, Model model) {

        //TODO: validate id here


        model.addAttribute("rid", id);


        return "resource/admin/edit";

    }

}
