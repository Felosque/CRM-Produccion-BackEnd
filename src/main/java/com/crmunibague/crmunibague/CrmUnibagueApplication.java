package com.crmunibague.crmunibague;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class CrmUnibagueApplication extends SpringBootServletInitializer {

	@RequestMapping("/")
	@ResponseBody
	String home(){
		return "Hey there";
	}

	public static void main(String[] args) {
		SpringApplication.run(CrmUnibagueApplication.class, args);
	}

}
