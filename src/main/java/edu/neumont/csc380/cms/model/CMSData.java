package edu.neumont.csc380.cms.model;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class CMSData {
	private static Map<Long, Media> mediaMap;
	private static Map<Long, User> userMap;
	private static Map<Long, Auction> auctionMap;
	private static Map<Long, byte[]> dataMap;
	private static long currentID;

	private static CMSData data;

	public static CMSData getInstance() {
		if (data == null) {
			data = new CMSData();
		}
		return data;
	}

	public void addMedia(Media mediaObject, byte[] data) {
		mediaObject.setId(getId());
		mediaMap.put(mediaObject.getId(), mediaObject);
		dataMap.put(mediaObject.getId(), data);
	}

	public Media getMedia(Long id) {
		return mediaMap.get(id);
	}

	public byte[] getData(long id) {
		return dataMap.get(id);
	}

	public Media removeMedia(Long id) {
		return mediaMap.remove(id);
	}

	private CMSData() {
		currentID = 0;
		mediaMap = new HashMap<Long, Media>();
		userMap = new HashMap<Long, User>();
		auctionMap = new HashMap<Long, Auction>();
		dataMap = new HashMap<Long, byte[]>();

		String path = CMSData.class.getResource("").getPath()
				+ "../../../../../../../";

		User user = new User();
		user.setUserId(getId());
		userMap.put(user.getUserId(), user);

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(path + "cat.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		WritableRaster raster = img.getRaster();
		DataBufferByte data = (DataBufferByte) raster.getDataBuffer();

		Media userMedia = new Media();
		addMedia(userMedia, data.getData());
		userMedia.setCaption("My profile pic! lolz");
		userMedia.setOwnerId(user.getUserId());
		userMedia.setMediaLocation("/media/" + userMedia.getId() + "/"
				+ "/data");
		userMedia.setThumbnailLocation("/media/" + userMedia.getId() + "/"
				+ "/thumb");
		userMedia.setType(MediaType.JPEG);
		user.addMedia(userMedia);

		try {
			img = ImageIO.read(new File(path + "duck.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		raster = img.getRaster();
		data = (DataBufferByte) raster.getDataBuffer();

		Media userMedia2 = new Media();
		addMedia(userMedia2, data.getData());
		userMedia2.setCaption("me and my cattt");
		userMedia2.setOwnerId(user.getUserId());
		userMedia2.setMediaLocation("/media/" + userMedia2.getId() + "/"
				+ "/data");
		userMedia2.setThumbnailLocation("/media/" + userMedia2.getId() + "/"
				+ "/thumb");
		userMedia2.setType(MediaType.JPEG);
		user.addMedia(userMedia2);

		Auction auction = new Auction();
		auction.setAuctionId(getId());
		auctionMap.put(auction.getAuctionId(), auction);
		auction.addMedia(userMedia2);
	}

	public User getUser(long id) {
		return userMap.get(id);
	}

	public Auction getAuction(long id) {
		return auctionMap.get(id);
	}

	public long getId() {
		currentID++;
		return currentID;
	}
}
