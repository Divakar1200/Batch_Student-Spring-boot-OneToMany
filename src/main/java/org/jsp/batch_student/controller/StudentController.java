package org.jsp.batch_student.controller;

import java.util.List;

import org.jsp.batch_student.dto.ResponseStructure;
import org.jsp.batch_student.dto.Student;
import org.jsp.batch_student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/students/{batch_id}")
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student student, @PathVariable int batch_id) {
		return studentService.saveStudent(student, batch_id);
	}
	
	@PutMapping("/students")
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<ResponseStructure<Student>> findByStudentId(@PathVariable int id) {
		return studentService.findStudentById(id);
	}
	
	@GetMapping("/students/by-batchid/{batch_id}")
	public ResponseEntity<ResponseStructure<List<Student>>> findByBatchId(@PathVariable int batch_id) {
		return studentService.findByBatchId(batch_id);
	}
	
	@GetMapping("/students/by-batchcode/{batch_code}")
	public ResponseEntity<ResponseStructure<List<Student>>> findByBatchId(@PathVariable String batch_code) {
		return studentService.findByBatchCode(batch_code);
	}
	
	@GetMapping("/students/by-subject")
	public ResponseEntity<ResponseStructure<List<Student>>> findByBatchSubject(@RequestParam String subject) {
		return studentService.findByBatchSubject(subject);
	}
	
	@GetMapping("/students/by-batchtrainer/{batch_trainer}")
	public ResponseEntity<ResponseStructure<List<Student>>> findByAdminId(@PathVariable String batch_trainer) {
		return studentService.findByBatchTrainer(batch_trainer);
	}
}
	