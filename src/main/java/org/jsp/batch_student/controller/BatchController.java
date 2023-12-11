package org.jsp.batch_student.controller;

import org.jsp.batch_student.dto.Batch;
import org.jsp.batch_student.dto.ResponseStructure;
import org.jsp.batch_student.service.BatchService;
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
public class BatchController {
	@Autowired
	private BatchService batchService;
	
	@PostMapping("/batchs")
	public ResponseEntity<ResponseStructure<Batch>> saveBatch(@RequestBody Batch batch) {
		return batchService.saveBatch(batch);
	}
	
	@PutMapping("/batchs")
	public ResponseEntity<ResponseStructure<Batch>> updateBatch(@RequestBody Batch batch) {
		return batchService.updateBatch(batch);
	}
	
	@GetMapping("/batchs/{id}")
	public ResponseEntity<ResponseStructure<Batch>> findBatchById(@PathVariable int id) {
		return batchService.findBatchById(id);
	}
	
	@GetMapping("/batchs/studentid")
	public ResponseEntity<ResponseStructure<Batch>> findBatchByStudentId(@RequestParam int student_id) {
		return batchService.FindBatchByStudentId(student_id);
	}
	
	@GetMapping("/batchs/studentphone/{student_phone}")
	public ResponseEntity<ResponseStructure<Batch>> findBatchByStudentPhone(@PathVariable long student_phone) {
		return batchService.FindBatchByStudentPhone(student_phone);
	}
}
