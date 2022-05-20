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
						c.addEdge();
						g = c.genGraph();
						break;

					//Elminar arco
					case 3:
						break;

					//Encontrar ruta más corta entre dos nodos
					case 4:
						break;

					//Calcular centro del grafo
					case 5:
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
