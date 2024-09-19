package com.abc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.abc.model.Reservations;
import com.abc.utility.*;

public class ResDao {
	public void ReservationList(Reservations reservation) throws SQLException {
        String sql = "INSERT INTO reservations (customer_name, reservation_date, time, service_type) VALUES (?, ?, ?, ?)";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, reservation.getCustomer_name());
            statement.setDate(2, new java.sql.Date(reservation.getReservation_date().getTime()));
            statement.setString(3, reservation.getTime());
            statement.setString(4, reservation.getService_type());
            statement.executeUpdate();
        }
    }

    public List<Reservations> getAllReservations() throws SQLException {
        List<Reservations> reservations = new ArrayList<>();
        String sql = "SELECT * FROM reservations";

        try (Connection connection = DBUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Reservations reservation = new Reservations();
                reservation.setId(resultSet.getInt("id"));
                reservation.setCustomer_name(resultSet.getString("name"));
                reservation.setReservation_date(resultSet.getDate("reservationDate"));
                reservation.setTime(resultSet.getString("time"));
                reservation.setService_type(resultSet.getString("serviceType"));
                reservations.add(reservation);
            }
        }
        return reservations;
    }

}
