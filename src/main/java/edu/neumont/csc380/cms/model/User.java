package edu.neumont.csc380.cms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
	private long userId;
	private List<Long> userImages;
	private List<Long> userVideos;
	private Long profilePicture;

	public User() {
		userImages = new ArrayList<Long>();
		userVideos = new ArrayList<Long>();
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

	public Long getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(Long profilePicture) {
		this.profilePicture = profilePicture;
	}

	public void addMedia(Media media) {
		if (media.getType().isVideo()) {
			userVideos.add(media.getId());
		} else {
			userImages.add(media.getId());
		}
	}

}
