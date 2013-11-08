package lab1TDD;

public class NumeroPoExtenso {

	public String[] ZeroANove;
	
	
	
	public NumeroPoExtenso() {
		
		ZeroANove = new String[] { "zero","um","dois","tres","quatro","cinco","seis","sete","oito","nove","dez"};	
	}
	
	
	
	public String extenso(int numero){
	
		return ZeroANove[numero];
	}
	
}
