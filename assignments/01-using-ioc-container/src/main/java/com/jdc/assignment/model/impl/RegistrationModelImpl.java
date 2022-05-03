package com.jdc.assignment.model.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.jdc.assignment.domain.Course;
import com.jdc.assignment.domain.OpenClass;
import com.jdc.assignment.domain.Registration;
import com.jdc.assignment.model.RegistrationModel;

public class RegistrationModelImpl implements RegistrationModel {

	private static final String SELECT_SQL = """
			select r.id, r.open_class_id openClassId, r.student, r.phone, r.email, 
			oc.course_id courseId, oc.start_date, oc.teacher, 
			c.name, c.fees, c.duration, c.description
			from registration r 
			join open_class oc on r.open_class_id = oc.id
			join course c on oc.course_id = c.id
			where oc.id = ?;
			""";
	
	private static final String INSERT = "insert into registration(open_class_id, student, phone, email) values (?, ?, ?, ?)";

	private DataSource dataSource;

	public RegistrationModelImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public List<Registration> findByOpenClass(int id) {

		var list = new ArrayList<Registration>();

		try (var conn = dataSource.getConnection(); var stmt = conn.prepareStatement(SELECT_SQL)) {

			stmt.setInt(1, id);

			var rs = stmt.executeQuery();

			while (rs.next()) {

				var c = new Course();
				c.setId(rs.getInt("courseId"));
				c.setName(rs.getString("name"));
				c.setDuration(rs.getInt("duration"));
				c.setFees(rs.getInt("fees"));
				c.setDescription(rs.getString("description"));
				
				var oc = new OpenClass();
				oc.setCourse(c);
				oc.setTeacher(rs.getString("teacher"));
				oc.setId(rs.getInt("openClassId"));
				oc.setStartDate(rs.getDate("start_date").toLocalDate());
				
				var r = new Registration();
				r.setId(rs.getInt("id"));
				r.setOpenClass(oc);
				r.setStudent(rs.getString("student"));
				r.setPhone(rs.getString("phone"));
				r.setEmail(rs.getString("email"));

				list.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void create(Registration registration) {
		try (var conn = dataSource.getConnection(); var stmt = conn.prepareStatement(INSERT)) {
			
			stmt.setInt(1, registration.getOpenClass().getId());
			stmt.setString(2, registration.getStudent());
			stmt.setString(3, registration.getPhone());
			stmt.setString(4, registration.getEmail());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
