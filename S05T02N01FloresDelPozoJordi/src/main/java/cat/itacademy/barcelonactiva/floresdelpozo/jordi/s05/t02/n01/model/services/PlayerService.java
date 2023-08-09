package cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain.Player;
import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain.Role;
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
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public Player addPlayer(Player player) {
		String username = player.getUsername();
		if (playerRepository.findByUsername(username).isPresent()) {
			throw new DuplicatePlayerNameException("El nom del jugador ja existeix: " + username);
		}
		
		Player newPlayer = new Player();
		
		newPlayer.setUsername(username);
		String encodedPassword = passwordEncoder.encode(player.getPassword());
		newPlayer.setPassword(encodedPassword);
		newPlayer.setRegistrationDate(LocalDate.now());
		newPlayer.setRole(Role.USER);
		
		return playerRepository.save(newPlayer);
	}
	
	public Player updatePlayer(Player player) {
		Optional<Player> optionalPlayer = playerRepository.findById(player.getPk_PlayerID());
		if (optionalPlayer.isPresent()) {
			Player updatedPlayer = optionalPlayer.get();
			updatedPlayer.setUsername(player.getUsername());
			
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
			PlayerDTO playerDTO = new PlayerDTO(player.getPk_PlayerID(), player.getUsername(),
                    player.getPassword(), player.getRegistrationDate(), player.getGames(), 
                    player.getRole(), winPercentage);
			
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
	
	public Player getPlayerByUsername(String username) {
		Optional<Player> optionalPlayer = playerRepository.findByUsername(username);
		return optionalPlayer.orElse(null);
	}
}