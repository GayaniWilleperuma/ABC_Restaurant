package com.abc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.abc.model.Queries;
import com.abc.utility.*;

public class QueriesDao {
	public void submitQuery(Queries query) throws SQLException {
        String querySQL = "INSERT INTO queries (name, email, customer_query) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(querySQL)) {
            ps.setString(1, query.getName());
            ps.setString(2, query.getEmail());
            ps.setString(3, query.getCutomer_query());
            ps.executeUpdate();
        }
    }
}
