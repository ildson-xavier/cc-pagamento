package br.com.compracomigo.domain.model;

import br.com.compracomigo.domain.enums.PercentageType;
import lombok.Data;

@Data
public class Fine {

	private float value;
	private PercentageType type;
}
