package br.com.supera.game.test;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.com.supera.game.model.Product;
import br.com.supera.game.service.ProductService;

@Component
public class InsertProductTest {

	@Autowired
	private ProductService productService;
	
	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		saveProduct(new Product("Super Mario Odyssey", new BigDecimal(197.88), (short) 100, "super-mario-odyssey.png"));
		saveProduct(new Product("Call Of Duty Infinite Warfare", new BigDecimal(49.99), (short) 80, "call-of-duty-infinite-warfare.png"));		
		saveProduct(new Product("The Witcher III Wild Hunt", new BigDecimal(119.5), (short) 250, "the-witcher-iii-wild-hunt.png"));		
		saveProduct(new Product("Call Of Duty WWII", new BigDecimal(249.99), (short) 205, "call-of-duty-wwii.png"));		
		saveProduct(new Product("Mortal Kombat XL", new BigDecimal(69.99), (short) 150, "mortal-kombat-xl.png"));		
		saveProduct(new Product("Shards of Darkness", new BigDecimal(71.94), (short) 400, "shards-of-darkness.png"));
		saveProduct(new Product("Terra Média: Sombras de Mordor", new BigDecimal(79.99), (short) 50, "terra-media-sombras-de-mordor.png"));
		saveProduct(new Product("FIFA 18", new BigDecimal(195.39), (short) 325, "fifa-18.png"));
		saveProduct(new Product("Horizon Zero Dawn", new BigDecimal(115.8), (short) 290, "horizon-zero-dawn.png"));
	}
	
	private void saveProduct(Product product) {
		productService.save(product);
	}
	
}
