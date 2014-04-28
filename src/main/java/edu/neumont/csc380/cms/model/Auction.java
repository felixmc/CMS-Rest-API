package edu.neumont.csc380.cms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Auction implements Serializable {
	private long auctionId;
	private List<Long> auctionImages;
	private List<Long> auctionVideos;

	public Auction() {
		auctionImages = new ArrayList<Long>();
		auctionVideos = new ArrayList<Long>();
	}

	public void addMedia(Media media) {
		if (media.getType().isVideo()) {
			auctionVideos.add(media.getId());
		} else {
			auctionImages.add(media.getId());
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
