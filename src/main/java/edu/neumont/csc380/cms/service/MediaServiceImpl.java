package edu.neumont.csc380.cms.service;

import org.springframework.stereotype.Service;

@Service("mediaService")
public class MediaServiceImpl implements MediaService {
	public String sayHello(String name) {
		return "Howdy, " + name + "!";
	}
}
