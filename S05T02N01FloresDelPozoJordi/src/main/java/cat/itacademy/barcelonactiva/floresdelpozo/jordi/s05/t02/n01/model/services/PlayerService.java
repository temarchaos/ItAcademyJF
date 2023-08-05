package cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain.Player;
import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain.exception.DuplicatePlayerNameException;
import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.repository.GameRepository;
import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	public Player addPlayer(Player player) {
		String playerName = player.getPlayerName();
		if (playerRepository.findByPlayerName(playerName).isPresent()) {
			throw new DuplicatePlayerNameException("El nom del jugador ja existeix: " + playerName);
		}
		
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
	
	public Player getPlayerById(int id) {
		Optional<Player> optionalPlayer = playerRepository.findById(id);
		return optionalPlayer.orElse(null);
	}
	
	public List<PlayerDTO> getAllPlayersWithWinPercentage() {
		List<Player> allPlayers = getAllPlayers();
		List<PlayerDTO> allPlayersDTO = new ArrayList<PlayerDTO>();
		for (Player player : allPlayers) {
			int totalGames = gameRepository.countGamesByPlayer(player);
			int wonGames = gameRepository.countWonGamesByPlayer(player);
			double winPercentage = (totalGames > 0) ? ((double) wonGames / totalGames) * 100 : 0.0;
			PlayerDTO playerDTO = new PlayerDTO(player.getPk_PlayerID(), player.getPlayerName(),
                    player.getRegistrationDate(), player.getGames(), winPercentage);
			
			allPlayersDTO.add(playerDTO);
		}
		
		return allPlayersDTO;
	}
	
	public List<PlayerDTO> getRanking(){
		List<PlayerDTO> allPlayersDTO = getAllPlayersWithWinPercentage();
		Collections.sort(allPlayersDTO);
		return allPlayersDTO;
	}
	
	public List<Player> getAllPlayers() {
		return playerRepository.findAll();
	}
}