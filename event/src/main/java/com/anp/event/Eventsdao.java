package com.anp.event;

import java.util.List;

public interface Eventsdao {
	   void addEvent(Events event);

	    Events getEventById(int eventId);

	    List<Events> getAllEvents();

	    void updateEvent(Events event);

	    void deleteEvent(int eventId);
	    void createEventTable();
	    
}
