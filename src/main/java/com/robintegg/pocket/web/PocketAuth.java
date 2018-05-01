package com.robintegg.pocket.web;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class PocketAuth {

	private String requestToken;
	private String accessToken;

	public void reset() {
		this.requestToken = null;
	}

	public void setRequestToken(String requestToken) {
		this.requestToken = requestToken;
	}

	public String getRequestToken() {
		return requestToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getAccessToken() {
		return accessToken;
	}
}
