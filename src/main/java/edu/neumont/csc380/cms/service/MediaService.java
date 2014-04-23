package edu.neumont.csc380.cms.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

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
	@Produces("application/json")
	String getMediaByUser(@PathParam("userId") Long id);

	@POST
	@Path("/user/{userId}")
	@Consumes("application/json")
	String setUserProfilePicture(@PathParam("userId") Long id);

	@GET
	@Path("/auction/{auctionId}")
	String getMediaByAuction(@PathParam("auctionId") Long id);

	@POST
	@Path("/auction/{auctionId}")
	@Consumes("application/json")
	String addAuctionMedia(@PathParam("auctionId") Long id);

}
