package org.jsp.batch_student.exception;

public class InvalidCredentialException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Invalid credentials";
	}
}
