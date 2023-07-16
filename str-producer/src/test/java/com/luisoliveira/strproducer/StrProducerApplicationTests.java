package com.luisoliveira.strproducer;

import com.luisoliveira.strproducer.controllers.StringProducerController;
import com.luisoliveira.strproducer.services.StringProducerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
class StringProducerControllerTest {
	@Mock
	private StringProducerService producerService;
	@InjectMocks
	private StringProducerController controller;
	public StringProducerControllerTest() {
		MockitoAnnotations.openMocks(this);
	}
	@Test
	void sendMessage_PositiveCase_ReturnsCreatedStatus() {
		String message = "Test message";
		ResponseEntity<?> response = controller.sendMessage(message);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		verify(producerService).sendMessage(message);
	}
	@Test
	void sendMessage_NegativeCase_ReturnsCreatedStatus() {
		String message = null;
		ResponseEntity<?> response = controller.sendMessage(message);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		verify(producerService).sendMessage(message);
	}
}