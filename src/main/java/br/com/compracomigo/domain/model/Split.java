package br.com.compracomigo.domain.model;

import lombok.Data;

@Data
public class Split {

	private String walletId;
	private float fixedValue;
	private float percentualValue;
	private float totalFixedValue;
}
