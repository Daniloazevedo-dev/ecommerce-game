package br.com.supera.game.error;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class RestResponseError {

		private String error;
		
		private RestResponseError () {
			
		}
		
		public String getError() {
			return error;
		}
		
		public static RestResponseError fromValidaError(Errors errors) {
			RestResponseError resp = new RestResponseError();
			StringBuilder sb = new StringBuilder();
			
			for(ObjectError error : errors.getAllErrors()) {
				sb.append(error.getDefaultMessage()).append(". ");
			}
			
			resp.error = sb.toString();
			
			return resp;
			
		}
		
		public static RestResponseError fromMEssage(String message) {
			RestResponseError resp = new RestResponseError();
			resp.error = message;
			
			return resp;
		}
}
