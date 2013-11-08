package lab1TDD;

public class NumeroPorExtenso {

	public String[] ZeroANove;
	public String[] DezADezenove;
	public String[] Dezenas;
	public String[] Centenas;
	public static final String MIL = "mil";
	public static final String MILHOES = "milhoes";
 	
	
	public NumeroPorExtenso() {
		
		ZeroANove = new String[] { "zero","um","dois","tres","quatro","cinco","seis","sete","oito","nove"};
		DezADezenove = new String[] {"dez", "onze", "doze", "treze", "catorze",
                "quinze", "dezesseis", "dezessete", "dezoito", "dezenove" };
		Dezenas = new String[] {"vinte","trinta","quarenta","cinquenta","sessenta","setenta","oitenta","noventa"};
		Centenas = new String[] {"cento","duzentos","trezentos","quatrocentos","quinhentos","seiscentos"
				,"setecentos","oitocentos","novecentos"};
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
			return DezADezenove[numero%10];
		}else if (numero < 100){
			return dezenas(numero);
		}else if (numero < 1000){
			return centenas(numero);
		}else if (numero < 10000){
			return milhares(numero);
		}else if (numero < Math.pow(10, 9)) {
            return milhoes(numero);
    }
          return "um bilhão";
		
		
	}
	
	
	private String dezenas(int numero) {
        if (numero % 10 == 0)
                return Dezenas[(numero / 10) -2 ];
        return extenso(numero % 10, extenso(String.valueOf(numero - (numero % 10))) + " e ");
    }
	
	private String centenas(int numero)  {
        if (numero == 100)
                return "cem";
        if (numero % 100 == 0)
                return Centenas[numero/100 - 1];
        return extenso(numero % 100, Centenas[(numero - (numero % 100))/100 - 1] + " e ");
}
	
	
	private String milhares(int numero) {
        if (numero % 1000 == 0)
                return String.format("%s %s", extenso(String.valueOf(numero/1000)), MIL);
        return extenso(numero % 1000, extenso(String.valueOf(numero - (numero % 1000))) + ((numero%100==0 || numero%1000 < 100)? " e ": " "));        
        }
	
	private String milhoes(int numero){
        if (numero == 1000000)
                return "um milhão";
        int resto = numero % 1000000;
        if (resto == 0)
                return String.format("%s %s", extenso(String.valueOf(numero/1000000)), MILHOES );
        return extenso(resto, extenso(String.valueOf(numero - (resto))) + ((numero%100==0 || numero%1000 < 100)? " e ": " "));
}
	
	private String extenso(int numero, String string) {
		String n = String.valueOf(numero);
        return string + extenso(n);
	}
	
}
