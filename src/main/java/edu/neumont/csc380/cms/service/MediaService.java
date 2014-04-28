package edu.neumont.csc380.cms.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.Multipart;

import edu.neumont.csc380.cms.model.Media;

@Path("/media")
@Consumes("application/json")
@Produces("application/json")
public interface MediaService {
	@GET
	@Path("/{mediaId}")
	Response getMedia(@PathParam("mediaId") Long id);

	@GET
	@Path("/{mediaId}/data")
	Response getMediaData(@PathParam("mediaId") Long id);

	@GET
	@Path("/{mediaId}/thumb")
	Response getMediaThumb(@PathParam("mediaId") Long id);

	@DELETE
	@Path("/{mediaId}")
	Response deleteMedia(@PathParam("mediaId") Long id);

	@GET
	@Path("/user/{userId}")
	Response getMediaByUser(@PathParam("userId") Long id);

	@PUT
	@Path("/user/{userId}")
	@Consumes("application/json")
	Response setUserProfilePicture(@PathParam("userId") Long id,
			@Multipart(value = "rootPart", type = "application/json") Media m,
			@Multipart(value = "book2", type = "image/*") Object data);

	@GET
	@Path("/auction/{auctionId}")
	Response getMediaByAuction(@PathParam("auctionId") Long id);

	@POST
	@Path("/auction/{auctionId}")
	@Consumes("application/json")
	Response addAuctionMedia(@PathParam("auctionId") Long id,
			@Multipart(value = "rootPart", type = "application/json") Media m,
			@Multipart(value = "book2", type = "image/*") Object data);

}
