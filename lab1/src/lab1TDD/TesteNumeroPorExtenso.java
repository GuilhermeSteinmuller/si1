package lab1TDD;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteNumeroPorExtenso {

	private NumeroPorExtenso numero;
	
	@Before
	
	public void Numero(){
		
	     numero = new NumeroPorExtenso();	
		
	}
	
	@Test
	public void NumerosPorExtenso() {
		
		assertEquals(numero.extenso("9"), "nove");
		assertEquals(numero.extenso("7"), "sete");
		assertEquals(numero.extenso("0"), "zero");
		assertEquals(numero.extenso("5"), "cinco");
		assertEquals(numero.extenso("11"), "onze");
		assertEquals(numero.extenso("19"), "dezenove");
		assertEquals(numero.extenso("15"), "quinze");
		assertEquals(numero.extenso("10"), "dez");
		assertEquals(numero.extenso("15"), "quinze");
		assertEquals(numero.extenso(""), "Por favor, digite um numero");
		assertEquals(numero.extenso("xpto"), "Por favor, digite um numero");
		assertEquals(numero.extenso("x1p0"), "Por favor, digite um numero");
		assertEquals(numero.extenso("21"), "vinte e um");
		assertEquals(numero.extenso("67"), "sessenta e sete");
		assertEquals(numero.extenso("99"), "noventa e nove");
		assertEquals(numero.extenso("154"), "cento e cinquenta e quatro");
		assertEquals(numero.extenso("999"), "novecentos e noventa e nove");
		
		
	}

}
