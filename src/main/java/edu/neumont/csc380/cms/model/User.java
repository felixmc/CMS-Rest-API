package edu.neumont.csc380.cms.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	private long userId;
	private List<Long> userImages;
	private List<Long> userVideos;
	
	public User(long userId, long mediaId, MediaType type){
		this.userId = userId;
		userImages = new ArrayList<Long>();
		userVideos = new ArrayList<Long>();
		if( type.isVideo() ){
			userVideos.add(mediaId);
		}else{
			userImages.add(mediaId);
		}
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public List<Long> getUserImages() {
		return userImages;
	}

	public void setUserImages(List<Long> userImages) {
		this.userImages = userImages;
	}

	public List<Long> getUserVideos() {
		return userVideos;
	}

	public void setUserVideos(List<Long> userVideos) {
		this.userVideos = userVideos;
	}
	
	
}
