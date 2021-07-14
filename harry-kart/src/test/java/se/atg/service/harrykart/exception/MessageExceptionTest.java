package se.atg.service.harrykart.exception;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MessageExceptionTest {
	@Test
	public void MessageException() {
		new MessageException("message");
		new MessageException("message", new Throwable());
	}
}
