/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.datetimeproject;


import java.util.List;
import java.util.ArrayList;

import java.time.ZonedDateTime;
import java.util.stream.Collectors;

/**
 *
 * @author gener
 */
public class Scheduler {
    //events field
    private List<Event> events;
    
    public Scheduler(){
        this.events = new ArrayList<>();
    }
    
    //method for adding events
    public void addEvent(Event event){
        events.add(event);
        System.out.println("Event Added: " +event);
        
    
    }
    // List all events
    public List<Event>listAllEvents(){
        return new ArrayList<>(events);
    }
    
    
    //displays upcoming  events
    public List<Event> listUpcomingEvents(){
     ZonedDateTime now = ZonedDateTime.now();
     return events.stream()
             .filter(event -> event.getDateTime().isAfter(now))
             .collect(Collectors.toList());
    }
    
    
    //Update an Event
    public boolean updateEvent(String eventName, String newName, ZonedDateTime newDateTime){
      for (Event event : events){
          if(event.getName().equalsIgnoreCase(eventName)){
              event.setName(newName);
              event.setDateTime(newDateTime);
              System.out.println("Event updated: "+event);
              return true;
          }
      }
      
      System.out.println("Event not found. ");
      return false; 
    }
    
    //Delete an event 
    public boolean deleteEvent(String eventName){
        return events.removeIf(event -> event.getName().equalsIgnoreCase(eventName));
    }
    
    //displays the next events as manually inputed
    public void displayNextNDays(){
        ZonedDateTime today = ZonedDateTime.now();
        System.out.println("Next 7 Days:" );
        for(int n = 0; n < 7 ; n++){
            System.out.println(today.plusDays(n).toLocalDate());
        }
    }  
}
