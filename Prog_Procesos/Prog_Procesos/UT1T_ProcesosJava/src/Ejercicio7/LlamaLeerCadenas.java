package Ejercicio7;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

public class LlamaLeerCadenas {

	public static void main(String[] args) {
		File directorio = new File(".\\bin");
		ProcessBuilder pb = new ProcessBuilder("java","Ejercicio7.LeerCadenas");
		pb.redirectOutput(Redirect.appendTo(new File("salida07.txt")));
		pb.redirectError(Redirect.appendTo(new File("error07.txt")));
		pb.directory(directorio);
		try {
			Process p = pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
