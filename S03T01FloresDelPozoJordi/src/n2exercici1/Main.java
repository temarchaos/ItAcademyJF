package n2exercici1;

public class Main {

	public static void main(String[] args) {
		ContactFactory factory = new InternationalContactFactory();
		Address address = factory.createAddress();
		PhoneNumber phoneNumber = factory.createPhoneNumber();
		
		address.street = "Carrer Novetat, 100";
		address.city = "Barcelona";
		address.zipCode = "12345";
		address.country = "Spain";
		
		phoneNumber.code = "34";
		phoneNumber.number = "987654321";
		
		System.out.println(address.addressToString());
		System.out.println(phoneNumber.phoneNumberToString());
	}

}
