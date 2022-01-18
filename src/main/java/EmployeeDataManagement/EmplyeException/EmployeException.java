package EmployeeDataManagement.EmplyeException;

import org.springframework.stereotype.Component;

/*
 * This is the exception class from runtime class exception
 * its provide custom exception for our employee management
 * This component annotation use in spring to detect automatically our custom beans
 *  */

@Component
public class EmployeException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	private String status;
	private String error;
	private String path;
	
	/*
	 * here I'm adding setters and getters for our Employee exception
	 * by use toString its gives result properly
	 *  */
	
	public EmployeException() {
		super();
	}
	public EmployeException(String status, String error, String path) {
		super();
		this.status = status;
		this.error = error;
		this.path = path;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	
	@Override
	public String toString() {
		return "EmployeException "+"\r\n"+" status=" + status + "\r\n "+"error=" + error + "\r\n "+"path=" + path + " ";
	}
	
	
	
	

}

