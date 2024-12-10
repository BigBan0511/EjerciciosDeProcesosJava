package Ejercicio5;

public class SumarNumeros {

	public static void main(String[] args) {
		try {
			if(args.length == 2) {
				int num1 = Integer.parseInt(args[0]);
				int num2 = Integer.parseInt(args[1]);
				System.out.println("Resultado de la suma = " + (num1 + num2));
				System.exit(0);
			}else {
				System.out.println("No hay ningun numero o solo 1");
				System.exit(1);
			}
		}catch(NumberFormatException e) {
			System.out.println("Alguno de los dos argumentos no es un numero");
			System.exit(-5);
		}

	}

}
