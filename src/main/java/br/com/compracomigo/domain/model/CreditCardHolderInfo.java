package br.com.compracomigo.domain.model;

import lombok.Data;

@Data
public class CreditCardHolderInfo {

	private String name;
	private String email;
	private String cpfCnpj;
	private String postalCode;
	private String addressNumber;
	private String addressComplement;
	private String phone;
	private String mobilePhone;
}
