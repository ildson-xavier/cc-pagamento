package br.com.compracomigo.domain.model;

import br.com.compracomigo.domain.enums.PercentageType;
import lombok.Data;

@Data
public class Discount {

	private int value;
	private int dueDateLimitDays;
	private PercentageType type;
}
