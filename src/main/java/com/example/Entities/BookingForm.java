package com.example.Entities;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by vkumar on 12/04/2017.
 */
public class BookingForm {

    private String resource_id;

    private List<Resource> resources = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();

    private BookingTime bookingTime;

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public String getResource_id() {
        return resource_id;
    }

    public void setResource_id(String resource_id) {
        this.resource_id = resource_id;
    }
}
