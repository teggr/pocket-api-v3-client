package com.robintegg.pocket.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.robintegg.pocket.data.PocketDataService;

@Controller
@RequestMapping("/pocket")
public class PocketController {

	@Autowired
	private PocketAuth pocketAuth;

	@Autowired
	private PocketDataService pocketDataService;

	@GetMapping
	public String get() throws IOException {

		pocketDataService.get(pocketAuth.getAccessToken());

		return "list";
	}

}
