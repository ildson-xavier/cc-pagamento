package br.com.compracomigo.domain.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CobrancaCartaoCreditoRequest {

	private String customer;
	private String billingType;
	private float value;
	private String dueDate;
	private String description;
	private String externalReference;
	private int installmentCount;
	private float installmentValue;
	private Discount discount;
	private Interest interest;
	private Fine fine;
	private boolean postalService;
	private List<Split> split;
	private CallbackRed callback;
	private CreditCard creditCard;
	private CreditCardHolderInfo creditCardHolderInfo;
	private String creditCardToken;
	private String authorizeOnly;
	private String remoteIp;
	
}
