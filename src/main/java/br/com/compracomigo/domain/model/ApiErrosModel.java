package br.com.compracomigo.domain.model;

import java.util.List;

import lombok.Data;

@Data
public class ApiErrosModel {

	private List<ErrorsModel> errors;
}
