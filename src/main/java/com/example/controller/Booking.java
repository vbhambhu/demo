package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vkumar on 12/04/2017.
 */
@Controller
public class Booking {


    @RequestMapping(value="/booking/create", method= RequestMethod.GET)
    public String welcome(){
        return "booking/create";
    }

}
