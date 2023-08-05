package cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain.Game;
import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain.Player;
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
	public ResponseEntity<Player> updatePlayer(@RequestBody Player player) {
		Player updatedPlayer = playerService.getPlayerById(player.getPk_PlayerID());
		if (updatedPlayer != null) {
			updatedPlayer = playerService.updatePlayer(player);
			return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);			
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	// POST /players/{id}/games/ : un jugador/a específic realitza una tirada dels daus.
	@PostMapping("/{id}/games/")
	public ResponseEntity<Game> addGameToPlayer(@PathVariable("id") int playerId, @RequestBody Game game) {
		Player player = playerService.getPlayerById(playerId);
        if (player != null) {
            Game newGame = gameService.addGameToPlayer(player, game);
            return new ResponseEntity<>(newGame, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}
	
	// DELETE /players/{id}/games: elimina les tirades del jugador/a.
	
	// GET /players/: retorna el llistat de tots  els jugadors/es del sistema amb el seu  percentatge mitjà d’èxits.
	
	// GET /players/{id}/games: retorna el llistat de jugades per un jugador/a.
	
	// GET /players/ranking: retorna el ranking mig de tots els jugadors/es del sistema. És a dir, el  percentatge mitjà d’èxits.
	
	// GET /players/ranking/loser: retorna el jugador/a  amb pitjor percentatge d’èxit.
	
	// GET /players/ranking/winner: retorna el  jugador amb pitjor percentatge d’èxit.
}