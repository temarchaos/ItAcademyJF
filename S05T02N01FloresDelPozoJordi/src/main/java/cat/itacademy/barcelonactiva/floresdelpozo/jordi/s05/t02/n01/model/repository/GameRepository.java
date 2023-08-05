package cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain.Game;
import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain.Player;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer>{
	void deleteAllByPlayer(Player player);
	List<Game> getAllByPlayer(Player player);
	@Query("SELECT COUNT(g) FROM Game g WHERE g.player = :player")
	int countGamesByPlayer(@Param("player") Player player);
	@Query("SELECT COUNT(g) FROM Game g WHERE g.player = :player AND g.won = true")
	int countWonGamesByPlayer(@Param("player") Player player);
}
