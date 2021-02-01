package br.com.supera.game.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.supera.game.exception.ProductNotExist;
import br.com.supera.game.exception.ProductUnavailable;
import br.com.supera.game.model.Cart;
import br.com.supera.game.model.Product;
import br.com.supera.game.service.ProductService;
import br.com.supera.game.util.Calculate;
import br.com.supera.game.util.Constants;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private ProductService productService;

	private Cart cart = new Cart();

	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Adiciona um produto no carrinho de compras e retorna a lista de produtos adiconados."),
		    @ApiResponse(code = 403, message = "Não Autorizado!"),
		    @ApiResponse(code = 401, message = "Não Autorizado!"),
		    @ApiResponse(code = 404, message = "Não encontrado!")
		})
	@PostMapping(value = "/add/{id}", produces = "application/json")
	public ResponseEntity<List<Product>> add(@PathVariable Long id) throws ProductUnavailable, ProductNotExist {

		Product productBD = productService.findById(id);

		if (productBD == null) {
			throw new ProductUnavailable("Produto não existe!");
		}

		cart.getListItems().add(productBD);
		cart.setTotalItem(new BigDecimal(cart.getListItems().size()));

		BigDecimal freight;
		BigDecimal subtotal = Calculate.subtotal(productBD.getPrice(), cart.getSubtotal(), false);

		if (subtotal.compareTo(Constants.LIMIT_FREIGHT_FREE) == 1) {
			freight = new BigDecimal(0);
		} else {
			freight = Calculate.calculateFreight(cart.getFreight(), cart.getTotalItem());
		}

		BigDecimal total = Calculate.total(cart.getTotal(), subtotal, freight);

		cart.setSubtotal(subtotal);
		cart.setFreight(freight);
		cart.setTotal(total);

		return new ResponseEntity<>(cart.getListItems(), HttpStatus.OK);

	}

	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Remove um produto do carrinho de compras e retorna a lista de produtos adiconados."),
		    @ApiResponse(code = 403, message = "Não Autorizado!"),
		    @ApiResponse(code = 401, message = "Não Autorizado!"),
		    @ApiResponse(code = 404, message = "Não encontrado!")
		})
	@DeleteMapping(value = "/remove/{id}", produces = "application/json")
	public ResponseEntity<List<Product>> remove(@PathVariable Long id) throws ProductUnavailable, ProductNotExist {

		Product productBD = productService.findById(id);

		if (productBD == null) {
			throw new ProductUnavailable("Produto não existe!");
		}

		if (cart.getListItems().contains(productBD)) {
			cart.getListItems().remove(productBD);
		} else {
			throw new ProductNotExist("Produto não existe no carrinho!");
		}

		cart.setTotalItem(new BigDecimal(cart.getListItems().size()));

		BigDecimal freight;
		BigDecimal subtotal = Calculate.subtotal(productBD.getPrice(), cart.getSubtotal(), true);

		if (subtotal.compareTo(Constants.LIMIT_FREIGHT_FREE) == 1) {
			freight = new BigDecimal(0);
		} else {
			freight = Calculate.calculateFreight(cart.getFreight(), cart.getTotalItem());
		}

		BigDecimal total = Calculate.total(cart.getTotal(), subtotal, freight);

		cart.setSubtotal(subtotal);
		cart.setFreight(freight);
		cart.setTotal(total);

		return new ResponseEntity<>(cart.getListItems(), HttpStatus.OK);
	}

	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna o carrino de compras."),
		    @ApiResponse(code = 403, message = "Não Autorizado!"),
		    @ApiResponse(code = 401, message = "Não Autorizado!"),
		    @ApiResponse(code = 404, message = "Não encontrado!")
		})
	@GetMapping(produces = "application/json")
	public ResponseEntity<Cart> listProducts() {
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

}
