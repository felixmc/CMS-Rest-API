package edu.neumont.csc380.cms.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.cxf.interceptor.security.AuthenticationException;

@Provider
public class AuthorizationMapper implements
		ExceptionMapper<AuthenticationException> {

	@Override
	public Response toResponse(AuthenticationException e) {
		return Response.status(401).build();
	}

}
