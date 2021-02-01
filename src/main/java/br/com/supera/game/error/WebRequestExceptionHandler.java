package br.com.supera.game.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.supera.game.exception.ProductNotExist;
import br.com.supera.game.exception.ProductUnavailable;

@RestControllerAdvice
public class WebRequestExceptionHandler {
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public RestResponseError productUnavailable(ProductUnavailable e) {
		return RestResponseError.fromMEssage(e.getMessage());
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public RestResponseError productNotExist(ProductNotExist e) {
		return RestResponseError.fromMEssage(e.getMessage());
	}
	
	
}
