package cat.itacademy.barcelonactiva.floresdelpozo.jordi.s04.t01.n01.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	// http://localhost:9000/HelloWorld
	// http://localhost:9000/HelloWorld?nom=Jordi
	
	@GetMapping("/HelloWorld")
	public String saluda(@RequestParam(value = "nom", defaultValue = "UNKNOWN") String nom) {
		return "Hola, " + nom + ". Estàs executant un projecte Maven";
	}
	
	// http://localhost:9000/HelloWorld2
	// http://localhost:9000/HelloWorld2/Jordi
	
	@GetMapping({"/HelloWorld2","/HelloWorld2/{nom}"})
	public String saluda2(@PathVariable(required = false) String nom) {
		if (nom == null) {
            nom = "UNKNOWN";
        }
		
		return "Hola, " + nom + ". Estàs executant un projecte Maven";
	}
}
