package com.aweit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.aweit.bean.Emp;

@Controller
@RequestMapping("/emp")
public class EmpController {

	@GetMapping(value = "/empform")
	public String showform(
			@ModelAttribute("employee") Emp emp, 
			@SessionAttribute("username") String username) {
//		emp.setId(1);
//		emp.setName(username);
//		emp.setSalary(100000);
//		emp.setDesignation("XYZ");
		return "empform";
	}

	@PostMapping(value = "/save")
	public String save(	@ModelAttribute("employee") @Valid Emp emp,BindingResult result) {
		System.out.println(result.getAllErrors());
		if (result.hasErrors()) {
		    return "empform";
		}
		return "redirect:/app/emp/viewemp";
	}

	@GetMapping(value = "/viewemp")
	public String viewemp(Model model) {
		List<Emp> list = new ArrayList<Emp>();
		list.add(new Emp(1, "rahul", 35000f, "S.Engineer"));
		list.add(new Emp(2, "aditya", 25000f, "IT Manager"));
		list.add(new Emp(3, "sachin", 55000f, "Care Taker"));
		model.addAttribute("list", list);
		return "viewemp";
	}
}
