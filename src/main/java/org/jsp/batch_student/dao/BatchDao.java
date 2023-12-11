package org.jsp.batch_student.dao;

import java.util.Optional;

import org.jsp.batch_student.dto.Batch;
import org.jsp.batch_student.repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BatchDao {
	
	@Autowired
	private BatchRepository batchRepository;
	
	public Batch saveBatch(Batch batch) {
		return batchRepository.save(batch);
	}
	
	public Batch updateBatch(Batch batch) {
		return batchRepository.save(batch);
	}
	
	public Optional<Batch> findById(int id) {
		return batchRepository.findById(id);
	}
	
	public Optional<Batch> FindByStudentId(int id){
		return batchRepository.findBatchById(id);
	}
	
	public Optional<Batch> FindByStudentPhone(long phone){
		return batchRepository.findBatchByPhone(phone);
	}
}