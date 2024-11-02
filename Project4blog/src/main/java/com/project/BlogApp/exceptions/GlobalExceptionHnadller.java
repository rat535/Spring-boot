package com.project.BlogApp.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.BlogApp.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHnadller {

	@ExceptionHandler(ResoueceNotFound.class)
	public ResponseEntity<ApiResponse> resourceNOtFoundException(ResoueceNotFound ex){
		 String message =ex.getMessage(); 
		 ApiResponse api = new ApiResponse(message,false);
		 return new ResponseEntity<ApiResponse>(api,HttpStatus.NOT_FOUND);
		 
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handelMethodArgumentNotValidException(MethodArgumentNotValidException ex)
	{
		Map<String, String> resp = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String Feildname= ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			resp.put(Feildname, message);
		});
		
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
	}
	
}
