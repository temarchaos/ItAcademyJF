package n1exercici4;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<String> mesos = new ArrayList<String>();
		
		mesos.add("Gener");
		mesos.add("Febrer");
		mesos.add("Març");
		mesos.add("Abril");
		mesos.add("Maig");
		mesos.add("Juny");
		mesos.add("Juliol");
		mesos.add("Agost");
		mesos.add("Setembre");
		mesos.add("Octubre");
		mesos.add("Novembre");
		mesos.add("Desembre");
		
		mesos.forEach(System.out::println);
	}

}
