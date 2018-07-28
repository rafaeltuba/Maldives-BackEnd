package com.maldives.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signup")
public class SignUpController {
	
	public SignUpController() {
		System.out.println("Created...");
	}
	
	
	@RequestMapping("/company")
    public String company() {
		System.out.println("Chamei  rest.");
        return "company";
    }

}
