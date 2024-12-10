package Practica2a;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

public class LlamarPalindromo {

	//Los ficheros de texto se encuentran dentro de la carpeta principal del proyecto
	
	/*Primero creamos dos objetos File en los que en uno se encuentra el programa (directorio) y el otro donde están las cadenas
	 de las que vamos a comprobar si son capicuas.
	 
	 Inicializamos un contador a 0 para comprobar cadenas vacías y Process y ProcessBuilder a los que luego los inicializaremos
	 completamente después de la lectura, creamos un try catch para el manejo correcto de excepciones posibles durante la
	 ejecución e inicializamos las clases necesarias y el BufferedReader para leer del fichero en el que se encuentran las cadenas
	 a comprobar, creamos un bucle while en el que controlemos que lea y no se salga del archivo, dentro de este bucle creamos
	 el Process y el ProcessBuilder pasando la linea leída y donde redireccionamos la salida del otro proceso hacia un fichero
	 outputPr2a.txt. Finalmente comprobamos con los valores de salida del otro proceso que se ha ejecutado correctamente y
	 cerramos los flujos de entrada/salida*/

	public static void main(String[] args) {
		File directorio = new File(".\\bin");
		File fichLeer = new File("inputPr2a.txt");
		ProcessBuilder pb;
		Process p = null;
		int contador = 0;
		try {
			FileReader fr = new FileReader(fichLeer);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while((linea = br.readLine()) != null) {
				pb = new ProcessBuilder("java","Practica2a.Palindromo", linea);
				if(linea.equalsIgnoreCase("") || linea.equalsIgnoreCase(" ")) {
					contador ++;
				}else {
					pb.directory(directorio);
					pb.redirectOutput(Redirect.appendTo(new File(".\\outputPr2a.txt")));
					p = pb.start();
				}
			}
			br.close();
			fr.close();
			if(p.waitFor() == 0) {
				if(contador > 0) {
					System.out.println("Hay " + contador + " cadena/s vacia/s dentro del fichero");
					System.out.println("Programa finalizado con exito");
				}else {
					System.out.println("Programa finalizado con exito");
				}
			}else if(p.waitFor() == 1){
				System.out.println("Error durante la ejecucion, asegurese de que existe una cadena");
			}else if(p.waitFor() == 2) {
				System.out.println("Error durante la ejecucion, asegurese de que solo ha introducido una cadena");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: No se ha encontrado el fichero " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error de entrada/salida: " + e.getMessage());
		} catch (InterruptedException e) {
			System.out.println("Error durante la ejecucion: " + e.getMessage());
		}
	}

}
