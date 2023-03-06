package n1exercici8;

public class Main {

	public static void main(String[] args) {
		ReverseString rs = (str) -> {
			StringBuilder sb = new StringBuilder(str);
			return sb.reverse().toString();
		};
		String str = "Jordi";
		System.out.println("Param: " + str + ", resultat: " + rs.reverse(str));
	}

}
