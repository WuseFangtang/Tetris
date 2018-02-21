package DAO;

import java.util.ArrayList;
import java.util.List;

import Dto.Player;

public class DataTest implements Data {

	@Override
	public List<Player> loadData() {
		List<Player> players = new ArrayList<>();
		
		return players;
	}

	@Override
	public void saveData(Player players) {
		System.out.println("st");
		
	}

}
