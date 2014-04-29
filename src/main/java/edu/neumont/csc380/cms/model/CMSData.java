package edu.neumont.csc380.cms.model;

import java.util.HashMap;
import java.util.Map;

public class CMSData {
	private static Map<Long, Media> mediaMap;
	private static Map<Long, User> userMap;
	private static Map<Long, Auction> auctionMap;
	private static long currentID;

	private static CMSData data;

	public static CMSData getInstance() {
		if (data == null) {
			data = new CMSData();
		}
		return data;
	}

	public void addMedia(Media mediaObject) {
		mediaObject.setId(getId());
		mediaMap.put(mediaObject.getId(), mediaObject);
	}

	public Media getMedia(Long id) {
		return mediaMap.get(id);
	}

	public Media removeMedia(Long id) {
		return mediaMap.remove(id);
	}

	private CMSData() {
		currentID = 0;
		mediaMap = new HashMap<Long, Media>();
		userMap = new HashMap<Long, User>();
		auctionMap = new HashMap<Long, Auction>();

		User user = new User();
		user.setUserId(getId());
		userMap.put(user.getUserId(), user);

		Media userMedia = new Media();
		addMedia(userMedia);
		userMedia.setCaption("My profile pic! lolz");
		userMedia.setOwnerId(user.getUserId());
		userMedia.setMediaLocation("/media/" + userMedia.getId() + "/"
				+ "/data");
		userMedia.setThumbnailLocation("/media/" + userMedia.getId() + "/"
				+ "/thumb");
		userMedia.setType(MediaType.PNG);
		user.addMedia(userMedia);

		Media userMedia2 = new Media();
		addMedia(userMedia2);
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
