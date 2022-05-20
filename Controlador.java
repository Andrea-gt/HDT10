import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Controlador {
	private TxtReader fr = new TxtReader();
	private ArrayList<String> lines = new ArrayList<String>();
	private List<Edge> edges = new ArrayList<Edge>();
	/**
	 * Metodo encargado de ingresar las palabras iniciales al diccionario
	 */
	public void EstablishingWords() {
		try {
			lines = fr.readingFile("guategrafo.txt");
			for (int i = 0; i < lines.size(); i++){
				String [] tempArray = lines.get(i).split(" ");
				edges.add(new Edge(tempArray[0], tempArray[1], tempArray[2]));
			}

		} catch (FileNotFoundException e) {
			System.out.println("Usted no cuenta con un archivo con este nombre);
			System.exit(0);
		}
	}
}
