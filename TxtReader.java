/*Universidad del Valle de Guatemala
 * Algoritmos y Programacion Basica, seccion 20
 * Fecha de entrega: 20/05/2022
 * Andrea Ximena Ramirez Recinos 21874
 * Adrián Ricardo Flores Trujillo 21500
 * Clase TxtReader
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TxtReader {
	private ArrayList<String> Lines = new ArrayList<String>();
	/**
	 * Metodo para la lectura de datos de un archivo de texto
	 * 
	 * @param fileName nombre del archivo a leer
	 * @return Strings con las lineas del archivo en un ArrayList
	 */
	public ArrayList<String> readingFile(String fileName) throws FileNotFoundException{
		Scanner scanner  = new Scanner(new File(fileName));
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			Lines.add(line);
		}
		return Lines;
	}
}
