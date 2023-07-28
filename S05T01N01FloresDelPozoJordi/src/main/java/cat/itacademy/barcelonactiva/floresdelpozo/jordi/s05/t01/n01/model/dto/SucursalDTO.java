package cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t01.n01.model.dto;

import java.util.Arrays;
import java.util.List;

import cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t01.n01.model.domain.Sucursal;

public class SucursalDTO {
	
	private int pk_SucursalID;
	private String nomSucursal;
	private String paisSucursal;
	private String tipusSucursal;
	
	private static final List<String> paisosUE = Arrays.asList(
			"Alemanya",
			"Àustria",
			"Bèlgica",
			"Bulgària",
			"Croàcia",
			"Dinamarca",
			"Eslovàquia",
			"Eslovènia",
			"Espanya",
			"Estònia",
			"Finlàndia",
			"França",
			"Grècia",
			"Hongria",
			"Irlanda",
			"Itàlia",
			"Letònia",
			"Lituània",
			"Luxemburg",
			"República de Malta",
			"Països Baixos",
			"Polònia",
			"Portugal",
			"República Txeca",
			"Romania",
			"Suècia",
			"Xipre");

	public SucursalDTO() {
		
	}
	
	public SucursalDTO(Sucursal sucursal) {
		this.pk_SucursalID = sucursal.getPk_SucursalID();
		this.nomSucursal = sucursal.getNomSucursal();
		this.paisSucursal = sucursal.getPaisSucursal();
		this.tipusSucursal = paisosUE.contains(paisSucursal) ? "UE" : "Fora UE";
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

	public String getTipusSucursal() {
		return tipusSucursal;
	}

	public void setTipusSucursal(String tipusSucursal) {
		this.tipusSucursal = tipusSucursal;
	}

	public static List<String> getPaisosue() {
		return paisosUE;
	}

	@Override
	public String toString() {
		return "SucursalDTO [pk_SucursalID=" + pk_SucursalID + ", nomSucursal=" + nomSucursal + ", paisSucursal="
				+ paisSucursal + ", tipusSucursal=" + tipusSucursal + "]";
	}
}