package Ejercicio3;

public class MultiplicaArgumentos {

	public static void main(String[] args) {
		if(args.length != 3) {
			System.exit(1);
		}else {
			try {
				int resultado = Integer.parseInt(args[0]) * Integer.parseInt(args[1]) * Integer.parseInt(args[2]);
				System.out.println("Resultado = " + resultado);
				System.exit(0);
			} catch (NumberFormatException e) {
				System.exit(2);
			}
		}

	}

}
