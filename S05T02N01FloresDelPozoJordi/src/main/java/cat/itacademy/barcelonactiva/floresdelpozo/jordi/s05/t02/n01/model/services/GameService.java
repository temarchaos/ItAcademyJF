package cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain.Game;
import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain.Player;
import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.repository.GameRepository;

@Service
public class GameService {
	
	private GameRepository gameRepository;
	
	@Autowired
	public GameService(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}
	
	public Game addGameToPlayer(Player player, Game game) {
		if (player != null) {
			List<Integer> diceValues = game.getDicesValues();
			if (diceValues.size() != Game.NUM_DICES) {
				throw new IllegalArgumentException("El nombre de valors de daus ha de ser igual a " + Game.NUM_DICES);
			}
			game.setPlayer(player);
			
			int res = diceValues.stream().mapToInt(Integer::intValue).sum();
			game.setWon(res == 7);
			
			return gameRepository.save(game);
		}
		
		return null;
	}
	
	@Transactional
	public void deleteAllGamesByPlayer(Player player) {
        gameRepository.deleteAllByPlayer(player);
    }
}