package com.abc.service;

import java.sql.SQLException;
import java.util.List;

import com.abc.dao.ResDao;
import com.abc.model.Reservations;

public class ResServices {
	 private final ResDao reservationdao = new ResDao();

	    public void addReservation(Reservations reservation) throws SQLException {
	        reservationdao.ReservationList(reservation);
	    }

	    public List<Reservations> listAllReservations() throws SQLException {
	        return reservationdao.getAllReservations();
	    }
}
