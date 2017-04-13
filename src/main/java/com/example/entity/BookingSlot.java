package com.example.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vkumar on 13/04/2017.
 */
public class BookingSlot {

    private String day;

    private List<BookingTime> bookingTimes = new ArrayList<>();

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<BookingTime> getBookingTimes() {
        return bookingTimes;
    }

    public void setBookingTimes(List<BookingTime> bookingTimes) {
        this.bookingTimes = bookingTimes;
    }
}
