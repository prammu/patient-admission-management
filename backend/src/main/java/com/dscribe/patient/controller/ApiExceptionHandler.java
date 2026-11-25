package com.dscribe.patient.controller;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
@RestControllerAdvice
public class ApiExceptionHandler {
 @ExceptionHandler(MethodArgumentNotValidException.class)
 public ResponseEntity<Map<String,Object>> validation(MethodArgumentNotValidException ex){
   List<String> errors=ex.getBindingResult().getFieldErrors().stream().map(e->e.getDefaultMessage()).distinct().toList();
   return ResponseEntity.badRequest().body(Map.of("message",errors.isEmpty()?"Invalid patient data":errors.get(0),"errors",errors));
 }
 @ExceptionHandler(ResponseStatusException.class)
 public ResponseEntity<Map<String,String>> status(ResponseStatusException ex){return ResponseEntity.status(ex.getStatusCode()).body(Map.of("message",ex.getReason()==null?"Request failed":ex.getReason()));}
 @ExceptionHandler(Exception.class)
 public ResponseEntity<Map<String,String>> general(Exception ex){return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("message","Something went wrong. Please try again."));}
}
