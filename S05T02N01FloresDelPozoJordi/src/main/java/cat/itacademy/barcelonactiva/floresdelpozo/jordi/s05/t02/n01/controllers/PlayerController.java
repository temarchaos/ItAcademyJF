package cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain.Game;
import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain.Player;
import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain.exception.DuplicatePlayerNameException;
import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.services.GameService;
import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.services.PlayerService;

@RestController
@RequestMapping("/players")
@CrossOrigin(origins = "http://localhost:8080")
public class PlayerController {

	@Autowired
	private PlayerService playerService;
	@Autowired
	private GameService gameService;
	
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
	
	// GET /players/ranking/loser: retorna el jugador/a  amb pitjor percentatge d’èxit.
	
	// GET /players/ranking/winner: retorna el  jugador amb millor percentatge d’èxit.
}