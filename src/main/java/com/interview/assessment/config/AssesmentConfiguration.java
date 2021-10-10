package com.interview.assessment.config;

import java.util.Arrays;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.interview.assessment.external.AgifyClient;
import com.interview.assessment.party.Party;
import com.interview.assessment.party.PartyService;
import com.interview.assessment.party.PartyServiceImpl;
import com.interview.assessment.player.Player;
import com.interview.assessment.player.PlayerService;
import com.interview.assessment.player.PlayerServiceImpl;
import com.interview.assessment.player.Role;

@Configuration
public class AssesmentConfiguration {

	@Bean
	public PartyService partyService() {
		var party1 = new Party(Arrays.asList(
				new Player("Ana", Role.TANK),
				new Player("Cris", Role.HEALER),
				new Player("Joe", Role.DPS),
				new Player("Alex", Role.DPS),
				new Player("Emma", Role.DPS)
		));

		var party2 = new Party(Arrays.asList(
				new Player("Beatrice", Role.DPS),
				new Player("James", Role.HEALER),
				new Player("Henry", Role.DPS),
				new Player("Alice", Role.DPS),
				new Player("John", Role.DPS)
		));

		Map<Integer, Party> parties = Map.of(
				party1.getId(), party1,
				party2.getId(), party2
		);

		return new PartyServiceImpl(parties);
	}

	@Bean
	public PlayerService playerService() {
		var agifyClient = new AgifyClient();
		return new PlayerServiceImpl(agifyClient);
	}
}
