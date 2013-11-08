package lab1TDD;

public class NumeroPorExtenso {

	public String[] ZeroANove;
	public String[] DezADezenove;
	
	
	public NumeroPorExtenso() {
		
		ZeroANove = new String[] { "zero","um","dois","tres","quatro","cinco","seis","sete","oito","nove"};
		DezADezenove = new String[] {"dez", "onze", "doze", "treze", "catorze",
                "quinze", "dezesseis", "dezessete", "dezoito", "dezenove" };
	}
	
	public boolean entradaVazia(String entrada){
		
		if (entrada == "" )
		    return true;
		return false;
	}
	
	public boolean entradaPalavra(String entrada){
		
		try {
			Integer.parseInt(entrada);
			return false;
		} catch (NumberFormatException e) {
			return true;
		}
		
	}
	
	public String extenso(String n){
		
		if (entradaVazia(n) || entradaPalavra(n))
			return "Por favor, digite um numero";
		
		int numero = Integer.parseInt(n);
	
		if (numero < 10){
			return ZeroANove[numero];
		}else if(numero <= 19){
			return DezADezenove[numero - 10];
		}
		
		return ZeroANove[numero];
	}
	
}
