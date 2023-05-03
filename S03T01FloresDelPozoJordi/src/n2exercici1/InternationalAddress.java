package n2exercici1;

public class InternationalAddress extends Address{

	@Override
	public String addressToString() {
		return "Address: [" + street + ", " + city + ", " + zipCode + ", " + country + "]";
	}

}
