package mainclass;


import java.util.List;
import java.util.Scanner;

import com.anp.event.Events;
import com.anp.event.Eventsdaoimp;

public class Main {
    private static Eventsdaoimp eventsDao = new Eventsdaoimp();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        eventsDao.createEventTable(); // Ensure table creation before performing operations
        boolean exit = false;

        while (!exit) {
            System.out.println("Select an option:");
            System.out.println("1. Add Event");
            System.out.println("2. Update Event");
            System.out.println("3. Delete Event");
            System.out.println("4. View All Events");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addEvent();
                    break;
                case 2:
                    updateEvent();
                    break;
                case 3:
                    deleteEvent();
                    break;
                case 4:
                    viewAllEvents();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }

        scanner.close();
    }

    private static void addEvent() {
        System.out.println("Enter Event details:");
        System.out.print("Event ID: ");
        int eventId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Event Name: ");
        String eventName = scanner.nextLine();
        System.out.print("Event Date: ");
        String eventDate = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phno = scanner.nextLine();
        System.out.print("Price: ");
        int price = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Status: ");
        String status = scanner.nextLine();

        Events event = new Events(eventId, eventName, eventDate, phno, price, status);
        eventsDao.addEvent(event);
        System.out.println("Event added successfully.");
    }

    private static void updateEvent() {
        System.out.print("Enter Event ID to update: ");
        int eventId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Events existingEvent = eventsDao.getEventById(eventId);
        if (existingEvent == null) {
            System.out.println("Event not found.");
            return;
        }

        System.out.println("Enter new details:");
        System.out.print("Event Name: ");
        String eventName = scanner.nextLine();
        System.out.print("Event Date: ");
        String eventDate = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phno = scanner.nextLine();
        System.out.print("Price: ");
        int price = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Status: ");
        String status = scanner.nextLine();

        existingEvent.setEventName(eventName);
        existingEvent.setEventDate(eventDate);
        existingEvent.setPhno(phno);
        existingEvent.setPrice(price);
        existingEvent.setStatus(status);

        eventsDao.updateEvent(existingEvent);
        System.out.println("Event updated successfully.");
    }

    private static void deleteEvent() {
        System.out.print("Enter Event ID to delete: ");
        int eventId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        eventsDao.deleteEvent(eventId);
        System.out.println("Event deleted successfully.");
    }

    private static void viewAllEvents() {
        List<Events> events = eventsDao.getAllEvents();
        if (events.isEmpty()) {
            System.out.println("No events found.");
        } else {
            System.out.println("List of Events:");
            for (Events event : events) {
                System.out.println(event);
            }
        }
    }
}
