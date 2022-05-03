package com.jdc.assignment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdc.assignment.domain.Registration;
import com.jdc.assignment.model.OpenClassModel;
import com.jdc.assignment.model.RegistrationModel;

@WebServlet(urlPatterns = { "/registrations", "/registration-edit" })
public class RegistrationServlet extends AbstractBeanFactoryServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var openClassId = req.getParameter("openClassId");

		// Find open class
		var openClassModel = getBean("openClassModel", OpenClassModel.class);
		var openClass = openClassModel.findById(Integer.parseInt(openClassId));

		req.setAttribute("openClass", openClass);

		var page = switch (req.getServletPath()) {
		case "/registrations" -> {
			var model = getBean("registrationModel", RegistrationModel.class);
			req.setAttribute("registrations", model.findByOpenClass(Integer.parseInt(openClassId)));
			yield "registrations";
		}
		default -> {
			yield "registration-edit";
		}
		};

		getServletContext().getRequestDispatcher("/%s.jsp".formatted(page)).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get request parameter
		var openClassId = req.getParameter("openClassId");
		var student = req.getParameter("student");
		var phone = req.getParameter("phone");
		var email = req.getParameter("email");

		// Find open class
		var openClassModel = getBean("openClassModel", OpenClassModel.class);
		var openClass = openClassModel.findById(Integer.parseInt(openClassId));
	
		// create registartion object
		var registration = new Registration();
		registration.setOpenClass(openClass);
		registration.setStudent(student);
		registration.setPhone(phone);
		registration.setEmail(email);

		// save to db
		getBean("registrationModel", RegistrationModel.class).create(registration);

		// redirect to top page
		resp.sendRedirect("/registrations?openClassId=" + openClassId);
	}

}
