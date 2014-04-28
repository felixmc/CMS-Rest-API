package edu.neumont.csc380.cms.service;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import edu.neumont.csc380.cms.model.Auction;
import edu.neumont.csc380.cms.model.CMSData;
import edu.neumont.csc380.cms.model.Media;
import edu.neumont.csc380.cms.model.User;

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

	// TODO: return actual data
	public Response getMediaData(Long mediaId) {
		return getMedia(mediaId);
	}

	// TODO: return actual data
	public Response getMediaThumb(Long mediaId) {
		return getMedia(mediaId);
	}

	public Response deleteMedia(Long id) {
		Media media = CMSData.getInstance().removeMedia(id);

		if (media == null) {
			return Response.status(404).build();
		} else {
			return Response.status(204).build();
		}
	}

	public Response getMediaByUser(Long id) {
		User user = CMSData.getInstance().getUser(id);

		if (user == null) {
			return Response.status(404).build();
		} else {
			return Response.ok(user).build();
		}
	}

	public Response getMediaByAuction(Long id) {
		Auction auction = CMSData.getInstance().getAuction(id);

		if (auction == null) {
			return Response.status(404).build();
		} else {
			return Response.ok(auction).build();
		}
	}

	// TODO: store image data
	public Response setUserProfilePicture(Long userId, Media media, Object data) {
		CMSData cms = CMSData.getInstance();
		User user = cms.getUser(userId);

		if (user == null) {
			return Response.status(404).build();
		} else {
			cms.addMedia(media);
			user.setProfilePicture(media.getId());
			return Response.ok(user).build();
		}
	}

	// TODO: store image data
	public Response addAuctionMedia(Long auctionId, Media media, Object data) {
		CMSData cms = CMSData.getInstance();
		Auction auction = cms.getAuction(auctionId);

		if (auction == null) {
			return Response.status(404).build();
		} else {
			cms.addMedia(media);
			auction.addMedia(media);
			return Response.ok(auction).build();
		}
	}
}
