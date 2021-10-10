package com.interview.assessment.party;

import java.util.Arrays;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.interview.assessment.player.Player;
import com.interview.assessment.player.Role;
import static org.assertj.core.api.Assertions.assertThat;

// TODO: implement unit tests for PartyService
public class PartyServiceTest {

	@Test
	public void test_getParty(){
		var partyService = getPartyService();
		var party = partyService.getParty(1);
		assertThat(party).isNotNull();

		// TODO: add extra assertions
	}

	private PartyService getPartyService() {
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
}
