package edu.neumont.csc380.cms.model;

public enum MediaType {
	JPEG(false), PNG(false), MOV(true), MP4(true);

	private boolean isVideo;

	MediaType(boolean isVideo) {
		this.isVideo = isVideo;
	}

	public boolean isVideo() {
		return isVideo;
	}
}
