package com.anp.event;
public class Events {
	
		
	@Override
	public String toString() {
	    return "Event ID: " + eventId + "\n" +
	           "Event Name: " + eventName + "\n" +
	           "Event Date: " + eventDate + "\n" +
	           "Phone Number: " + phno + "\n" +
	           "Price: " + price + "\n" +
	           "Status: " + status;
	}

		private int eventId;
	    private String eventName;
	    private String eventDate;
	    private String phno;
	    private int price;
	    private String status;
	    
	    
	    public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public int getEventId() {
			return eventId;
		}
		public void setEventId(int eventId) {
			this.eventId = eventId;
		}
		public String getEventName() {
			return eventName;
		}
		public void setEventName(String eventName) {
			this.eventName = eventName;
		}
		public String getEventDate() {
			return eventDate;
		}
		public void setEventDate(String eventDate) {
			this.eventDate = eventDate;
		}
		public String getPhno() {
			return phno;
		}
		public void setPhno(String phno) {
			this.phno = phno;
		}
		
		public Events( int eventid,String eventName, String eventDate, String phno,int price,String status) {
			super();
			this.eventId=eventid;
			
			this.eventName = eventName;
			this.eventDate = eventDate;
			this.phno = phno;
			this.price=price;
			this.status=status;
			
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}

	}


