package edu.neumont.csc280.cms.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.apache.cxf.interceptor.security.AuthenticationException;

public class AuthorizationMapper implements
		ExceptionMapper<AuthenticationException> {

	@Override
	public Response toResponse(AuthenticationException e) {
		return Response.status(401).build();
	}

}
