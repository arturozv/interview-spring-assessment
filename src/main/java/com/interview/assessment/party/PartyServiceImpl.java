package com.interview.assessment.party;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.interview.assessment.player.Player;
import com.interview.assessment.player.PlayerService;


public class PartyServiceImpl implements PartyService {
	private PlayerService playerService;
	private final Map<Integer, Party> cache = new HashMap<>();
	private Map<Integer, Party> store = new HashMap<>();

	public PartyServiceImpl(PlayerService playerService) {
		this.playerService = playerService;
	}

	public PartyServiceImpl(Map<Integer, Party> store) {
		this.store = store;
	}

	@Override
	public Party getParty(int id) {
		var party = cache.get(id);
		if (party == null) {
			party = store.get(id);
			// TODO: get ages for all party members using PlayerService
			cache.put(party.getId(), party);
		}
		return party;
	}

	@Override
	public void updateParty(Party party) {
		store.put(party.getId(), party);
	}

	@Override
	public void addPlayerToParty(int partyId, Player player) {
		var party = this.getParty(partyId);
		if (party != null) {
			party.addPlayer(player);
		}
	}

	@Override
	public void removePlayerFromParty(int partyId, String playerName) {
		var party = this.getParty(partyId);
		if (party != null) {
			party.removePlayerFromParty(playerName);
		}
	}

	@Override
	public List<Party> getParties() {
		var parties = new ArrayList<>(store.values());
		// TODO: get ages for all party members using PlayerService
		return parties;
	}
}
