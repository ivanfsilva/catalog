package br.com.ivanfsilva.catalog.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.ivanfsilva.catalog.services.exceptions.EntityNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException e, HttpServletRequest request) {
		StandardError error = new StandardError();
		error.setTimeStamp(Instant.now());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setError("Recurso não encontrado");
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

}
