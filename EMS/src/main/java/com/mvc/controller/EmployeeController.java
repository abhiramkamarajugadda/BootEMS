package com.mvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.model.Employee;
import com.mvc.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeController {
	private EmployeeService service;

	public EmployeeController(EmployeeService service) {
		this.service = service;
	}

	@RequestMapping("/save")
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
		Employee obj = service.saveEmployee(employee);
		ModelAndView mv = new ModelAndView("register.jsp");
		if (obj != null) {
			mv.addObject("status", "Employee Regestered Successfully.....");
		} else {
			mv.addObject("status", "Employee Not Regestered Successfully.....");
		}
		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView checkLogin(@RequestParam String email, @RequestParam String password, HttpSession session) {
		Employee employee = service.checkLogin(email, password);
		ModelAndView mv = null;
		if (employee.getId() != 0) {
			session.setAttribute("email", email);
			mv = new ModelAndView("employee.jsp");
		} else {
			if (email.equals("admin@codegnan.com") && password.equals("admin@49")) {
				session.setAttribute("email", email);
				mv = new ModelAndView("admin.jsp");
			} else {
				mv = new ModelAndView("login.jsp");
				mv.addObject("status", "Invalid Crendentials....");
			}
		}
		return mv;
	}

	@RequestMapping("/findAll")
	public ModelAndView getAllEmployees() {
		List<Employee> empList = service.getAllEmployees();
		ModelAndView mv = new ModelAndView("viewemps.jsp");
		mv.addObject("empList", empList);
		return mv;
	}

	@RequestMapping("/findByEmail")
	public ModelAndView searchEmployee(@RequestParam String email) {
		Employee employee = service.searchEmployee(email);
		ModelAndView mv = null;
		if (employee.getId() != 0) {
			mv = new ModelAndView("viewemp.jsp");
			mv.addObject("employee", employee);
		} else {
			mv = new ModelAndView("search.jsp");
			mv.addObject("status", "Employee not found.....");
		}
		return mv;
	}

	@RequestMapping("/edituser")
	public ModelAndView updateEmployee(@ModelAttribute Employee employee) {
		Employee obj = service.searchEmployee(employee.getEmail());
		employee.setPassword(obj.getPassword());
		service.saveEmployee(employee);
		ModelAndView mv = new ModelAndView("findAll");
		return mv;
	}

	@RequestMapping("/delete")
	public ModelAndView deleteEmployee(@RequestParam int id) {
		service.deleteEmployee(id);
		ModelAndView mv = new ModelAndView("findAll");
		return mv;
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView mv = new ModelAndView("index.jsp");
		return mv;
	}

}
