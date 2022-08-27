package com.bezkoder.springjwt.message;

/*
 * @author Vivek Kumar
 * Since 19/07/2022
 */
public class NoSuchRecordException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
    public NoSuchRecordException(String message) {
        super(message);
        this.setMessage(message);
    }
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
