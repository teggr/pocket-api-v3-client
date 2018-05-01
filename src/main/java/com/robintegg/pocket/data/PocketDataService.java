package com.robintegg.pocket.data;

import java.io.IOException;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PocketDataService {

	@Autowired
	public ClientHttpRequestFactory factory;

	@Value("${api.consumerKey}")
	private String consumerKey;

	@Autowired
	private ObjectMapper mapper;

	public PocketData get(String accessToken) throws IOException {

		ClientHttpRequest post = factory.createRequest(URI.create("https://getpocket.com/v3/get"), HttpMethod.POST);
		post.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
		post.getHeaders().add("X-Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
		MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
		formData.add("consumer_key", consumerKey);
		formData.add("access_token", accessToken);
		formData.add("state", "unread");
		formData.add("detailType", "simple");

		UriComponents buildAndExpand = UriComponentsBuilder.newInstance().queryParams(formData).build();

		String string = buildAndExpand.getQuery().toString();

		System.out.println(string);

		post.getBody().write(string.getBytes());

		ClientHttpResponse clientHttpResponse = post.execute();

		System.out.println(clientHttpResponse.getStatusCode());
		System.out.println(clientHttpResponse.getStatusText());

		PocketData pocketData = mapper.readValue(clientHttpResponse.getBody(), PocketData.class);

		// String encodedUrl = IOUtils.toString(clientHttpResponse.getBody(),
		// Charset.defaultCharset());
		// System.out.println(node);

		return pocketData;
	}

}
