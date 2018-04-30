package com.robintegg.pocket.web;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/pocket")
public class PocketController {

	public ClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();

	@Value("${api.consumerKey}")
	private String consumerKey;

	private String redirectUri = "http://localhost:8080/auth-finished.html";

	private String state = "robin";

	@PostMapping
	public String post() throws IOException {

		ClientHttpRequest post = factory.createRequest(URI.create("https://getpocket.com/v3/oauth/request"),
				HttpMethod.POST);
		post.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
		post.getHeaders().add("X-Accept", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
		MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
		formData.add("consumer_key", consumerKey);
		formData.add("redirect_uri", redirectUri);
		formData.add("state", state);
		
		UriComponents buildAndExpand = UriComponentsBuilder.newInstance().queryParams(formData).build();

		String string = buildAndExpand.getQuery().toString();

		System.out.println(string);

		post.getBody().write(string.getBytes());

		ClientHttpResponse clientHttpResponse = post.execute();

		System.out.println(clientHttpResponse.getStatusCode());
		System.out.println(clientHttpResponse.getStatusText());
		String encodedUrl = IOUtils.toString(clientHttpResponse.getBody(), Charset.defaultCharset());
		System.out.println(encodedUrl);
		
		UriComponents build2 = UriComponentsBuilder.newInstance().query(encodedUrl).build();
		MultiValueMap<String, String> queryParams = build2.getQueryParams();
		
		System.out.println(queryParams.getFirst("code"));
		System.out.println(queryParams.getFirst("state"));
		
		return "redirect:/";

	}

}
