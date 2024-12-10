package Practica2a;

public class Palindromo {

	/*Para poder comprobar si una cadena es o no palindromo primero comprobamos que esté vacía o no y que sea una unica cadena, 
	  posteriormente guardamos la cadena como un array de char para poder recorrerlo luego de manera invertida, teniendo un caracter
	  intermedio al que concatenamos con la cadena Palíndromo, para ello crearemos un contador del tamaño del array de
	  char menos uno para que no salte la excepción de IndexOutOfBoundsException, controlando con un do while el que no
	  se salga del array de char, decrementando el contador por cada intercambio y concatenacion entre cadenas, también,
	  hay que tener en cuenta que la longitud de un array no puede ser menor que 0, asi que lo añadimos al do while
	  mencionado anteriormente, finalmente comprobamos si ambas cadenas son Palindromo con un equalsIgnoreCase*/

	public static void main(String[] args) {
		if(args.length == 0) {
			System.exit(1);
		}else if(args.length > 1){
			System.exit(2);
		}else {
			String cadenaNormal = args[0];
			String cadenaPalin = "";
			char[] cadenaNorSeparada = cadenaNormal.toCharArray();
			int contador = cadenaNorSeparada.length - 1;
			do {
				char intermedio = cadenaNorSeparada[contador];
				cadenaPalin = cadenaPalin + intermedio;
				contador--;
			} while (contador != cadenaNorSeparada.length && contador >= 0);
			if(cadenaNormal.equalsIgnoreCase(cadenaPalin)) {
				System.out.println("La cadena " + cadenaNormal + " es palindromo");
			}else {
				System.out.println("La cadena " + cadenaNormal + " NO es palindromo");
			}
			System.exit(0);
		}
	}

}
