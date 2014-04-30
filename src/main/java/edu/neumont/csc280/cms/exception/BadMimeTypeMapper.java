package edu.neumont.csc280.cms.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class BadMimeTypeMapper implements
		ExceptionMapper<BadMimeTypeException> {

	@Override
	public Response toResponse(BadMimeTypeException e) {
		return Response.status(415).build();
	}

}
