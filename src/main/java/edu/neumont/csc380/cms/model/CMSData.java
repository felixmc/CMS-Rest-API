package edu.neumont.csc380.cms.model;

import java.awt.Dimension;
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
		userMap.put(user.getUserId(),user);
		Media userMedia = new Media();
		addMedia(userMedia);
		userMedia.setCaption("My profile pic! lolz");
		userMedia.setOwnerId(user.getUserId());
		userMedia.setImgaeLocation("/media/" + userMedia.getId() + "/" + "/data");
		userMedia.setThumbnailLocation("/media/" + userMedia.getId() + "/" + "/thumb");
		userMedia.setDimensions(new Dimension(100, 100));
		userMedia.setType(MediaType.PNG);
		user.addMedia(userMedia);
		
		Auction auction = new Auction();
		auction.setAuctionId(auction.getAuctionId());
		auctionMap.put(auction.getAuctionId(), auction);
		auction.addMedia(userMedia);
		
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
