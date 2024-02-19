package br.com.compracomigo.domain.model;

import lombok.Data;

@Data
public class CobrancaCartaoCreditoResponse {

	private String object;
	private String id;
	private String dateCreated;
	private String customer;
	private String paymentLink;
	private String dueDate;
	private String value;
	private String netValue;
	private String billingType;
	private String pixTransaction;
	private String status;
	private String description;
	private String externalReference;
	private String confirmedDate;
	private String originalValue;
	private String interestValue;
	
	private String originalDueDate;
	private String paymentDate;
	private String clientPaymentDate;
	private String installmentNumber;
	private String transactionReceiptUrl;
	private String nossoNumero;
	
	private String invoiceUrl;
	private String bankSlipUrl;
	private String invoiceNumber;
	private boolean deleted;
	private boolean postalService;
	private boolean anticipated;
	private boolean anticipable;
	private CreditCard creditCard;
	
}
