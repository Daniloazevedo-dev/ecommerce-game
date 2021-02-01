package br.com.supera.game.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	private List<Product> listItems = new ArrayList<>();
	
	private BigDecimal freight;
	
	private BigDecimal subtotal;
	
	private BigDecimal total;
	
	private BigDecimal totalItem;

	public Cart() {
		this.listItems = new ArrayList<Product>();
		this.freight = new BigDecimal(0);
		this.subtotal = new BigDecimal(0);
		this.total = new BigDecimal(0);
		this.totalItem = new BigDecimal(0);;
		
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<Product> getListItems() {
		return listItems;
	}

	public void setListItems(List<Product> listItems) {
		this.listItems = listItems;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public BigDecimal getFreight() {
		return freight;
	}

	public void setFreight(BigDecimal freight) {
		this.freight = freight;
	}

	public BigDecimal getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(BigDecimal totalItem) {
		this.totalItem = totalItem;
	}
	
}
