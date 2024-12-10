package Ejercicio4;

public class RepetirCadena {

	public static void main(String[] args) {
		if(args.length == 1) {
			String cadena = args[0];
			for (int x = 0; x < 5; x++) {
				System.out.println(cadena);
			}
			System.exit(0);
		}else {	
			System.out.println("No hay ninguna cadena");
			System.exit(1);
		}
		
	}

}
