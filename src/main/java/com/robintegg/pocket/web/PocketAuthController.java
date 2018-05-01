package com.robintegg.pocket.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.robintegg.pocket.auth.PocketAuthService;

@Controller
@RequestMapping("/auth/pocket")
public class PocketAuthController {

	private String redirectUri = "http://localhost:8080/auth/pocket";

	@Autowired
	private PocketAuth pocketAuth;

	@Autowired
	private PocketAuthService pocketAuthService;

	@PostMapping
	public String post() throws Exception {

		pocketAuth.reset();

		pocketAuth.setRequestToken(pocketAuthService.getRequestToken(redirectUri));

		return "redirect:" + pocketAuthService.authorize(pocketAuth.getRequestToken(), redirectUri);

	}

	@GetMapping
	public String get() throws Exception {

		pocketAuth.setAccessToken(pocketAuthService.getAccessToken(pocketAuth.getRequestToken()));

		return "redirect:/pocket";
	}

}
