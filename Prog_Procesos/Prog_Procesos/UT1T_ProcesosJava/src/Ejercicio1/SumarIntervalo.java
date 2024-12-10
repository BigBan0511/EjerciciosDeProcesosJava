package Ejercicio1;

public class SumarIntervalo {

	public static void main(String[] args) {
		System.out.println("Introduzca un numero");
		int num1 = Integer.parseInt(args[0]);
		System.out.println("Introduzca otro numero");
		int num2 = Integer.parseInt(args[1]);
		int resultado = 0;
		if(num2 > num1) {
			for (int i = (num1+1); i < num2; i++) {
				resultado = resultado + i;
			}
		}
		else if(num1 > num2){
			System.out.println("El primer numero es mayor que el segundo");
		}
		System.out.println("resultado = " + resultado);

	}

}
