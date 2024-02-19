package br.com.compracomigo.domain.model;

import lombok.Data;

@Data
public class CallbackRed {

	private String successUrl;
	private boolean autoRedirect;
}
