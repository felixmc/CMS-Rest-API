package edu.neumont.csc380.cms.model;

import java.util.HashMap;
import java.util.Map;

public class CMSData {
	private static Map<Long, Media> mediaMap;
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

	private CMSData() {
		mediaMap = new HashMap<Long, Media>();
	}
}
