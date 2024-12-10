package uno;

import java.io.File;
import java.io.IOException;

public class ejemplo7 {

	public static void main(String[] args) throws IOException {
		//Redireccionar la salida y errores a fichero
		
		ProcessBuilder pb= new ProcessBuilder("CMD","/C","DIR");
		
		File fOut = new File("salida.txt");
		File fErr = new File("error.txt");
		
		pb.redirectOutput(fOut);
		pb.redirectError(fErr);
		pb.start();

	}

}
