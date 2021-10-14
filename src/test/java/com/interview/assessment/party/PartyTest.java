package com.interview.assessment.party;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PartyTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@BeforeAll
	public static void setUp() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
	}

	@Test
	public void test_getParty() throws Exception {
		final var partyId = 1;
		final var url = getUrl("/party/" + partyId);
		ResponseEntity<Party> responseEntity = restTemplate.getForEntity(url, Party.class);
		Party party = responseEntity.getBody();

		assertThat(party).isNotNull();
		// TODO TEST-1: add extra assertions
	}

	@Test
	public void test_getParties() throws Exception {
		ResponseEntity<List<Party>> responseEntity = restTemplate.exchange(
				getUrl("/party"),
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<>() {
				});
		List<Party> parties = responseEntity.getBody();

		// TODO TEST-2: add extra assertions
		assertThat(parties).isNotNull();
	}

	@Test
	public void test_updateParty() throws Exception {
		// TODO TEST-3: open, test PUT endpoint
	}

	@Test
	public void test_addPlayerToParty() throws Exception {
		// TODO TEST-4: open, test PUT endpoint
	}

	@Test
	public void test_removePlayerToParty() throws Exception {
		// TODO TEST-5: open, test PUT endpoint
	}


	@Test
	public void test_getParties_party_integrity() throws Exception {
		ResponseEntity<List<Party>> responseEntity = restTemplate.exchange(
				getUrl("/party"),
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<>() {
				});
		List<Party> parties = responseEntity.getBody();

		assertThat(parties).isNotNull();

		// TODO TEST-6: assert each party has 1 tank, 1 healer and 3 DPS,
		//  if not use the client (restTemplate) to call the api to fix the data,
		//  then assert the party integrity again
	}

	private String getUrl(String extra) {
		return "http://localhost:" + port + extra;
	}
}