package n2exercici1;

public class InternationalContactFactory implements ContactFactory{

	@Override
	public Address createAddress() {
		return new InternationalAddress();
	}

	@Override
	public PhoneNumber createPhoneNumber() {
		return new InternationalPhoneNumber();
	}

}
