package com.interview.assessment.player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.interview.assessment.external.AgifyClient;

public class PlayerServiceTest {

	@Test
	public void test_getAge() {
		// TODO: mock agify api, feel free to add a new mocking library
		var agifyClient = new AgifyClient();

		var playerService = new PlayerServiceImpl(agifyClient);
		Integer age = playerService.getAge("Anna");
		Assertions.assertNotNull(age);
	}
}
