package com.abc.model;

import java.util.Date;

public class Payments {
	  	private String reservation_id;
	  	private Date payment_date;
	  	private double amount;
	    private String payment_status;
		public String getReservation_id() {
			return reservation_id;
		}
		public void setReservation_id(String reservation_id) {
			this.reservation_id = reservation_id;
		}
		public Date getPayment_date() {
			return payment_date;
		}
		public void setPayment_date(Date payment_date) {
			this.payment_date = payment_date;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public String getPayment_status() {
			return payment_status;
		}
		public void setPayment_status(String payment_status) {
			this.payment_status = payment_status;
		} 
	    
}
