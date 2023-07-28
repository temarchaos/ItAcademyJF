package cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t01.n01.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t01.n01.model.repository.SucursalRepository;

@Service
public class SucursalService {
	
	private SucursalRepository sucursalRepository;
	
	@Autowired
	public SucursalService(SucursalRepository sucursalRepository) {
		this.sucursalRepository = sucursalRepository;
	}
	
	private SucursalDTO convertToDto(Sucursal sucursal) {
		SucursalDTO sucursalDto = new SucursalDTO(sucursal);
		return sucursalDto;
	}
	
	public SucursalDTO addSucursal(Sucursal sucursal) {
		Sucursal savedSucursal = sucursalRepository.save(sucursal);
		return convertToDto(savedSucursal);
	}
	
	public SucursalDTO updateSucursal(Sucursal sucursal) {
		Sucursal updatedSucursal = sucursalRepository.save(sucursal);
		return convertToDto(updatedSucursal);
	}
	
	public void deleteSucursal(int id) {
		sucursalRepository.deleteById(id);
	}
	
	public SucursalDTO getSucursalById(int id) {
        Optional<Sucursal> optionalSucursal = sucursalRepository.findById(id);
        return optionalSucursal.map(this::convertToDto).orElse(null);
    }
	
	public List<SucursalDTO> getAllSucursals() {
		List<Sucursal> sucursals = sucursalRepository.findAll();
		List<SucursalDTO> sucursalsDtos = new ArrayList<>();
		
		for (Sucursal sucursal : sucursals) {
			sucursalsDtos.add(convertToDto(sucursal));
		}
        return sucursalsDtos;
    }
}