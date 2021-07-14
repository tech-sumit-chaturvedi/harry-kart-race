package se.atg.service.harrykart.exception;

/**
* This is a customised exception class, used when validation throws exception
* @author Sumit.Chaturvedi
* @since 2021-14-07 03:48
*/
@SuppressWarnings("serial")
public class ValidationException  extends Exception {
	
	public ValidationException(String message) {
		super(message);
	}
}
