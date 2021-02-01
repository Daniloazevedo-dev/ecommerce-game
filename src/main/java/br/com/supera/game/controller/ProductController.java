package br.com.supera.game.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.supera.game.model.Product;
import br.com.supera.game.service.ProductService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna a lista de produtos em ordem alfábetica."),
		    @ApiResponse(code = 403, message = "Não Autorizado!"),
		    @ApiResponse(code = 401, message = "Não Autorizado!"),
		    @ApiResponse(code = 404, message = "Não encontrado!")
		})
	@GetMapping(value = "/order-alphabetic", produces = "application/json")
	public ResponseEntity<List<Product>> findByOrderAlphabetic() {
		return new ResponseEntity<>(productService.findByOrderAlphabetic(), HttpStatus.OK);
	}
	
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna a lista de produtos ordenado por Preço."),
		    @ApiResponse(code = 403, message = "Não Autorizado!"),
		    @ApiResponse(code = 401, message = "Não Autorizado!"),
		    @ApiResponse(code = 404, message = "Não encontrado!")
		})
	@GetMapping(value = "/order-price", produces = "application/json")
	public ResponseEntity<List<Product>> findByOrderPrice() {
		return new ResponseEntity<>(productService.findByOrderPrice(), HttpStatus.OK);
	}
	
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna a lista de produtos ordenado por Pontos."),
		    @ApiResponse(code = 403, message = "Não Autorizado!"),
		    @ApiResponse(code = 401, message = "Não Autorizado!"),
		    @ApiResponse(code = 404, message = "Não encontrado!")
		})
	@GetMapping(value = "/order-score", produces = "application/json")
	public ResponseEntity<List<Product>> findByOrderScore() {
		return new ResponseEntity<>(productService.findByOrderScore(), HttpStatus.OK);
	}

}
