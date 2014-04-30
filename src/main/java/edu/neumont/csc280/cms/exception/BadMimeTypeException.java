package edu.neumont.csc280.cms.exception;

public class BadMimeTypeException extends RuntimeException {

	public BadMimeTypeException() {
		super("Bad MIME type for received data.");
	}

}
