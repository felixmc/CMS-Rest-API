package edu.neumont.csc380.cms.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	private long userId;
	private List<Long> userImages;
	private List<Long> userVideos;

	public User(long userId, long mediaId, MediaType type) {
		this.userId = userId;
		userImages = new ArrayList<Long>();
		userVideos = new ArrayList<Long>();
		if (type.isVideo()) {
			userVideos.add(mediaId);
		} else {
			userImages.add(mediaId);
		}
	}

}
