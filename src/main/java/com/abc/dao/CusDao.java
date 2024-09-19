package com.abc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.abc.model.Customer;
import com.abc.utility.*;

public class CusDao {
	public boolean registerCustomer(Customer customer) {
        String sql = "INSERT INTO customers (customer_name, address,birth_date,email, mobile) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DBUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setString(1, customer.getCustomer_name());
            statement.setString(4, customer.getAddress());
            statement.setString(5, customer.getBirth_date());
            statement.setString(2, customer.getEmail());
            statement.setString(3, customer.getMobile());
            
          

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
