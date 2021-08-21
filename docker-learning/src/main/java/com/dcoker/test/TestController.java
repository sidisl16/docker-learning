package com.dcoker.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Autowired
	private Environment environment;

	@RequestMapping("/docker/test")
	public String getMessage() throws IOException {
		StringBuffer buf = new StringBuffer();
		Files.readAllLines(Path.of("/usr", "/share", "/test", "/file.txt")).forEach(str -> buf.append(str).append(" "));
		return buf.toString();
	}
	
	@RequestMapping("/docker/sys/name")
	public String getSystemName() {
		return environment.getProperty("hostname");
	}
}
