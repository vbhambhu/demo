package com.example.entity;

import org.springframework.data.annotation.Id;

/**
 * Created by vkumar on 13/04/2017.
 */
public class UserGroup {

    @Id
    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
