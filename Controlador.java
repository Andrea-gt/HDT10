import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*Universidad del Valle de Guatemala
 * Algoritmos y Programacion Basica, seccion 20
 * Fecha de entrega: 20/05/2022
 * Andrea Ximena Ramirez Recinos 21874
 * Adrián Ricardo Flores Trujillo 21500
 * Clase Controlador
 */
public class Controlador {
	private TxtReader fr = new TxtReader();
	private ArrayList<String> lines = new ArrayList<String>();
	private List<Edge> edges = new ArrayList<Edge>();
	private Scanner scan = new Scanner(System.in);
	
	/**
	 * Metodo encargado de ingresar las palabras iniciales al grafo
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

	/**
	 * Metodo para inicializar el grafo
	 */
	public Graph genGraph(){
		return new Graph(edges);
	}

	/**
	 * Metodo para agregar un Edge al grafo
	 * @param g (Grafo)
	 * @return
	 */
	public Graph addEdge(Graph g){
		String[] temp = new String[2];
		System.out.println("\nIngrese el primer vertice: ");
		temp[0] = scan.next();
		System.out.println("\nIngrese el segundo vertice: ");
		temp[1] = scan.next();
		System.out.println("\nIngrese el peso del arco: ");
		int w = scan.nextInt();

		for(int i = 0; i<g.adj_list.size(); i++){
			for(int h = 0; h<g.adj_list.get(i).size(); i++){
				if(g.adj_list.get(i).get(h).src.equals(temp[0]) && g.adj_list.get(i).get(h).value.equals(temp[1])){

					System.out.println("\nEsta ruta ya existe, por lo que se solamente se ha actualizado el peso.");

					g.adj_list.get(i).get(h).weight = w;
					return g;

				}
			}
		}
	
		edges.add(new Edge(edges.size(), temp[0], temp[1], w));
		System.out.println("\nRuta agregada exitosamente");
		return genGraph();

	}

	/**
	 * Metodo para elminar un Edge al grafo
	 * @param Grafo g
	 * @return void
	 */
	public Graph removeEdge(Graph g){
		String[] temp = new String[2];
		System.out.println("\nIngrese el primer vertice: ");
		temp[0] = scan.next();
		System.out.println("\nIngrese el segundo vertice: ");
		temp[1] = scan.next();

		for(int i = 0; i<g.adj_list.size(); i++){
			for(int h = 0; h<g.adj_list.get(i).size(); i++){
				if(g.adj_list.get(i).get(h).src.equals(temp[0]) && g.adj_list.get(i).get(h).value.equals(temp[1])){

					System.out.println(edges.get(i).src + " " + edges.get(i).dest);

					edges.remove(i);

					for(int f = i; f<edges.size(); f++){
						edges.get(f).val--;
					}

					System.out.println("\nRuta removida exitosamente.");

					return genGraph();

				}
			}
		}

		System.out.println("\nEsa ruta no existe.");

		return g;

	}
	
	/**
	 * Metodo para determinar el centro del grafo
	 * @param Grafo g
	 * @return String
	 */
	public String calcCentro(Graph g){

		//Excentricidad

		String[] temp = new String[2];
		String centro = " ";
		int w_temp = 9999;
		for(int i = 0; i<g.adj_list.size()-1; i++){
			centro = g.adj_list.get(1).get(0).src;
			w_temp = g.adj_list.get(5).get(0).weight;
			for(int h = 0; h<g.adj_list.get(i).size()-1; i++){
				if(g.adj_list.get(i).get(h).src.equals(temp[0]) && g.adj_list.get(i).get(h).value.equals(temp[1])){

					if(g.adj_list.get(i).get(h).weight < w_temp){
						w_temp = g.adj_list.get(i).get(h).weight;
						centro = g.adj_list.get(i).get(h).src;
					} 
					
				} else {
					if(w_temp == 9999){
						w_temp -= w_temp;
					} else {
						w_temp += 5;
					}
				}
			}
		}

		return "Centro del grafo actual: " + centro + "\nExcentricidad: " + w_temp;
	}

}
