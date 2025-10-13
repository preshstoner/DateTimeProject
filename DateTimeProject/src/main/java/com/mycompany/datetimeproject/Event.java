/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.datetimeproject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZonedDateTime;

/**
 *
 * @author gener
 */
public class Event {
    
    //encapsulated fiels name and dateTime
    private String name;
    private ZonedDateTime dateTime;
    
    public Event(String name, ZonedDateTime dateTime){
        this.name = name;
        this.dateTime = dateTime;
    }
    
    //getter methods
    public String getName(){
        return name;
    } 
    
    public void setName(String name){
        this.name = name; 
    }
    
    public ZonedDateTime getDateTime(){
        return dateTime;
    } 
    
    public void setDateTime(ZonedDateTime dateTime){
        this.dateTime = dateTime; 
    }
    
    //toString method to convert and format string based on pattern
    @Override
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "Event: "+name+" | Scheduled for "+dateTime.format(formatter);
    }
    
}
