package lab1TDD;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NumeroPorExtenso {

	private NumeroPoExtenso numero;
	
	@Before
	
	public void Numero(){
		
	     numero = new NumeroPoExtenso();	
		
	}
	
	@Test
	public void NumerosPorExtenso() {
		
		assertEquals(numero.extenso(9), "nove");
		assertEquals(numero.extenso(7), "sete");
		assertEquals(numero.extenso(0), "zero");
		assertEquals(numero.extenso(5), "cinco");
		assertEquals(numero.extenso(11), "onze");
		assertEquals(numero.extenso(19), "dezenove");
		assertEquals(numero.extenso(15), "quinze");
		assertEquals(numero.extenso(10), "dez");
		
	}

}
