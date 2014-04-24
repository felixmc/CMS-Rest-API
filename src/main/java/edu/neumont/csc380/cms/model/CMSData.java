package edu.neumont.csc380.cms.model;

import java.util.HashMap;

public class CMSData {
	private static HashMap<Long, Media> mediaMap;
	private static CMSData data;
	
	public static CMSData getInstance(){
		if(data == null){
			data = new CMSData();
		}
		return data;
	}
	
	private CMSData(){
		
	}
}
