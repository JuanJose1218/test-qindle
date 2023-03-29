package com.qindel.test.config;

import com.qindel.test.dto.ErrorDto;
import com.qindel.test.exception.PricesException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionConfig {
  @ExceptionHandler(HttpMessageNotReadableException.class)
  public final ResponseEntity<Object> handleMethodArgumentNotValid(HttpMessageNotReadableException ex) {
    ErrorDto response = new ErrorDto();
    response.setMessage(ex.getLocalizedMessage());
    response.setCode(HttpStatus.BAD_REQUEST.value());
    response.setTimestamp(LocalDateTime.now().toString());
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  final ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
    ErrorDto response = new ErrorDto();
    List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
      .collect(Collectors.toList());
    response.setCode(HttpStatus.BAD_REQUEST.value());
    response.setTimestamp(LocalDateTime.now().toString());
    response.setMessage("some validations are invalids, please check your request");
    response.setErrors(errors);
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(PricesException.class)
  final ResponseEntity<Object> handleMethodArgumentNotValid(PricesException ex) {
    ErrorDto response = new ErrorDto();
    response.setMessage(ex.getLocalizedMessage());
    response.setCode(HttpStatus.BAD_REQUEST.value());
    response.setTimestamp(LocalDateTime.now().toString());
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
  }


}
