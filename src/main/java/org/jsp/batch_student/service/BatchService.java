package org.jsp.batch_student.service;

import java.util.Optional;

import org.jsp.batch_student.dao.BatchDao;
import org.jsp.batch_student.dto.Batch;
import org.jsp.batch_student.dto.ResponseStructure;
import org.jsp.batch_student.exception.BatchNotFoundException;
import org.jsp.batch_student.exception.InvalidCredentialException;
import org.jsp.batch_student.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BatchService {
	@Autowired
	private BatchDao batchDao;
	
	public ResponseEntity<ResponseStructure<Batch>> saveBatch(Batch batch) {
		ResponseStructure<Batch> structure = new ResponseStructure<>();
		structure.setData(batchDao.saveBatch(batch));
		structure.setMessage("Batch Saved");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Batch>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Batch>> updateBatch(Batch batch) {
		ResponseStructure<Batch> structure = new ResponseStructure<>();
		Optional<Batch> recBatch = batchDao.findById(batch.getId());
		if (recBatch.isPresent()) {
			Batch dbBatch = recBatch.get();
			dbBatch.setSubject(batch.getSubject());
			dbBatch.setBatchcode(batch.getBatchcode());
			dbBatch.setTrainer(batch.getTrainer());
			structure.setData(batchDao.saveBatch(dbBatch));
			structure.setMessage("Batch Updated");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Batch>>(structure, HttpStatus.ACCEPTED);
		}
		throw new BatchNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Batch>> findBatchById(int id) {
		Optional<Batch> dBBatch = batchDao.findById(id);
		ResponseStructure<Batch> structure = new ResponseStructure<>();
		if (dBBatch.isPresent()) {
			structure.setData(dBBatch.get());
			structure.setMessage("Batch Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Batch>>(structure, HttpStatus.OK);
		}
		throw new StudentNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Batch>> FindBatchByStudentId(int id) {
		ResponseStructure<Batch> structure = new ResponseStructure<>();
		Optional<Batch> dbBatch = batchDao.FindByStudentId(id);
		if (dbBatch.isPresent()) {
			structure.setMessage("Batch Verified succesfully");
			structure.setData(dbBatch.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Batch>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialException();
	}
	
	public ResponseEntity<ResponseStructure<Batch>> FindBatchByStudentPhone(long phone) {
		ResponseStructure<Batch> structure = new ResponseStructure<>();
		Optional<Batch> dbBatch = batchDao.FindByStudentPhone(phone);
		if (dbBatch.isPresent()) {
			structure.setMessage("Batch Verified succesfully");
			structure.setData(dbBatch.get());
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Batch>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialException();
	}
}
