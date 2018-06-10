package com.robintegg.pocket.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.robintegg.pocket.data.PocketDataService;

@Controller
@RequestMapping("/pocket")
public class PocketController {

	@Autowired
	private PocketAuth pocketAuth;

	@Autowired
	private PocketDataService pocketDataService;

	@GetMapping
	public String get(@RequestParam(name = "state", required = false, defaultValue = "unread") String state,
			Model model) throws Exception {

		model.addAttribute("yamlContent", YamlView.of(pocketDataService.get(pocketAuth.getAccessToken(), state)));

		return "list";
	}

}
