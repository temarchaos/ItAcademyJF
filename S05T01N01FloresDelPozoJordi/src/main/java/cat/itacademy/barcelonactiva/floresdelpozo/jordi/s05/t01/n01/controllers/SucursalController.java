package cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t01.n01.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t01.n01.model.services.SucursalService;

@Controller
@RequestMapping("/sucursal")
@CrossOrigin(origins = "http://localhost:9000")
public class SucursalController {

	private final SucursalService sucursalService;
	
	@Autowired
	public SucursalController (SucursalService sucursalService) {
		this.sucursalService = sucursalService;
	}
	// http://localhost:9000/sucursal/add
	
	@PostMapping("/add")
    public String saveSucursal(@ModelAttribute("sucursal") Sucursal sucursal) {
        sucursalService.addSucursal(sucursal);
        return "redirect:/sucursal/getAll";
    }
	
	@GetMapping("/newSucursal")
    public String showNewSucursalForm(Model model) {
        Sucursal sucursal = new Sucursal();
        model.addAttribute("sucursal", sucursal);
        return "new_sucursal";
    }
	
	// http://localhost:9000/sucursal/update
	
	@GetMapping("/update/{id}")
    public String viewSucursalUpdatePage(@PathVariable(value = "id") int id, Model model) {
        SucursalDTO sucursal = sucursalService.getSucursalById(id);
        if (sucursal != null) {
        	model.addAttribute("sucursal", sucursal);
        	return "update_sucursal";        	
        }else {
        	return "redirect:/sucursal/getAll";
        }
    }
	
	// http://localhost:9000/sucursal/delete/{id}
	
	@GetMapping("/delete/{id}")
    public String deleteSucursal(@PathVariable(value = "id") int id) {
		SucursalDTO sucursal = sucursalService.getSucursalById(id);
		if (sucursal != null) {
			sucursalService.deleteSucursal(id);			
		}
        return "redirect:/sucursal/getAll";
    }
	
	// http://localhost:9000/sucursal/getOne/{id}
	
	@GetMapping("/getOne/{id}")
	public String viewSucursalPage(@PathVariable(value = "id") int id, Model model) {
		SucursalDTO sucursal = sucursalService.getSucursalById(id);
		if (sucursal != null) {
			model.addAttribute("sucursal", sucursal);
			return "sucursal";			
		}else {
			return "redirect:/sucursal/getAll";
		}
	}
	
	// http://localhost:9000/sucursal/getAll
	
	@GetMapping("/getAll")
	public String getAllSucursals(Model model) {
        List<SucursalDTO> sucursals = sucursalService.getAllSucursals();
        model.addAttribute("sucursals", sucursals);
        return "index";
    }
}