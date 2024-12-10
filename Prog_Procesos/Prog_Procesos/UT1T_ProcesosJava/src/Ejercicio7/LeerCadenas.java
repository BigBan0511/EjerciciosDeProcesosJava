package Ejercicio7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeerCadenas {

	public static void main(String[] args) {
		File fichero = new File("..\\inputEj07");
		try {
			fichero.createNewFile();
			FileInputStream fis = new FileInputStream(fichero);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			
			String linea = br.readLine();
			if(linea.equalsIgnoreCase("*") && linea != null) {
				System.out.println("Lectura terminada");
			}else {
				while(linea != null && !linea.equalsIgnoreCase("*")) {
					System.out.println(linea);
					linea = br.readLine();
				}
				System.out.println("---------------------------");
				System.out.println("Lectura terminada");
			}
			br.close();
			isr.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch(NullPointerException e) {
			System.out.println("El fichero esta vacio");
		}

	}

}
