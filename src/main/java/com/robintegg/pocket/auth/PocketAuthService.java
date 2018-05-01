package com.robintegg.pocket.auth;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
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

@Service
public class PocketAuthService {

	@Autowired
	public ClientHttpRequestFactory factory;

	@Value("${api.consumerKey}")
	private String consumerKey;

	private String state = "robin";

	public String getRequestToken(String redirectUri) throws Exception {

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

		String code = queryParams.getFirst("code");
		System.out.println(code);
		System.out.println(queryParams.getFirst("state"));

		return code;

	}

	public String authorize(String requestToken, String redirectUri) {

		Map<String, String> authData = new HashMap<>();
		authData.put("requestToken", requestToken);
		authData.put("redirectUri", redirectUri);
		URI authorizeUri = UriComponentsBuilder.fromHttpUrl("https://getpocket.com/auth/authorize")
				.query("request_token={requestToken}&redirect_uri={redirectUri}").build(authData);

		return authorizeUri.toString();

	}

	public String getAccessToken(String requestToken) throws Exception {

		ClientHttpRequest post = factory.createRequest(URI.create("https://getpocket.com/v3/oauth/authorize"),
				HttpMethod.POST);
		post.getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
		post.getHeaders().add("X-Accept", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
		MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
		formData.add("consumer_key", consumerKey);
		formData.add("code", requestToken);

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

		String accessToken = queryParams.getFirst("access_token");
		System.out.println(accessToken);
		System.out.println(queryParams.getFirst("username"));

		return accessToken;
	}

}
