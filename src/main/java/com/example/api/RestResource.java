package com.example.api;

import com.example.domain.BookingForm;
import com.example.domain.RestResult;
import com.example.entity.Resource;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.MediaType;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by vinodkumar on 13/04/2017.
 */
@RestController
@RequestMapping("/api/resource")
public class RestResource {

    @Autowired
    MongoOperations mongoOperation;

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Resource getResourceById(@RequestParam("rid") String resourceId) {
        Resource resource = mongoOperation.findById(new ObjectId(resourceId), Resource.class);
        return resource;
    }

    @RequestMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Resource> getBookingForm() {
        List<Resource> resources = mongoOperation.findAll(Resource.class);
        return resources;
    }



    @RequestMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public RestResult createForm(@Valid @RequestBody Resource resource, Errors errors) {

        RestResult result =  new RestResult();

        if (errors.hasErrors()) {
            result.setHasError(true);

            for (FieldError fieldError : errors.getFieldErrors()) {
                result.addError(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return result;
        }

        //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //String username = auth.getName();

        //form.setCreatedAt(new Date());
        //form.setOwner(username);

        //if(!username.equals("anonymousUser")){
            mongoOperation.save(resource);
        //}

        return result;

    }
}
