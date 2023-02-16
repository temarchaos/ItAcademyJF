package n1exercici1;

import java.util.ArrayList;
import java.util.List;

public class Venda {
	
	List<Producte> producteList;
	double preuTotal;
	
	public Venda () {
		super();
		this.producteList = new ArrayList<Producte>();
		this.preuTotal = 0;
	}

	public void calcularTotal() {

		if (producteList.isEmpty()) {
			try {
				throw new VendaBuidaException("Per fer una venda primer has d’afegir productes");
			} catch (VendaBuidaException e) {
				System.out.println(e.getMessage());
			}
		}else {
			for (Producte producte:producteList) {
				preuTotal += producte.preu;
			}
			
			System.out.println("Preu total: " + preuTotal);
		}
	}
}
