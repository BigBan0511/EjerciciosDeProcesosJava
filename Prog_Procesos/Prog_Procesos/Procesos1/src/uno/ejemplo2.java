package uno;

import java.io.IOException;
import java.io.InputStream;

public class ejemplo2 {

	public static void main(String[] args) {
		try {
			Process p = new ProcessBuilder("CMD","/C","DIR").start();
			
			//Capturamos el stream de salida
			InputStream i = p.getInputStream();
			
			//Mostramos por pantalla caracter a caracter con read()
			int c;
			while ((c = i.read())!= -1) {
				System.out.print((char)c);
			}
			i.close();
			
			//Comprobacion error
			int exitVal;
			try {
				//Esperamos a que el subproceso p finalice
				//Recoge la devolucion de System.exit()
				exitVal = p.waitFor();
				System.out.println("\nValor de salida " + exitVal);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
