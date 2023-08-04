package cat.itacademy.barcelonactiva.floresdelpozo.jordi.s05.t02.n01.model.domain.exception;

@SuppressWarnings("serial")
public class DuplicatePlayerNameException extends RuntimeException{

	public DuplicatePlayerNameException(String message) {
		super(message);
	}
}