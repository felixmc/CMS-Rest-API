package edu.neumont.csc380.cms.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class BadMimeTypeMapper implements ExceptionMapper<BadMimeTypeException> {

	@Override
	public Response toResponse(BadMimeTypeException e) {
		return Response.status(415).build();
	}

}
