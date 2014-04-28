package edu.neumont.csc380.cms.model;

import java.util.HashMap;
import java.util.Map;

public class CMSData {
	private static Map<Long, Media> mediaMap;
	private static Map<Long, User> userMap;
	private static Map<Long, Auction> auctionMap;
	
	private static CMSData data;

	public static CMSData getInstance() {
		if (data == null) {
			data = new CMSData();
		}
		return data;
	}

	public Media getMedia(Long id) {
		return mediaMap.get(id);
	}

	public Media removeMedia(Long id) {
		return mediaMap.remove(id);
	}

	private CMSData() {
		mediaMap = new HashMap<Long, Media>();
	}
	
	public User getUser(long id){
		return userMap.get(id);
	}
	
	public Auction getAuction(long id){
		return auctionMap.get(id);
	}
}
