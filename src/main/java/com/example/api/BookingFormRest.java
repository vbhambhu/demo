package com.example.api;

import com.example.domain.BookingForm;
import com.example.entity.Project;
import com.example.entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public BookingForm getBookingForm(@RequestParam(value = "rid", required = false) String rid) {

        //Resource resource = mongoOperation.findById(new ObjectId("58ee440da96e9318a73b4d2e"), Resource.class);
        BookingForm bookingForm = new BookingForm();
        //List<Resource> resources = mongoOperation.findAll(Resource.class);
        //bookingForm.setResources(resources);
        //List<Project> projects = mongoOperation.findAll(Project.class);
        //bookingForm.setProjects(projects);

        Resource res = new Resource();
        if(rid == null){
            Query query = new Query();
            query.limit(1);
            res = mongoOperation.findOne(query, Resource.class);
            System.out.println(res.getId());
        } else{
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(rid));
            query.limit(1);
            res = mongoOperation.findOne(query, Resource.class);
            if(res ==null){
                System.out.println("Resource not found");
            }
        }


        List<Resource> resources = mongoOperation.findAll(Resource.class);
        List<Project> projects = mongoOperation.findAll(Project.class);

        bookingForm.setSelectedResource(res);
        bookingForm.setResources(resources);
        bookingForm.setProjects(projects);

        //mongoOperation.


        return bookingForm;

    }



}
