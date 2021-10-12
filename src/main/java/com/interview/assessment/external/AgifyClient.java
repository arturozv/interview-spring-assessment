package com.interview.assessment.external;

import org.springframework.web.client.RestTemplate;

public class AgifyClient {

	RestTemplate restTemplate = new RestTemplate();
	final String url = "https://api.agify.io/?name=";

	public AgifyResponse getAge(String name) {
		var response = restTemplate.getForEntity(url + name, AgifyResponse.class);
		return response.getBody();
	}

}
