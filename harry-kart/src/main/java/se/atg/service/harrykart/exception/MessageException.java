package se.atg.service.harrykart.exception;


/**
* This is a customised exception class, used when validation throws exception
* @author Sumit.Chaturvedi
* @since 2021-14-07 05:48
*/
@SuppressWarnings("serial")
public class MessageException  extends Exception {
	public MessageException(String message) {
		super(message);
	}
	public MessageException(String message,Throwable throwable) {
		super(message,throwable);
	}
}

