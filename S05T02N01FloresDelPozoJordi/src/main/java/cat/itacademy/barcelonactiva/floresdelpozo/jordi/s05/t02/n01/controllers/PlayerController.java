package cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.controllers;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain.Game;
import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain.Player;
import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain.exception.DuplicatePlayerNameException;
import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.services.GameService;
import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.services.PlayerService;

@Controller
@RequestMapping("/players")
@CrossOrigin(origins = "http://localhost:8080")
public class PlayerController {

	@Autowired
	private PlayerService playerService;
	@Autowired
	private GameService gameService;
	
	private DecimalFormat df = new DecimalFormat("#.##");
	
	private Player currentPlayer;
	
	// POST: /players: crea un jugador/a. 
	@PostMapping("")
	public ResponseEntity<Object> addPlayer(@RequestBody Player player) {
		try {
			Player newPlayer = playerService.addPlayer(player);
			return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
		} catch (DuplicatePlayerNameException e) {
			return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.CONFLICT);
		}
	}
	
	// PUT /players: modifica el nom del jugador/a.
	@PutMapping("")
	public ResponseEntity<Object> updatePlayer(@RequestBody Player player) {
		Player updatedPlayer = playerService.getPlayerById(player.getPk_PlayerID());
		if (updatedPlayer != null) {
			updatedPlayer = playerService.updatePlayer(player);
			return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);			
		}else {
			return new ResponseEntity<>("No s'ha trobat el jugador", HttpStatus.NOT_FOUND);
		}
	}
	
	// POST /players/{id}/games/ : un jugador/a específic realitza una tirada dels daus.
	@PostMapping("/{id}/games/")
	public ResponseEntity<Object> addGameToPlayer(@PathVariable("id") int playerId, @RequestBody Game game) {
		Player player = playerService.getPlayerById(playerId);
        if (player != null) {
            Game newGame = gameService.addGameToPlayer(player, game);
            return new ResponseEntity<>(newGame, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("No s'ha trobat el jugador", HttpStatus.NOT_FOUND);
        }
	}
	
	// DELETE /players/{id}/games: elimina les tirades del jugador/a.
	@DeleteMapping("/{id}/games")
	public ResponseEntity<Object> deleteAllGamesByPlayer(@PathVariable("id") int playerId) {
		Player player = playerService.getPlayerById(playerId);
		if (player != null) {
            gameService.deleteAllGamesByPlayer(player);
            return new ResponseEntity<>("Totes les partides del jugador: " + player.getPlayerName() +", han estat eliminades", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No s'ha trobat el jugador", HttpStatus.NOT_FOUND);
        }
	}
	
	// GET /players/: retorna el llistat de tots  els jugadors/es del sistema amb el seu  percentatge mitjà d’èxits.
	@GetMapping("/")
	public ResponseEntity<Object> getAllPlayersWithWinPercentage(){
		List<PlayerDTO> allPlayersDTO = playerService.getAllPlayersWithWinPercentage();
		if (!allPlayersDTO.isEmpty()) {
			return new ResponseEntity<>(allPlayersDTO.toString(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>("No hi ha jugadors en la base de dades", HttpStatus.OK);
		}
	}
	
	// GET /players/{id}/games: retorna el llistat de jugades per un jugador/a.
	@GetMapping("/{id}/games")
	public ResponseEntity<Object> getAllGamesByPlayer(@PathVariable("id") int playerId) {
		Player player = playerService.getPlayerById(playerId);
		if (player != null) {
			List<Game> allGames = gameService.getAllGamesByPlayer(player);
			if (!allGames.isEmpty()) {
				return new ResponseEntity<>(allGames.toString(), HttpStatus.OK);
			}else {
				return new ResponseEntity<>("El jugador no ha realitzat partides", HttpStatus.OK);
			}
			
		}else {
			return new ResponseEntity<>("No s'ha trobat el jugador", HttpStatus.NOT_FOUND);
		}
	}
	
	// GET /players/ranking: retorna el ranking mig de tots els jugadors/es del sistema. És a dir, el  percentatge mitjà d’èxits.
	@GetMapping("/ranking")
	public ResponseEntity<Object> getRanking() {
		List<PlayerDTO> allPlayersDTO = playerService.getRanking();
		List<String> playerWithNameAndWinPercentage = new ArrayList<>();
		
		if (!allPlayersDTO.isEmpty()) {
			allPlayersDTO.forEach(playerDTO ->{
				String playerName = playerDTO.getPlayerName();
				double winPercentage = playerDTO.getWinPercentage();
				String playerInfo = "Name: " + playerName + ", Win Percentage: " + df.format(winPercentage) + "%";
				playerWithNameAndWinPercentage.add(playerInfo);
			});
			return new ResponseEntity<>(playerWithNameAndWinPercentage, HttpStatus.OK);
		}else {
			return new ResponseEntity<>("No hi ha jugadors en la base de dades", HttpStatus.OK);
		}
	}
	
	// GET /players/ranking/loser: retorna el jugador/a  amb pitjor percentatge d’èxit.
	@GetMapping("/ranking/loser")
	public ResponseEntity<Object> getLoserRanking() {
		List<PlayerDTO> allPlayersDTO = playerService.getRanking();
		
		if (!allPlayersDTO.isEmpty()) {
			PlayerDTO loserPlayerDTO = allPlayersDTO.get(allPlayersDTO.size()-1);
			String playerName = loserPlayerDTO.getPlayerName();
			double winPercentage = loserPlayerDTO.getWinPercentage();
			String playerInfo = "Name: " + playerName + ", Win Percentage: " + df.format(winPercentage) + "%";
			
			return new ResponseEntity<>(playerInfo, HttpStatus.OK);
		}else {
			return new ResponseEntity<>("No hi ha jugadors en la base de dades", HttpStatus.OK);
		}
	}
	
	// GET /players/ranking/winner: retorna el  jugador amb millor percentatge d’èxit.
	@GetMapping("/ranking/winner")
	public ResponseEntity<Object> getWinnerRanking() {
		List<PlayerDTO> allPlayersDTO = playerService.getRanking();
		
		if (!allPlayersDTO.isEmpty()) {
			PlayerDTO loserPlayerDTO = allPlayersDTO.get(0);
			String playerName = loserPlayerDTO.getPlayerName();
			double winPercentage = loserPlayerDTO.getWinPercentage();
			String playerInfo = "Name: " + playerName + ", Win Percentage: " + df.format(winPercentage) + "%";
			
			return new ResponseEntity<>(playerInfo, HttpStatus.OK);
		}else {
			return new ResponseEntity<>("No hi ha jugadors en la base de dades", HttpStatus.OK);
		}
	}
	
	// Methods for thymeleaf
	
	@GetMapping("/player-login")
	public String viewPlayerLogin (Model model) {
		return "index";
	}
	
	@GetMapping("/newPlayer")
	public String viewNewPlayer (Model model) {
		return "new_player";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute Player existingPlayer, RedirectAttributes redirectAttributes) {
		currentPlayer = playerService.getPlayerByName(existingPlayer.getPlayerName());
		if (currentPlayer != null) {
			return "redirect:/players/player";			
		}else {
			redirectAttributes.addFlashAttribute("error", "El jugador no existeix");
			return "redirect:/players/player-login";
		}
	}
	
	@PostMapping("/create-player")
	public String createPlayer(@ModelAttribute Player newPlayer, RedirectAttributes redirectAttributes) {
		try {
			Player createdPlayer = playerService.addPlayer(newPlayer);
			currentPlayer = createdPlayer;
			return "redirect:/players/player";
		} catch(DuplicatePlayerNameException e) {
			redirectAttributes.addFlashAttribute("error", e.getMessage());
			return "redirect:/players/newPlayer";
		}
	}
	
	@GetMapping("/player")
	public String getPlayer(Model model) {
		List<PlayerDTO> ranking = playerService.getRanking();
		PlayerDTO winnerPlayer = ranking.get(0);
		PlayerDTO loserPlayer = ranking.get(ranking.size()-1);
		List<Game> allGames = gameService.getAllGamesByPlayer(currentPlayer);
		
		model.addAttribute("currentPlayer", currentPlayer);
		model.addAttribute("ranking", ranking);
		model.addAttribute("winnerPlayer", winnerPlayer);
		model.addAttribute("loserPlayer", loserPlayer);
		model.addAttribute("allGames", allGames);
		
		return "player";
	}
	
	@PostMapping("/createGame")
	public String createGameToPlayer(@ModelAttribute Game game) {
		gameService.addGameToPlayer(currentPlayer, game);
		
		return "redirect:/players/player";
	}
}