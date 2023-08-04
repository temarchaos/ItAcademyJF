package cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain.Player;
import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.repository.PlayerRepository;

@Service
public class PlayerService {

	private PlayerRepository playerRepository;
	
	@Autowired
	public PlayerService(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}
	
	public Player addPlayer(Player player) {
		Player newPlayer = playerRepository.save(player);
		return newPlayer;
	}
	
	public Player updatePlayer(Player player) {
		Player updatedPlayer = playerRepository.save(player);
		return updatedPlayer;
	}
	
	public void deletePlayerById(int id) {
		playerRepository.deleteById(id);
	}
	
	public Player getPlayerById(int id) {
		Optional<Player> optionalPlayer = playerRepository.findById(id);
		return optionalPlayer.orElse(null);
	}
	
	public List<Player> getAllPlayers(){
		return playerRepository.findAll();
	}
}
