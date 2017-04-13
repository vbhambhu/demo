package com.example.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by vkumar on 12/04/2017.
 */
@Document(collection = "resources")
public class Resource {

    @Id
    private String id;

    private String name;

    private Boolean projectRequired = false;

    private Boolean slotRequired = false;

    private List<BookingSlot> availableSlots = new ArrayList<>();

    private List<BookingSlot> unAvailableSlots = new ArrayList<>();

    private List<Field> fields = new ArrayList<>();

    private List<UserGroup> userGroups = new ArrayList<>();

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date updatedDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createdDate;




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
    
    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public Boolean getProjectRequired() {
        return projectRequired;
    }

    public void setProjectRequired(Boolean projectRequired) {
        this.projectRequired = projectRequired;
    }

    public Boolean getSlotRequired() {
        return slotRequired;
    }

    public void setSlotRequired(Boolean slotRequired) {
        this.slotRequired = slotRequired;
    }

    public List<BookingSlot> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(List<BookingSlot> availableSlots) {
        this.availableSlots = availableSlots;
    }

    public List<BookingSlot> getUnAvailableSlots() {
        return unAvailableSlots;
    }

    public void setUnAvailableSlots(List<BookingSlot> unAvailableSlots) {
        this.unAvailableSlots = unAvailableSlots;
    }

    public List<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(List<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
