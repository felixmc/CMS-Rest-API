package edu.neumont.csc380.cms.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import edu.neumont.csc380.cms.model.Media;

@Path("/media")
@Consumes("application/json")
@Produces("application/json")
public interface MediaService {
	@GET
	@Path("/{mediaId}")
	String getMedia(@PathParam("mediaId") Long id);

	@DELETE
	@Path("/{mediaId}")
	String deleteMedia(@PathParam("mediaId") Long id);

	@GET
	@Path("/user/{userId}")
	String getMediaByUser(@PathParam("userId") Long id);

	@PUT
	@Path("/user/{userId}")
	@Consumes("application/json")
	String setUserProfilePicture(@PathParam("userId") Long id,
			@Multipart(value = "rootPart", type = "application/json") Media m,
			@Multipart(value = "book2", type = "image/*") Object data);

	@GET
	@Path("/auction/{auctionId}")
	String getMediaByAuction(@PathParam("auctionId") Long id);

	@POST
	@Path("/auction/{auctionId}")
	@Consumes("application/json")
	String addAuctionMedia(@PathParam("auctionId") Long id,
			@Multipart(value = "rootPart", type = "application/json") Media m,
			@Multipart(value = "book2", type = "image/*") Object data);

}
