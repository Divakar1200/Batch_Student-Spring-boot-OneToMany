package org.jsp.batch_student.repository;

import java.util.List;

import org.jsp.batch_student.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	@Query("select s from Student s where s.batch.id=?1")
	public List<Student> findByBatchId(int id);
	
	@Query("select s from Student s where s.batch.batchcode=?1")
	public List<Student> findByBatchCode(String code);
	
	@Query("select s from Student s where s.batch.subject=?1")
	public List<Student> findByBatchSubject(String subject);
	
	@Query("select s from Student s where s.batch.trainer=?1")
	public List<Student> findByBatchTrainer(String trainer);
}
