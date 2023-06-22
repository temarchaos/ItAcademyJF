package cat.itacademy.barcelonactiva.floresdelpozo.jordi.s04.t02.n03.model.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s04.t02.n03.model.domain.Fruita;
import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s04.t02.n03.model.repository.FruitaRepository;

@Service
public class FruitaService {

	private FruitaRepository fruitaRepository;
	
	@Autowired
	public FruitaService(FruitaRepository fruitaRepository) {
		this.fruitaRepository = fruitaRepository;
	}
	
	public Fruita addFruita(Fruita fruita) {
		return fruitaRepository.save(fruita);
	}
	
	public Fruita updateFruita(Fruita fruita) {
		return fruitaRepository.save(fruita);
	}
	
	public void deleteFruita(int id) {
		fruitaRepository.deleteById(id);
	}
	
	public Fruita getFruitaById(int id) {
        Optional<Fruita> optionalFruita = fruitaRepository.findById(id);
        return optionalFruita.orElse(null);
    }
	
	public List<Fruita> getAllFruites() {
        return fruitaRepository.findAll();
    }
}
