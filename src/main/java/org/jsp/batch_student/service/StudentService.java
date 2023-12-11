package org.jsp.batch_student.service;

import java.util.List;
import java.util.Optional;

import org.jsp.batch_student.dao.BatchDao;
import org.jsp.batch_student.dao.StudentDao;
import org.jsp.batch_student.dto.Batch;
import org.jsp.batch_student.dto.ResponseStructure;
import org.jsp.batch_student.dto.Student;
import org.jsp.batch_student.exception.BatchNotFoundException;
import org.jsp.batch_student.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private BatchDao batchDao;
	
	@Autowired
	private StudentDao studentDao;
	
	public ResponseEntity<ResponseStructure<Student>> saveStudent(Student student, int batch_id) {
		ResponseStructure<Student> structure = new ResponseStructure<>();
		Optional<Batch> dBBatch = batchDao.findById(batch_id);
		if (dBBatch.isPresent()) {
			Batch batch = dBBatch.get();
			batch.getStudents().add(student);
			student.setBatch(batch);
			batchDao.saveBatch(batch);
			structure.setData(studentDao.saveStudent(student));
			structure.setMessage("Student added");
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.CREATED);
		}
		throw new BatchNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Student>> updateStudent(Student student) {
		ResponseStructure<Student> structure = new ResponseStructure<>();
		Optional<Student> recStudent = studentDao.findById(student.getId());
		if (recStudent.isPresent()) {
			Student dbStudent = recStudent.get();
			dbStudent.setName(student.getName());
			dbStudent.setPhone(student.getPhone());
			dbStudent.setPercentage(student.getPercentage());
			structure.setData(studentDao.saveStudent(dbStudent));
			structure.setMessage("Student Updated");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.ACCEPTED);
		}
		throw new StudentNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Student>> findStudentById(int id) {
		Optional<Student> dBStudent = studentDao.findById(id);
		ResponseStructure<Student> structure = new ResponseStructure<>();
		if (dBStudent.isPresent()) {
			structure.setData(dBStudent.get());
			structure.setMessage("Student Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
		}
		throw new StudentNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<List<Student>>> findByBatchId(int id) {
		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		List<Student> student = studentDao.findByBatchId(id);
		if (student.size() > 0) {
			structure.setData(student);
			structure.setMessage("Students Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure, HttpStatus.OK);
		}
		throw new BatchNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<List<Student>>> findByBatchCode(String batchcode) {
		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		List<Student> student = studentDao.findByBatchcode(batchcode);
		if (student.size() > 0) {
			structure.setData(student);
			structure.setMessage("Students Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure, HttpStatus.OK);
		}
		throw new BatchNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<List<Student>>> findByBatchSubject(String subject) {
		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		List<Student> student = studentDao.findBySubject(subject);
		if (student.size() > 0) {
			structure.setData(student);
			structure.setMessage("Students Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure, HttpStatus.OK);
		}
		throw new BatchNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<List<Student>>> findByBatchTrainer(String name) {
		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		List<Student> student = studentDao.findByTrainer(name);
		if (student.size() > 0) {
			structure.setData(student);
			structure.setMessage("Students Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure, HttpStatus.OK);
		}
		throw new BatchNotFoundException();
	}
}
