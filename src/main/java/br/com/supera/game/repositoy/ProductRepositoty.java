package br.com.supera.game.repositoy;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.supera.game.model.Product;

@Repository
public interface ProductRepositoty extends CrudRepository<Product, Long> {

	Product findByid(Long id);
	
	@Query("SELECT p FROM Product p ORDER BY p.name")
	List<Product> findByOrderAlphabetic();
	
	@Query("SELECT p FROM Product p ORDER BY p.price")
	List<Product> findByOrderPrice();
	
	@Query("SELECT p FROM Product p ORDER BY p.score")
	List<Product> findByOrderScore();
	
}
