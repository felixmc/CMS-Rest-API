package edu.neumont.csc380.cms.model;

import edu.neumont.csc280.cms.exception.BadMimeTypeException;

public enum MediaType {
	JPEG(false), PNG(false), MOV(true), MP4(true);

	private boolean isVideo;

	MediaType(boolean isVideo) {
		this.isVideo = isVideo;
	}

	public boolean isVideo() {
		return isVideo;
	}

	public String toMIME() {
		String type = this == MOV ? "quicktime" : this.toString();
		return (isVideo ? "video" : "image") + "/" + type;
	}

	public static MediaType parse(String mimeType) {
		switch (mimeType.toLowerCase()) {
		case ("image/png"):
			return PNG;
		case ("image/jpeg"):
			return JPEG;
		case ("video/mp4"):
			return MP4;
		case ("video/quicktime"):
			return MOV;
		default:
			throw new BadMimeTypeException();
		}
	}
}
