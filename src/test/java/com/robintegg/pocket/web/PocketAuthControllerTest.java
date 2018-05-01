package com.robintegg.pocket.web;

import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PocketAuthControllerTest {

	@Test
	public void test() {
		
		MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
		formData.add("consumer_key", "a");
		formData.add("redirect_uri", "b");
		formData.add("state", "c");
		
		UriComponents buildAndExpand = UriComponentsBuilder.newInstance().queryParams(formData).build();

		String string = buildAndExpand.getQuery().toString();

		System.out.println(string);
	}

}
