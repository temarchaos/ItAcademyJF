package n2exercici1;

public class InternationalPhoneNumber extends PhoneNumber{

	@Override
	public String phoneNumberToString() {
		return "Phone Number: [+" + code + " " + number + "]";
	}

}
