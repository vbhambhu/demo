package com.example.API;

import com.example.domain.BookingForm;
import com.example.entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vkumar on 12/04/2017.
 */
@RestController
@RequestMapping("/api/booking")
public class BookingFormRest {

    @Autowired
    MongoOperations mongoOperation;


    @RequestMapping(value = "/form", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BookingForm getBookingForm(@RequestParam(value = "start", required = false) String start) {

        //Resource resource = mongoOperation.findById(new ObjectId("58ee440da96e9318a73b4d2e"), Resource.class);
        BookingForm bookingForm = new BookingForm();
        //List<Resource> resources = mongoOperation.findAll(Resource.class);
        //bookingForm.setResources(resources);
        //List<Project> projects = mongoOperation.findAll(Project.class);
        //bookingForm.setProjects(projects);

        Iterable<Resource> resources = mongoOperation.findAll(Resource.class);


        return bookingForm;

    }



}
