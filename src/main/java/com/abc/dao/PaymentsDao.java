package com.abc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.abc.model.Payments;
import com.abc.utility.*;

public class PaymentsDao {
	public void savePayment(Payments payment) throws SQLException {
        String sql = "INSERT INTO payments (reservation_id, amount, payment_date, payment_status) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DBUtil.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, payment.getReservation_id());
            ps.setDouble(7, payment.getAmount());
            ps.setDate(2, new java.sql.Date(payment.getPayment_date().getTime()));
            ps.setString(4, payment.getPayment_status());
            ps.executeUpdate();
}
}
	}