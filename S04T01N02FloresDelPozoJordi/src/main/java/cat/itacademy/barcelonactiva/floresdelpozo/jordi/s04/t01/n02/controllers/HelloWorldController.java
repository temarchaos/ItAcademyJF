package cat.itacademy.barcelonactiva.floresdelpozo.jordi.s04.t01.n02.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	// http://localhost:9001/HelloWorld
	// http://localhost:9001/HelloWorld?nom=Jordi
	
	@GetMapping("/HelloWorld")
	public String saluda(@RequestParam(value = "nom", defaultValue = "UNKNOWN") String nom) {
		return "Hola, " + nom + ". Estàs executant un projecte Gradle";
	}
	
	// http://localhost:9001/HelloWorld2
	// http://localhost:9001/HelloWorld2/Jordi
	
	@GetMapping({"/HelloWorld2","/HelloWorld2/{nom}"})
	public String saluda2(@PathVariable(required = false) String nom) {
		if (nom == null) {
            nom = "UNKNOWN";
        }
		
		return "Hola, " + nom + ". Estàs executant un projecte Gradle";
	}
}
