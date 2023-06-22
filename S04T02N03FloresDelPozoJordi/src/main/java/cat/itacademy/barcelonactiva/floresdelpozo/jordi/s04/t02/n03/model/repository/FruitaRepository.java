package cat.itacademy.barcelonactiva.floresdelpozo.jordi.s04.t02.n03.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s04.t02.n03.model.domain.Fruita;

public interface FruitaRepository extends MongoRepository<Fruita, Integer>{

}