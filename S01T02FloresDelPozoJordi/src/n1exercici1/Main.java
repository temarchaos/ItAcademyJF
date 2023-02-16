package n1exercici1;

public class Main {
	
	public static void main(String[] args) {
		
		// Provocar l'expció si la col·lecció de productes està buida
		Venda newVenda1 = new Venda();
		newVenda1.calcularTotal();
		
		Producte newProducte = new Producte("Cocacola", 2);
		Producte newProducte2 = new Producte("Cafe amb llet", 1.50);
		Producte newProducte3 = new Producte("Vichy", 2.20);
		
		Venda newVenda2 = new Venda();
		newVenda2.producteList.add(newProducte);
		newVenda2.producteList.add(newProducte2);
		newVenda2.producteList.add(newProducte3);
		
		for	(Producte producte:newVenda2.producteList) {
			System.out.println(producte.nom + ", " + producte.preu);
		}
		
		newVenda2.calcularTotal();
		
		// Provocar lexcepció index fora de rang, he posat un +1 al size
		try {
			for (int i = 0; i < newVenda2.producteList.size()+ 1; i++) {
				System.out.println(i + ". " + newVenda2.producteList.get(i).nom);
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}
}
