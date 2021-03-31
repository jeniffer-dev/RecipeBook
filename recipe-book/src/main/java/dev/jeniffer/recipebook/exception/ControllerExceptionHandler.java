package dev.jeniffer.recipebook.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {
  
  @ExceptionHandler(ResourceNotFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ResponseEntity<ApiError> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request){
	  ApiError message = new ApiError(
		        HttpStatus.NOT_FOUND,
		        new Date(),
		        ex.getMessage(),
		        request.getDescription(false));
	  
	  return new ResponseEntity<ApiError>(message, HttpStatus.NOT_FOUND);
	  
  }
}

