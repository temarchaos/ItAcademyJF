package cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain.Game;
import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain.Player;
import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain.exception.DuplicatePlayerNameException;
import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.services.GameService;
import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.services.PlayerService;

@Controller
@RequestMapping("/dicegame")
@CrossOrigin(origins = "http://localhost:8080")
public class PlayerWebController {
	
	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private GameService gameService;
	
	private Player currentPlayer;
	
	// GET http://localhost:8080/dicegame/playerLogin
	@GetMapping("/playerLogin")
	public String viewPlayerLogin (Model model) {
		return "index";
	}
	
	// GET http://localhost:8080/dicegame/newPlayer
	@GetMapping("/newPlayer")
	public String viewNewPlayer (Model model) {
		return "new_player";
	}
	
	// POST http://localhost:8080/dicegame/login
	@PostMapping("/login")
	public String login(@ModelAttribute Player existingPlayer, RedirectAttributes redirectAttributes) {
		currentPlayer = playerService.getPlayerByUsername(existingPlayer.getUsername());
		if (currentPlayer != null) {
			return "redirect:/dicegame/player";			
		}else {
			redirectAttributes.addFlashAttribute("error", "El jugador no existeix");
			return "redirect:/dicegame/playerLogin";
		}
	}
	
	// POST http://localhost:8080/dicegame/create-player
	@PostMapping("/create-player")
	public String createPlayer(@ModelAttribute Player newPlayer, RedirectAttributes redirectAttributes) {
		try {
			Player createdPlayer = playerService.addPlayer(newPlayer);
			currentPlayer = createdPlayer;
			return "redirect:/dicegame/player";
		} catch(DuplicatePlayerNameException e) {
			redirectAttributes.addFlashAttribute("error", e.getMessage());
			return "redirect:/dicegame/newPlayer";
		}
	}
	
	// GET http://localhost:8080/dicegame/player
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
	
	// POST http://localhost:8080/dicegame/createGame
	
	@PostMapping("/createGame")
	public String createGameToPlayer(@ModelAttribute Game game) {
		gameService.addGameToPlayer(currentPlayer, game);
		
		return "redirect:/dicegame/player";
	}
}