import java.util.Scanner;

public class Main {

	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);

		Controlador c = new Controlador();

		c.EstablishingWords();

		Graph g = c.genGraph();

		while(true){

			System.out.println("\n-----------------------" + "MENU" + "-----------------------");
			System.out.println("1. Mostrar arcos y pesos");
			System.out.println("2. Agregar arco");
			System.out.println("3. Eliminar arco");
			System.out.println("4. Encontrar ruta mas corta entre dos nodos");
			System.out.println("5. Calcular centro del grafo");
			System.out.println("6. Salir");
		
			try{
				int t = scan.nextInt();

				switch(t){

					//Mostrar arcos y pesos
					case 1:
						g.printGraph(g);
						break;

					//Agregar arco
					case 2:
						g = c.addEdge(g);
						break;

					//Elminar arco
					case 3:
						g = c.removeEdge(g);
						break;

					//Encontrar ruta más corta entre dos nodos
					case 4:
						String[] temp = new String[2];
						System.out.println("\nIngrese el primer vertice: ");
						temp[0] = scan.next();
						System.out.println("\nIngrese el segundo vertice: ");
						temp[1] = scan.next();
						g.floydWarshall(temp[0], temp[1]);
						break;

					//Calcular centro del grafo
					case 5:
						System.out.println(c.calcCentro(g));
						break;

					//Salir
					case 6:
						System.exit(0);

					default:
						System.out.println("Ingrese una opcion valida");

				}

			} catch(Exception e){
				System.out.println(e);
			}

		}

	}

}
