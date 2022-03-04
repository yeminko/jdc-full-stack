package com.jdc.maven;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

public class CourseInsert {

	private DataSource dataSource;

	public CourseInsert(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

//	private static final String USER = "root";
//	private static final String PASSWORD = "root";
//	private static final String URL = "jdbc:mysql://localhost:3306/hello_maven";
	private static final String SQL = "insert into course (name, fees, duration) values (?,?,?)";

	public void insert(Course c) {
		try (var conn = dataSource.getConnection(); var stmt = conn.prepareStatement(SQL)) {
			stmt.setString(1, c.getName());
			stmt.setInt(2, c.getFees());
			stmt.setInt(3, c.getDuration());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
