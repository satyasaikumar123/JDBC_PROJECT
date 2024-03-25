package com.anp.event;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class Eventsdaoimp implements Eventsdao {
	String url="jdbc:mysql://localhost:3306/eventmanagementsystem";
	String username="root";
	String password="Admin123";
	 public void createEventTable() {
	        try (Connection connection = DriverManager.getConnection(url, username, password);
	             Statement statement = connection.createStatement()) {

	            String createTableQuery = "CREATE TABLE IF NOT EXISTS event (" +
                        "eventId INT PRIMARY KEY," +
                        "eventName VARCHAR(255)," +
                        "eventDate VARCHAR(255)," +
                        "phno VARCHAR(20)," +
                        "price INT," +
                        "status VARCHAR(255)" +
                        ")";

	            statement.executeUpdate(createTableQuery);

	        } catch (SQLException e) {
	         System.out.println("table already created");
	        }
	    }
	
	    public void addEvent(Events event) {
	        try (Connection connection = DriverManager.getConnection(url, username, password);
	             PreparedStatement statement = connection.prepareStatement(
	                     "INSERT INTO event (eventId, eventName, eventDate, phno,price,status) VALUES (?, ?, ?, ?,?,?)"
	             )) {
	            statement.setInt(1, event.getEventId());
	            statement.setString(2, event.getEventName());
	            statement.setString(3, event.getEventDate());
	            statement.setString(4, event.getPhno());
	            statement.setInt(5, event.getPrice());
	            statement.setString(6, event.getStatus());

	            statement.executeUpdate();

	        } catch (SQLException e) {
	            System.out.println("done");;
	        }
	    }

	    public Events getEventById(int eventId) {
	        Events event = null;

	        try (Connection connection = DriverManager.getConnection(url, username, password);
	             PreparedStatement statement = connection.prepareStatement(
	                     "SELECT * FROM event WHERE eventId = ?"
	             )) {
	            statement.setInt(1, eventId);

	            ResultSet resultSet = statement.executeQuery();

	            if (resultSet.next()) {
	                event = new Events(0, "", "", "",0,""); // assuming you have an empty constructor
	                event.setEventId(resultSet.getInt("eventId"));
	                event.setEventName(resultSet.getString("eventName"));
	                event.setEventDate(resultSet.getString("eventDate"));
	                event.setPhno(resultSet.getString("phno"));
	                event.setPrice(resultSet.getInt("price"));
	                event.setStatus(resultSet.getString("status"));
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return event;
	    }

	    public List<Events> getAllEvents() {
	        List<Events> events = new ArrayList<>();

	        try (Connection connection = DriverManager.getConnection(url, username, password);
	             Statement statement = connection.createStatement()) {

	            ResultSet resultSet = statement.executeQuery("SELECT * FROM event");

	            while (resultSet.next()) {
	                Events event = new Events(0, "", "", "",0,""); // assuming you have an empty constructor
	                event.setEventId(resultSet.getInt("eventId"));
	                event.setEventName(resultSet.getString("eventName"));
	                event.setEventDate(resultSet.getString("eventDate"));
	                event.setPhno(resultSet.getString("phno"));
	                event.setPrice(resultSet.getInt("price"));
	                event.setStatus(resultSet.getString("status"));
	                events.add(event);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return events;
	    }

	    @Override
	    public void updateEvent(Events event) {
	        try (Connection connection = DriverManager.getConnection(url, username, password);
	             PreparedStatement statement = connection.prepareStatement(
	                     "UPDATE event SET eventName = ?, eventDate = ?, phno = ?, price = ?, status = ? WHERE eventId = ?"
	             )) {
	            statement.setString(1, event.getEventName());
	            statement.setString(2, event.getEventDate());
	            statement.setString(3, event.getPhno());
	            statement.setInt(4, event.getPrice());
	            statement.setString(5,event.getStatus());
	            statement.setInt(6, event.getEventId());

	            statement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void deleteEvent(int eventId) {
	        try (Connection connection = DriverManager.getConnection(url, username, password);
	             PreparedStatement statement = connection.prepareStatement(
	                     "DELETE FROM event WHERE eventId = ?"
	             )) {
	            statement.setInt(1, eventId);

	            statement.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

		
		
	}