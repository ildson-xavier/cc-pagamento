package br.com.compracomigo.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Cliente {

	private String id;
	private String object;
	private String dateCreated;
	
	private String name;
	private String cpfCnpj;
	private String email;
	private String phone;
	private String mobilePhone;
	private String address;
	private String addressNumber;
	private String complement;
	private String province;
	private String postalCode;
	private String externalReference;
	private boolean notificationDisabled;
	private String additionalEmails;
	private String municipalInscription;
	private String stateInscription;
	private String observations;
	private String groupName;
	private String company;
}
