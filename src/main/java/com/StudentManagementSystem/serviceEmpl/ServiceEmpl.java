package com.StudentManagementSystem.serviceEmpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentManagementSystem.entity.Student;
import com.StudentManagementSystem.repository.Studentrepository;
import com.StudentManagementSystem.service.StudentService;
@Service
public class ServiceEmpl  implements StudentService {
	@Autowired
	private Studentrepository Studentrepository;
	
	@Override
	public List<Student> getAllStudent() {
		
		List<Student> list=Studentrepository.findAll();
		return list;
	}
	@Override
	public Student Save(Student student)
	{
		return Studentrepository.save(student);
	}
	@Override
	public Student getById(int id)
	{
		return Studentrepository.findById(id).get();
	}
	@Override
	public void deleteById(int id) {
		Studentrepository.deleteById(id);
		
	}
	

}
