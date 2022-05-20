import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controlador {
	private TxtReader fr = new TxtReader();
	private ArrayList<String> lines = new ArrayList<String>();
	private List<Edge> edges = new ArrayList<Edge>();
	private Scanner scan = new Scanner(System.in);
	/**
	 * Metodo encargado de ingresar las palabras iniciales al diccionario
	 */
	public void EstablishingWords() {
		try {
			lines = fr.readingFile("guategrafo.txt");
			for (int i = 0; i < lines.size(); i++){
				String [] tempArray = lines.get(i).split(" ");
				edges.add(new Edge(i, tempArray[0], tempArray[1], tempArray[2]));
			}

		} catch (FileNotFoundException e) {
			System.out.println("Usted no cuenta con un archivo con este nombre");
			System.exit(0);
		}

		

	}

	public Graph genGraph(){
		return new Graph(edges);
	}

	public void addEdge(){
		String[] temp = new String[2];
		System.out.println("\nIngrese el primer vertice: ");
		temp[0] = scan.next();
		System.out.println("\nIngrese el segundo vertice: ");
		temp[1] = scan.next();
		System.out.println("\nIngrese el peso del arco: ");
		int w = scan.nextInt();
		edges.add(new Edge(edges.size(), temp[0], temp[1], w));

	}

}
