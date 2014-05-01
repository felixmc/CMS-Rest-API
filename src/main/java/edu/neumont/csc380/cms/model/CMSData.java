package edu.neumont.csc380.cms.model;

import java.util.HashMap;
import java.util.Map;

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

		User user = new User();
		user.setUserId(getId());
		userMap.put(user.getUserId(), user);

		Auction auction = new Auction();
		auction.setAuctionId(getId());
		auctionMap.put(auction.getAuctionId(), auction);
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
