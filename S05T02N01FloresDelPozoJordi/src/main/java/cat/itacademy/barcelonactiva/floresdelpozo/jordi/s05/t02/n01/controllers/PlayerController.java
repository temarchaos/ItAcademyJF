package cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain.Player;
import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.services.PlayerService;

@RestController
@RequestMapping("/players")
@CrossOrigin(origins = "http://localhost:8080")
public class PlayerController {

	private PlayerService playerService;
	
	@Autowired
	public PlayerController(PlayerService playerService) {
		this.playerService = playerService;
	}
	
	// POST: /players: crea un jugador/a. 
	@PostMapping("")
	public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
		Player createdPlayer = playerService.addPlayer(player);
		return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
	}
	
	// PUT /players: modifica el nom del jugador/a.
	@PutMapping("")
	public ResponseEntity<Player> updatePlayer(@RequestBody Player player) {
		Player updatedPlayer = playerService.updatePlayer(player);
		return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
	}
	
	// POST /players/{id}/games/ : un jugador/a específic realitza una tirada dels daus.
	
	// DELETE /players/{id}/games: elimina les tirades del jugador/a.
	
	// GET /players/: retorna el llistat de tots  els jugadors/es del sistema amb el seu  percentatge mitjà d’èxits.
	
	// GET /players/{id}/games: retorna el llistat de jugades per un jugador/a.
	
	// GET /players/ranking: retorna el ranking mig de tots els jugadors/es del sistema. És a dir, el  percentatge mitjà d’èxits.
	
	// GET /players/ranking/loser: retorna el jugador/a  amb pitjor percentatge d’èxit.
	
	// GET /players/ranking/winner: retorna el  jugador amb pitjor percentatge d’èxit.
}