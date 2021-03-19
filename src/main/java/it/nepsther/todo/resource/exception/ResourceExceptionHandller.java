package it.nepsther.todo.resource.exception;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import it.nepsther.todo.service.exception.ObjectNotfoundException;

@ControllerAdvice
public class ResourceExceptionHandller {
	@ExceptionHandler(ObjectNotfoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotfoundException ex, ServletRequest request) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
