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
		
		assertEquals(numero.extenso(10), "dez");
		assertEquals(numero.extenso(7), "sete");
		assertEquals(numero.extenso(0), "zero");
		assertEquals(numero.extenso(5), "cinco");
		
		
		
	}

}
