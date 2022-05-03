package com.jdc.assignment.model;

import java.util.List;

import com.jdc.assignment.domain.OpenClass;

public interface OpenClassModel {
	
	OpenClass findById(int id);
	List<OpenClass> findByCourse(int courseId);
	void create(OpenClass openClass);
}
