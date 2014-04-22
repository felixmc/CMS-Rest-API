package edu.neumont.csc380.hello.service;

import org.springframework.stereotype.Service;

@Service("helloWorldService")
public class HelloWorldServiceImpl implements HelloWorldService {
	public String sayHello(String name) {
		return "Howdy, " + name + "!";
	}
}
