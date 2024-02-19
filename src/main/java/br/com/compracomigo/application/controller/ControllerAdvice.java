package br.com.compracomigo.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import com.google.gson.Gson;

import br.com.compracomigo.domain.model.ApiErrosModel;
import br.com.compracomigo.domain.model.ErrorsModel;

@RestControllerAdvice
public class ControllerAdvice {

	@ExceptionHandler(HttpClientErrorException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrosModel handleValidationErrors(HttpClientErrorException ex) {

	
		Gson g = new Gson();
		ApiErrosModel errors = g.fromJson(ex.getStatusText(), ApiErrosModel.class);
		
		System.out.println(ex.getStatusText());
		return errors;

	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorsModel handleResponse(Exception ex) {
		int code = HttpStatus.INTERNAL_SERVER_ERROR.value();
		String message = ex.getMessage();
		return new ErrorsModel(String.valueOf(code), message + "::" + ex.getCause().getCause().getCause());

	}
}
