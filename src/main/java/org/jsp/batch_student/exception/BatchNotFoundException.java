package org.jsp.batch_student.exception;

public class BatchNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Batch Not Found";
	}
}
