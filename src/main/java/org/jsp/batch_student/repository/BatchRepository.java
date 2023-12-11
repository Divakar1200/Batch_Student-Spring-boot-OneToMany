package org.jsp.batch_student.repository;

import java.util.Optional;

import org.jsp.batch_student.dto.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BatchRepository extends JpaRepository<Batch, Integer>{

	@Query("select b FROM Batch b join fetch b.students s where s.id =?1")
	public Optional<Batch> findBatchById(int Student_id);
	
	@Query("select b FROM Batch b join fetch b.students s where s.phone =?1")
	public Optional<Batch> findBatchByPhone(long Student_phone);
}
