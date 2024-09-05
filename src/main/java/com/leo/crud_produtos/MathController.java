package com.leo.crud_produtos;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
	
	//Para operações que é um requisito passarmos valores por variaveis usamos o PathVariable
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	//metodo de soma entre dois valores
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception{
		
		//se nao for numerico vai lançar um excecao
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new Exception();
		}
		//retornando soma após verificações nas funcoes abaixo
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
		
		}

	private Double convertToDouble(String strNumber) {
		if(strNumber == null) {
			return 0D;
		}
		//se usuario inserir virgula vai mudar para ponto com essa função
		String number = strNumber.replaceAll(",", ".");
		if(isNumeric(strNumber)) {
			return Double.parseDouble(number);
		}
		return null;
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null) {
			return false;
		}
		String number = strNumber.replaceAll(",", ".");
		//usando uma regex para verificar se é numero
		return number.matches("^(-?)(0|([1-9][0-9]*))(\\.[0-9]+)?$");

	}
	
}
