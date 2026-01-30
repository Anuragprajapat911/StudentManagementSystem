package com.StudentManagementSystem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.StudentManagementSystem.entity.Student;
import com.StudentManagementSystem.service.StudentService;



@RestController
public class Controller {


	@Autowired
	private StudentService service;
	



@GetMapping("/student")
	public String getAllStudent(Model model) {
		
	model.addAttribute("student",service.getAllStudent());
	return "student";
	}
@GetMapping("/student/new")
public String CreateForm(Model model)
{
	Student st=new Student();
	model.addAttribute("student", st);
	
return "create-student";	
}
@PostMapping("/student")
public String Save(@ModelAttribute("student")Student student)
{
	service.Save(student);
	return "redirect:/student";
}

@GetMapping("/student/edit/{id}")
public String edit( @PathVariable int id,Model model)
{
	model.addAttribute("student", service.getById(id));
	return "edit-student";
}

@PostMapping("/student/edit/{id}")
public String update(@PathVariable int id,@ModelAttribute("student") Student student)
{
Student ex=service.getById(id);
ex.setFirstname(student.getFirstname());
ex.setLastname(student.getLastname());
ex.setEmail(student.getEmail());
service.Save(ex);
return "redirect:/student";
}

@GetMapping("/student/delete/{id}")
public String deleteById(@PathVariable int id)
{
	service.deleteById(id);
	return "redirect:/student";
}

}










