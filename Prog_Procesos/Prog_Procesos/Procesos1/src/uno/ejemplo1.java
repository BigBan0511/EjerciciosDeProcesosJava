package uno;

import java.io.IOException;

//Ejemplo uso de las clases ProcessBuilder y Process con metodo start()
public class ejemplo1 {

	public static void main(String[] args) throws IOException {
		//Ejecuto el proceso de notepad (abrirla)
		ProcessBuilder pb = new ProcessBuilder("NOTEPAD");
		Process p = pb.start();
		
		//Ejecuto el proceso calculadora (abrirla)
		ProcessBuilder pb2 = new ProcessBuilder("CALC");
		Process p2 = pb2.start();
		
		Process p3 = new ProcessBuilder("CMD","C/","DIR").start();
		
		

	}

}
