package Ejercicio3;

public class ControlaArgumentos {

	public static void main(String[] args) {
		if(args.length < 1) {
			System.exit(1);
		}else if(args.length == 1 && args[0].length() > 3) {
			System.exit(2);
		}else if(args.length == 1 && Integer.parseInt(args[0]) < 0) {
			System.exit(3);
		}else if(args.length == 1 && Integer.parseInt(args[0]) > 0) {
			System.exit(4);
		}else {
			System.exit(-1);
		}

	}

}
