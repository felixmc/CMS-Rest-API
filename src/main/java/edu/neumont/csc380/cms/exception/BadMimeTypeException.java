package edu.neumont.csc380.cms.exception;

public class BadMimeTypeException extends RuntimeException {

	public BadMimeTypeException() {
		super("Bad MIME type for received data.");
	}

}
