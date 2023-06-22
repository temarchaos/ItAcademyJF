package cat.itacademy.barcelonactiva.floresdelpozo.jordi.s04.t02.n02.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s04.t02.n02.model.domain.Fruita;
import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s04.t02.n02.model.services.FruitaService;

@RestController
@RequestMapping("/fruita")
@CrossOrigin(origins = "http://localhost:8080")
public class FruitaController {
	
	private final FruitaService fruitaService;
		
	@Autowired
	public FruitaController(FruitaService fruitaService) {
		this.fruitaService = fruitaService;
	}
	
	// http://localhost:8080/fruita/add
	
	@PostMapping("/add")
	public ResponseEntity<Fruita> addFruita(@RequestBody Fruita fruita){
		Fruita createdFruita = fruitaService.addFruita(fruita);
        return new ResponseEntity<>(createdFruita, HttpStatus.CREATED);
	}
	
	// http://localhost:8080/fruita/update
	
	@PutMapping("/update")
    public ResponseEntity<Fruita> updateFruita(@RequestBody Fruita fruita) {
        Fruita updatedFruita = fruitaService.updateFruita(fruita);
        return new ResponseEntity<>(updatedFruita, HttpStatus.OK);
    }
	
	// http://localhost:8080/fruita/delete/{id}
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFruita(@PathVariable int id) {
        fruitaService.deleteFruita(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	
	// http://localhost:8080/fruita/getOne/{id}
		
	@GetMapping("/getOne/{id}")
    public ResponseEntity<Fruita> getFruitaById(@PathVariable int id) {
        Fruita fruita = fruitaService.getFruitaById(id);
        if (fruita != null) {
            return new ResponseEntity<>(fruita, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	// http://localhost:8080/fruita/getAll
	
	@GetMapping("/getAll")
    public ResponseEntity<List<Fruita>> getAllFruites() {
        List<Fruita> fruites = fruitaService.getAllFruites();
        return new ResponseEntity<>(fruites, HttpStatus.OK);
    }
}