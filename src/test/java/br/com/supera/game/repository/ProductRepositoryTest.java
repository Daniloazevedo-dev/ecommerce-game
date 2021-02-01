package br.com.supera.game.repository;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.supera.game.model.Product;
import br.com.supera.game.repositoy.ProductRepositoty;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {

	@Autowired
	private ProductRepositoty productRepositoty;
	
	public ExpectedException Throw = ExpectedException.none();
	
	@Test
	public void testInsertAndFindById() {
		
		Product product = new Product("PES 2020", new BigDecimal(120), (short) 200, "Pes2020.png");
		this.productRepositoty.save(product);
		
		Assertions.assertThat(product.getId()).isNotNull();
		Assertions.assertThat(product.getName()).isEqualTo("PES 2020");
		Assertions.assertThat(product.getPrice()).isEqualTo(new BigDecimal(120));
		Assertions.assertThat(product.getScore()).isEqualTo((short) 200);
		Assertions.assertThat(product.getImage()).isEqualTo("Pes2020.png");
		
		Assertions.assertThat(productRepositoty.findByid(product.getId()));
	}
	
	@Test
	public void testFindByOrder() {
		Product product = new Product("PES 2020", new BigDecimal(120), (short) 200, "Pes2020.png");
		this.productRepositoty.save(product);
		
		Assertions.assertThat(product.getId()).isNotNull();
		Assertions.assertThat(product.getName()).isEqualTo("PES 2020");
		Assertions.assertThat(product.getPrice()).isEqualTo(new BigDecimal(120));
		Assertions.assertThat(product.getScore()).isEqualTo((short) 200);
		Assertions.assertThat(product.getImage()).isEqualTo("Pes2020.png");
		
		Assertions.assertThat(productRepositoty.findByOrderAlphabetic());
		Assertions.assertThat(productRepositoty.findByOrderPrice());
		Assertions.assertThat(productRepositoty.findByOrderScore());
	}
	
}
