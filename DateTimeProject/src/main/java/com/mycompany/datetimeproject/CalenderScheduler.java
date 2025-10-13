/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.datetimeproject;

import java.time.ZoneId;
import java.time.ZonedDateTime; 
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author gener
 */
public class CalenderScheduler {

    public static void main(String[] args) {
        
        //objects of various classes instantiated
        Scheduler scheduler = new Scheduler();
        Scanner input = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        //Adding events manually
        scheduler.addEvent(new Event("Tech Awareness Fest 1.0", ZonedDateTime.of(2025, 3, 25, 10, 30, 0, 0, ZoneId.of("America/Chicago"))));
     
        scheduler.addEvent(new Event("Doctor's Appointment", ZonedDateTime.of(2025, 3, 22, 13, 43, 0, 0, ZoneId.of("America/New_York"))));

//        System.out.println("*******Event Brite Scheduler**********");
//        System.out.println("Do you want to add an event? [yes/no]");
//        String answer = input.nextLine();
        
//        if(answer.equalsIgnoreCase("yes")){
//            System.out.println("Enter an event name: ");
//            String eventName = input.nextLine();
//            System.out.println("Enter the event date and time [yyyy-MM-dd HH:mm]: ");
//            String dateTimeStr = input.nextLine();
//            
//            //try and catch to handle exceptions related to format
//            try{
//                ZonedDateTime eventDateTime = ZonedDateTime.parse(dateTimeStr, formatter);
//               //adding user inputted event
//                scheduler.addEvent(new Event(eventName, eventDateTime));
//            }catch(Exception e){
//                System.out.println("Invalid date/time format. Event not added");
//            }
//        }

         while(true){
             System.out.println("\n Menu");
             System.out.println("1. Add Event");
             System.out.println("2. List All Events");
             System.out.println("3. List Upcoming Events");
             System.out.println("4. Update Event");
             System.out.println("5. Delete Event");
             System.out.println("6. Display Next 7 Days");
             System.out.println("7. Exit");
             
             System.out.println("Enter your choice: ");
             int choice = input.nextInt();
             input.nextLine(); 
             
             System.out.println();
             
             switch(choice){
                 case 1: 
                     //Add Event
                     System.out.print("Event event name: ");
                     String name = input.nextLine();
                     System.out.print("Enter event date and time (yyyy-MM-dd HH:mm): ");
                     String dateTimeInput = input.nextLine();
                     System.out.print("Enter time zone (e.g., America/New_York): ");
                     String timeZone =input.nextLine(); 
                     ZonedDateTime dateTime = ZonedDateTime.of(LocalDateTime.parse(dateTimeInput, formatter), ZoneId.of(timeZone));
                     scheduler.addEvent(new Event(name, dateTime));
                     
                 case 2:
                     // List All Events
                     System.out.println("\nAll Events: ");
                     scheduler.listAllEvents().forEach(System.out::println);
                     break;
                     
                 case 3: 
                     // Liat Upcoming events
                     System.out.println("\nUpcoming Events: ");
                     scheduler.listUpcomingEvents().forEach(System.out::println);
                     break; 
                     
                     
                 case 4:
                     // Update Event 
                     System.out.print("Enter event name to update: ");
                     String oldName = input.nextLine();
                     System.out.print("Enter New Event: ");
                     String newName = input.nextLine();
                     System.out.print("Enter new date and time (yyyy-MM-dd HH:mm): ");
                     dateTimeInput = input.nextLine();
                     System.out.print("Enter new Time Zone: ");
                     timeZone = input.nextLine();
                     dateTime = ZonedDateTime.of(LocalDateTime.parse(dateTimeInput, formatter), ZoneId.of(timeZone));
                     scheduler.updateEvent(oldName, newName, dateTime);
                     break;
                     
                 case 5:
                     // Delete event 
                     System.out.print("Enter event name to delete: ");
                     String deleteName = input.nextLine();
                     if (scheduler.deleteEvent(deleteName)){
                         System.out.println("Event deleted successfully. ");
                       }else{
                         System.out.println("Event not found. ");
                     }
                     break;
                     
                 case 6:
                     //Display next 7 days
                     scheduler.displayNextNDays();
                     break;
                     
                 case 7:
                     //Exit 
                     System.out.println("Exiting Program.............");
                     input.close();
                     return;
                     
                 default:
                     System.out.println("Invalid Choice. Try again....");
                     
             }
         }
   
    }
}
