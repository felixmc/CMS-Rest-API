package edu.neumont.csc380.cms.model;

import java.awt.Dimension;
import java.util.Date;

public class Media {
	private long id;
	private long ownerId;
	private MediaType type;
	private String imageLocation;
	private String thumbnailLocation;
	private String caption;
	private Dimension dimensions;
	private Date dateCreated;
	
	public Media(){
		this.dateCreated = new Date();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}

	public MediaType getType() {
		return type;
	}

	public void setType(MediaType type) {
		this.type = type;
	}

	public String getImgaeLocation() {
		return imageLocation;
	}

	public void setImgaeLocation(String imgaeLocation) {
		this.imageLocation = imgaeLocation;
	}

	public String getThumbnailLocation() {
		return thumbnailLocation;
	}

	public void setThumbnailLocation(String thumbnailLocation) {
		this.thumbnailLocation = thumbnailLocation;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public Dimension getDimensions() {
		return dimensions;
	}

	public void setDimensions(Dimension dimensions) {
		this.dimensions = dimensions;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
}
