package cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.services;

import java.time.LocalDate;
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
		player.setRegistrationDate(LocalDate.now());
		return playerRepository.save(player);
	}
	
	public Player updatePlayer(Player player) {
		Optional<Player> optionalPlayer = playerRepository.findById(player.getPk_PlayerID());
		if (optionalPlayer.isPresent()) {
			Player updatedPlayer = optionalPlayer.get();
			updatedPlayer.setPlayerName(player.getPlayerName());
			return playerRepository.save(updatedPlayer);
		}
		
		return null;
	}
	
	public void deletePlayerById(int id) {
		playerRepository.deleteById(id);
	}
	
	public Player getPlayerById(int id) {
		Optional<Player> optionalPlayer = playerRepository.findById(id);
		return optionalPlayer.orElse(null);
	}
	
	public List<Player> getAllPlayers() {
		return playerRepository.findAll();
	}
}