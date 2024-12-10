package Ejercicio5;

import java.io.File;
import java.io.IOException;

public class LlamarSumarNumeros {

	public static void main(String[] args) {
		File directorio = new File(".\\bin");
		
		String num1 = Integer.toString(((int)Math.random()*100) + 1);
		String num2 = Integer.toString(((int)Math.random()*100) + 1);
		String num3 = Integer.toString(((int)Math.random()*100) + 1);
		String num4 = Integer.toString(((int)Math.random()*100) + 1);
		ProcessBuilder pb = new ProcessBuilder("java","Ejercicio5.SumarNumeros", num1, num2);
		ProcessBuilder pb2 = new ProcessBuilder("java","Ejercicio5.SumarNumeros", num3, num4);
		pb.directory(directorio);
		pb2.directory(directorio);
		pb.redirectInput(ProcessBuilder.Redirect.INHERIT);
		pb2.redirectInput(ProcessBuilder.Redirect.INHERIT);
		try {
			Process p1 = pb.start();
			Process p2 = pb2.start();
			System.out.println(p1.waitFor());
			System.out.println(p2.waitFor());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
