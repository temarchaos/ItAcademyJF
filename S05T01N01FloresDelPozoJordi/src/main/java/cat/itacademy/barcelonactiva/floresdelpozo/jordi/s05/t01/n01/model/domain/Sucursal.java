package cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t01.n01.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "sucursals")
public class Sucursal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pk_SucursalID;
	
	@Column(name = "nom_sucursal")
	private String nomSucursal;
	
	@Column(name = "pais_sucursal")
	private String paisSucursal;

	public Sucursal() {
	}

	public Sucursal(int pk_SucursalID, String nomSucursal, String paisSucursal) {
		this.pk_SucursalID = pk_SucursalID;
		this.nomSucursal = nomSucursal;
		this.paisSucursal = paisSucursal;
	}

	public int getPk_SucursalID() {
		return pk_SucursalID;
	}

	public void setPk_SucursalID(int pk_SucursalID) {
		this.pk_SucursalID = pk_SucursalID;
	}

	public String getNomSucursal() {
		return nomSucursal;
	}

	public void setNomSucursal(String nomSucursal) {
		this.nomSucursal = nomSucursal;
	}

	public String getPaisSucursal() {
		return paisSucursal;
	}

	public void setPaisSucursal(String paisSucursal) {
		this.paisSucursal = paisSucursal;
	}

	@Override
	public String toString() {
		return "Sucursal [pk_SucursalID=" + pk_SucursalID + ", nomSucursal=" + nomSucursal + ", paisSucursal="
				+ paisSucursal + "]";
	}
}