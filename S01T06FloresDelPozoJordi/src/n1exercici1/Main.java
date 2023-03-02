package n1exercici1;

public class Main {
	
	public static void main(String[] args) {
		NoGenericMethods obj1 = new NoGenericMethods("Objeto 1", "Objeto 2", "Objeto 3");
        NoGenericMethods obj2 = new NoGenericMethods("Objeto 3", "Objeto 1", "Objeto 2");
        NoGenericMethods obj3 = new NoGenericMethods("Objeto 2", "Objeto 3", "Objeto 1");
        
        System.out.println("Objeto 1: " + obj1.getObject1() + ", " + obj1.getObject2() + ", " + obj1.getObject3());
        System.out.println("Objeto 2: " + obj2.getObject1() + ", " + obj2.getObject2() + ", " + obj2.getObject3());
        System.out.println("Objeto 3: " + obj3.getObject1() + ", " + obj3.getObject2() + ", " + obj3.getObject3());
	}
}
