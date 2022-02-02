package cliente_servidor;

public class Prueba {

	public static void main(String[] args) {

		String str = "hola=2asddd";
		
		System.out.println(str.indexOf('='));
		System.out.println(str.substring(str.indexOf('=')+1));
		
		System.out.println(str.split("=")[1]);
	}

}
