package org.jsp.batch_student.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.batch_student.dto.Student;
import org.jsp.batch_student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

	@Autowired
	private StudentRepository studentRepository;
	
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Optional<Student> findById(int id) {
		return studentRepository.findById(id);
	}
	
	public List<Student> findByBatchId(int id) {
		return studentRepository.findByBatchId(id);
	}
	
	public List<Student> findByBatchcode(String code) {
		return studentRepository.findByBatchCode(code);
	}
	
	public List<Student> findBySubject(String subject) {
		return studentRepository.findByBatchSubject(subject);
	}
	
	public List<Student> findByTrainer(String trainer) {
		return studentRepository.findByBatchTrainer(trainer);
	}
}
