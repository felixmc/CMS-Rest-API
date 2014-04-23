package edu.neumont.csc380.cms.service;

import org.springframework.stereotype.Service;

import edu.neumont.csc380.cms.model.Media;

@Service("mediaService")
public class MediaServiceImpl implements MediaService {

	public String getMedia(Long id) {
		return "media with id " + id;
	}

	public String deleteMedia(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMediaByUser(Long id) {
		// TODO Auto-generated method stub
		return "media with user id " + id;
	}

	public String setUserProfilePicture(Long id, Media media, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMediaByAuction(Long id) {
		// TODO Auto-generated method stub
		return "media with auction id " + id;
	}

	public String addAuctionMedia(Long id, Media media, Object data) {
		// TODO Auto-generated method stub
		return null;
	}
}
