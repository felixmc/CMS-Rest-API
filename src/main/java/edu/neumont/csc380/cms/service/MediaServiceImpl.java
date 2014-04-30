package edu.neumont.csc380.cms.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import edu.neumont.csc380.cms.model.Auction;
import edu.neumont.csc380.cms.model.CMSData;
import edu.neumont.csc380.cms.model.Media;
import edu.neumont.csc380.cms.model.MediaType;
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

	public Response getMediaData(Long id) {
		Media media = CMSData.getInstance().removeMedia(id);

		if (media == null) {
			return Response.status(404).build();
		} else {
			return Response.ok(CMSData.getInstance().getData(id))
					.header("content-type", media.getType()).build();
		}
	}

	public Response getMediaThumb(Long mediaId) {
		return getMediaData(mediaId);
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

	public Response setUserProfilePicture(Long userId, String caption,
			byte[] data, String contentType) {
		CMSData cms = CMSData.getInstance();
		User user = cms.getUser(userId);

		if (user == null) {
			return Response.status(404).build();
		} else {
			Media media = new Media();
			media.setCaption(caption);
			media.setOwnerId(0); // TODO: get owner from authorization

			media.setType(MediaType.parse("image/png"));

			cms.addMedia(media, data);
			user.addMedia(media);

			media.setMediaLocation("/media/data/" + media.getId() + "/data");
			media.setThumbnailLocation("/media/data/" + media.getId()
					+ "/thumb");

			BufferedImage buf;
			try {
				buf = ImageIO.read(new ByteArrayInputStream(data));
				media.setHeight(buf.getHeight());
				media.setWidth(buf.getWidth());
			} catch (IOException e) {
				e.printStackTrace();
			}

			return Response.status(201).build();
		}
	}

	public Response addAuctionMedia(Long auctionId, String caption,
			byte[] data, String[] contentType) {
		CMSData cms = CMSData.getInstance();
		Auction auction = cms.getAuction(auctionId);

		if (auction == null) {
			return Response.status(404).build();
		} else {
			Media media = new Media();
			media.setCaption(caption);

			System.out.println("TYPE: " + contentType.length);

			media.setType(MediaType.parse("image/png"));

			cms.addMedia(media, data);
			auction.addMedia(media);
			media.setOwnerId(0); // TODO: get owner from authorization
			// TODO: add media to user

			media.setMediaLocation("/media/data/" + media.getId() + "/data");
			media.setThumbnailLocation("/media/data/" + media.getId()
					+ "/thumb");

			BufferedImage buf;
			try {
				buf = ImageIO.read(new ByteArrayInputStream(data));
				media.setHeight(buf.getHeight());
				media.setWidth(buf.getWidth());
			} catch (IOException e) {
				e.printStackTrace();
			}

			return Response.status(201).build();
		}
	}
}
