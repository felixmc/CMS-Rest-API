package edu.neumont.csc380.hello.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/hello")
public interface HelloWorldService {
	@GET
	@Path("/{name}")
	@Produces("text/html")
	String sayHello(@PathParam("name") String name);
}
