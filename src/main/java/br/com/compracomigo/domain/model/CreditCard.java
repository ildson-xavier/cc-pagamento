package br.com.compracomigo.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreditCard {

	private String holderName;
	private String number;
	private String expiryMonth;
	private String expiryYear;
	private String cvv;
	
	private String creditCardNumber;
	private String creditCardBrand;
	private String creditCardToken;
}
