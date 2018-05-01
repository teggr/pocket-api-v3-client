package com.robintegg.pocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

@Configuration
public class PocketApiV3ClientConfiguration {

	@Bean
	public ClientHttpRequestFactory clientHttpRequestFactory() {
		return new SimpleClientHttpRequestFactory();
	}
	
}
