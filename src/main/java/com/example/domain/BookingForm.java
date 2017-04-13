package com.example.domain;

import com.example.entity.Project;
import com.example.entity.Resource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vkumar on 12/04/2017.
 */
public class BookingForm {

    private List<Resource> resources = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();

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
}
