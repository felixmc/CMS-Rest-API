package edu.neumont.csc380.cms.service;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import edu.neumont.csc380.cms.model.CMSData;
import edu.neumont.csc380.cms.model.Media;

@Service("mediaService")
public class MediaServiceImpl implements MediaService {

	public Response getMedia(Long id) {
		Media media = CMSData.getInstance().getMedia(id);

		if (media == null) {
			return Response.status(404).build();
		} else {
			return Response.ok(media).build();
		}
	}

	public Response deleteMedia(Long id) {
		Media media = CMSData.getInstance().removeMedia(id);

		// TODO: Check authorization
		if (media == null) {
			return Response.status(404).build();
		} else {
			return Response.status(204).build();
		}
	}

	public Response getMediaByUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response setUserProfilePicture(Long id, Media media, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response getMediaByAuction(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response addAuctionMedia(Long id, Media media, Object data) {
		// TODO Auto-generated method stub
		return null;
	}
}
