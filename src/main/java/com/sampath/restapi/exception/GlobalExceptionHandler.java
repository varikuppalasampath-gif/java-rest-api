package com.sampath.restapi.exception;
import org.springframework.http.*; import org.springframework.web.bind.MethodArgumentNotValidException; import org.springframework.web.bind.annotation.*; import java.time.LocalDateTime; import java.util.*;
@RestControllerAdvice public class GlobalExceptionHandler {
 @ExceptionHandler(ResourceNotFoundException.class) public ResponseEntity<Map<String,Object>> notFound(ResourceNotFoundException e){return build(HttpStatus.NOT_FOUND,e.getMessage());}
 @ExceptionHandler(IllegalArgumentException.class) public ResponseEntity<Map<String,Object>> badRequest(IllegalArgumentException e){return build(HttpStatus.BAD_REQUEST,e.getMessage());}
 @ExceptionHandler(MethodArgumentNotValidException.class) public ResponseEntity<Map<String,Object>> validation(MethodArgumentNotValidException e){Map<String,Object>b=new LinkedHashMap<>();b.put("timestamp",LocalDateTime.now());b.put("status",400);b.put("error","Validation failed");Map<String,String>f=new LinkedHashMap<>();e.getBindingResult().getFieldErrors().forEach(x->f.put(x.getField(),x.getDefaultMessage()));b.put("fields",f);return ResponseEntity.badRequest().body(b);}
 private ResponseEntity<Map<String,Object>> build(HttpStatus s,String m){Map<String,Object>b=new LinkedHashMap<>();b.put("timestamp",LocalDateTime.now());b.put("status",s.value());b.put("error",s.getReasonPhrase());b.put("message",m);return ResponseEntity.status(s).body(b);}
}
