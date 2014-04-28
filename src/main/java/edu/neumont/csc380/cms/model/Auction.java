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
		if( type.isVideo ){
			auctionVideos.add(mediaId);
		}else{
			auctionImages.add(mediaId);
		}
	}
}
