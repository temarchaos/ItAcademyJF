package cat.itacademy.barcelonactiva.floresdelpozo.jordi.s04.t02.n03.model.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.annotation.Id;

@Document(collection = "Fruita")
public class Fruita {
	
	@Id
	private int id;
	
	@Field(name = "nom")
	private String nom;
	
	@Field(name = "quantitatQuilos")
	private int quantitatQuilos;

	public Fruita() {
		
	}
	
	public Fruita(int id, String nom, int quantitatQuilos) {
		this.id = id;
		this.nom = nom;
		this.quantitatQuilos = quantitatQuilos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getQuantitatQuilos() {
		return quantitatQuilos;
	}

	public void setQuantitatQuilos(int quantitatQuilos) {
		this.quantitatQuilos = quantitatQuilos;
	}

	@Override
	public String toString() {
		return "Fruita [id=" + id + ", nom=" + nom + ", quantitatQuilos=" + quantitatQuilos + "]";
	}
}
