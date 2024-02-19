package br.com.compracomigo.domain.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientePesquisaModel {

	private String object;
	private boolean hasMore;
	private int totalCount;
	private int limit;
	private int offset;
	private List<Cliente> data;
}
