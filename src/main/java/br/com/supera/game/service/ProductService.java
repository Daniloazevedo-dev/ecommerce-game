package br.com.supera.game.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.supera.game.model.Product;
import br.com.supera.game.repositoy.ProductRepositoty;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepositoty productRepositoty;
	
	public void save(Product product) {
		productRepositoty.save(product);
	}
	
	public Product findById(Long id) {
		return productRepositoty.findByid(id);
	}
	
	public List<Product> findByOrderAlphabetic() {
		return productRepositoty.findByOrderAlphabetic();
	}
	
	public List<Product> findByOrderPrice() {
		return productRepositoty.findByOrderPrice();
	}
	
	public List<Product> findByOrderScore() {
		return productRepositoty.findByOrderScore();
	}

}
