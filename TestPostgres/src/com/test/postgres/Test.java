package com.test.postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection(
				String.format("jdbc:postgresql://%s:%s/%s", args[0], args[1], args[2]), args[3], args[4])) {

			if (conn != null) {
				System.out.println("Connected to the database!");
			} else {
				System.out.println("Failed to make connection!");
			}

		} catch (SQLException e) {
			if (null != e.getCause()) {
				System.out.println(e.getCause().getMessage());
			}
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
