package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class GpmTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(GpmTestApplication.class, args);
	}

	@RequestMapping("index")
	@ResponseBody
	public String sayHi() throws IOException {
		return "Hello,我是demosdsadsadsad";
	}
}
