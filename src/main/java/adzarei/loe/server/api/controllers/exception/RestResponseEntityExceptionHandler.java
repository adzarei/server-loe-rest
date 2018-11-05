package adzarei.loe.server.api.controllers.exception;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(Exception exception, WebRequest request){

        return new ResponseEntity<>("Resource Not Found", new HttpHeaders(), HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler({NotImplementedException.class})
    public ResponseEntity<Object> handleNotImplementedException(Exception exception, WebRequest request){

        return new ResponseEntity<>("Method Not Implemented", new HttpHeaders(), HttpStatus.NOT_IMPLEMENTED);

    }
}
