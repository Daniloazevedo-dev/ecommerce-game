package br.com.supera.game.util;

import java.math.BigDecimal;

public class Calculate {

	public static BigDecimal total(BigDecimal total, BigDecimal subtotal, BigDecimal freight) {
		
		return subtotal.add(freight);
		
	}
	
	public static BigDecimal subtotal(BigDecimal price, BigDecimal subtotal, boolean remove) {
		
		if(remove == true) {
			return subtotal.subtract(price);
		}
		
		return subtotal.add(price);
	}
	
	public static BigDecimal calculateFreight(BigDecimal freight, BigDecimal totalItems) {
		
		return Constants.FREIGHT.multiply(totalItems);
	}

	
}
