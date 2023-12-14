package com.aweit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aweit.bean.Emp;

@Controller
@RequestMapping("/emp")
public class EmpController {

	@Autowired
	HttpSession session;

	@GetMapping(value = "/empform")
	public String showform(@ModelAttribute("employee") Emp emp) {

		emp.setId(1);
		emp.setName((String)session.getAttribute("username"));
		emp.setSalary(100000);
		emp.setDesignation("XYZ");
		
		return "empform";
	}

	@PostMapping(value = "/save")
	public ModelAndView save(@ModelAttribute("employee") Emp emp) {
		System.out.println(emp.getName() + " " + emp.getSalary() + " " + emp.getDesignation());
		return new ModelAndView("redirect:/viewemp");
	}

	@GetMapping(value = "/viewemp")
	public ModelAndView viewemp() {
		List<Emp> list = new ArrayList<Emp>();
		list.add(new Emp(1, "rahul", 35000f, "S.Engineer"));
		list.add(new Emp(2, "aditya", 25000f, "IT Manager"));
		list.add(new Emp(3, "sachin", 55000f, "Care Taker"));
		return new ModelAndView("viewemp", "list", list);
	}
}
