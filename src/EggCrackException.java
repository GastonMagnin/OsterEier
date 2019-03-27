
public class EggCrackException extends Exception {
	EggCrackException(){
		super();
	}
	public EggCrackException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EggCrackException(String message, Throwable cause) {
		super(message, cause);
	}

	public EggCrackException(String message) {
		super(message);
	}

	public EggCrackException(Throwable cause) {
		super(cause);
	}
}
