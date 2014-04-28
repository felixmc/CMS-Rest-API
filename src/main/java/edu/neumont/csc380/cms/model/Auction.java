package edu.neumont.csc380.cms.model;

import java.util.ArrayList;
import java.util.List;

public class Auction {
	private long auctionId;
	private List<Long> auctionImages;
	private List<Long> auctionVideos;
	
	public Auction(long auctionId, long mediaId, MediaType type){
		this.auctionId = auctionId;
		auctionImages = new ArrayList<Long>();
		auctionVideos = new ArrayList<Long>();
		if( type.isVideo() ){
			auctionVideos.add(mediaId);
		}else{
			auctionImages.add(mediaId);
		}
	}

	public long getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(long auctionId) {
		this.auctionId = auctionId;
	}

	public List<Long> getAuctionImages() {
		return auctionImages;
	}

	public void setAuctionImages(List<Long> auctionImages) {
		this.auctionImages = auctionImages;
	}

	public List<Long> getAuctionVideos() {
		return auctionVideos;
	}

	public void setAuctionVideos(List<Long> auctionVideos) {
		this.auctionVideos = auctionVideos;
	}
}
