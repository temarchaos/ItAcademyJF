package cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer>{

}
