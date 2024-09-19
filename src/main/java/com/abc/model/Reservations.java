package com.abc.model;

import java.util.Date;

public class Reservations {
	
	    private int id;
	    private String customer_name;
	    private Date reservation_date;
	    private String time;
	    private String service_type;

		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		public String getCustomer_name() {
			return customer_name;
		}
		public void setCustomer_name(String customer_name) {
			this.customer_name = customer_name;
		}
		public Date getReservation_date() {
			return reservation_date;
		}
		public void setReservation_date(Date reservation_date) {
			this.reservation_date = reservation_date;
		}
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public String getService_type() {
			return service_type;
		}
		public void setService_type(String service_type) {
			this.service_type = service_type;
		}

}
