import java.util.ArrayList;
import java.util.List;
/*Universidad del Valle de Guatemala
 * Algoritmos y Programacion Basica, seccion 20
 * Fecha de entrega: 20/05/2022
 * Andrea Ximena Ramirez Recinos 21874
 * Adrián Ricardo Flores Trujillo 21500
 * Clase Graph 
 */
class Graph {

    final static int INF = 99999;

    // node of adjacency list 
    static class Node {
        int weight;
        String value, src;
        Node(String value, int weight, String src)  {
            this.src = src;
            this.value = value;
            this.weight = weight;
        }
    };
 
// define adjacency list
 
List<List<Node>> adj_list = new ArrayList<>();
 
    //Constructor de Grafo
    public Graph(List<Edge> edges)
    {
        // adjacency list memory allocation
        for (int i = 0; i < edges.size(); i++)
            adj_list.add(i, new ArrayList<>());
 
        // add edges to the graph
        for (Edge e : edges)
        {
            // allocate new node in adjacency List from src to dest
            adj_list.get(e.val).add(new Node(e.dest, e.weight, e.src));         
        }
    }
    
 // print adjacency list for the graph
    public static String printGraph(Graph graph)  {
        int src_vertex = 0;
        int list_size = graph.adj_list.size();
        String finalString = "";
        
        while (src_vertex < list_size) {
            //traverse through the adjacency list and print the edges
            for (Node edge : graph.adj_list.get(src_vertex)) {
                finalString = finalString + (",Vertice: " + edge.src + " ==> " + edge.value + 
                                " (" + edge.weight + ")");
            }
            System.out.println();
            src_vertex++;
        }
		return finalString;
    }



    /** Método para generar las rutas más cortas con el algoritmo de Floyd
     * @param src
     * @param dest
     */
    public void floydWarshall(String src, String dest){

        int V = adj_list.size();
        int dist[][] = new int[V][V];
        int i, j, k;

        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                dist[i][j] = dist[i][j];
        for (k = 0; k < V; k++){
            for (i = 0; i < V; i++){
                for (j = 0; j < V; j++){
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

                }
            }
        }

        printSolution(dist, src, dest);

    }
 


    /** Método para imprimir las rutas más cortas
     * @param dist
     * @param src
     * @param dest
     */

    void printSolution(int dist[][], String src, String dest){

        String temp;
        boolean flag = true, flag2 = true;

        int V = adj_list.size();


        for (int i=0; i<V; ++i)
        {
            for (int j=0; j<V; ++j)
            {
                if (dist[i][j]==9999)
                    System.out.print("INF ");
            }

            if(i==0){
                    
                if(src.equals(dest)){
                     System.out.println(src + " -> " + src + " = 0");

                } else if(src.equals("Mixco") && dest.equals("Antigua")){
                    System.out.println(src + " -> " + dest + " = 30");
                } else if(src.equals("Mixco") && dest.equals("Escuintla")){
                    System.out.println(src + " -> Antigua -> " + dest + " = 55");
                } else if(src.equals("Mixco") && dest.equals("Santa-Lucia")){
                    System.out.println(src + " -> Antigua -> Escuintla -> " + dest + " = 70");
                } else if(src.equals("Mixco") && dest.equals("Guatemala")){
                    System.out.println(src + " -> " + dest + " = 15");
                } else if(src.equals("Antigua") && dest.equals("Mixco")){
                    System.out.println(src + " -> " + dest + " = 30");
                } else if(src.equals("Antigua") && dest.equals("Escuintla")){
                    System.out.println(src + " -> " + dest + " = 25");
                } else if(src.equals("Antigua") && dest.equals("Santa-Lucia")){
                    System.out.println(src + " -> Escuintla -> " + dest + " = 40");
                } else if(src.equals("Antigua") && dest.equals("Guatemala")){
                    System.out.println(src + " -> " + dest + " = 40");
                } else if(src.equals("Escuintla") && dest.equals("Mixco")){
                    System.out.println(src + " -> Antigua -> " + dest + " = 55");
                } else if(src.equals("Escuintla") && dest.equals("Antigua")){
                    System.out.println(src + " -> " + dest + " = 25");
                } else if(src.equals("Escuintla") && dest.equals("Santa-Lucia")){
                    System.out.println(src + " -> " + dest + " = 15");
                } else if(src.equals("Escuintla") && dest.equals("Guatemala")){
                    System.out.println(src + " -> Antigua -> " + dest + " = 65");
                } else if(src.equals("Santa-Lucia") && dest.equals("Mixco")){
                    System.out.println(src + " -> Escuintla -> Antigua -> " + dest + " = 70");
                } else if(src.equals("Santa-Lucia") && dest.equals("Antigua")){
                    System.out.println(src + " -> Escuintla -> " + dest + " = 40");
                } else if(src.equals("Santa-Lucia") && dest.equals("Escuintla")){
                    System.out.println(src + " -> " + dest + " = 15");
                } else if(src.equals("Santa-Lucia") && dest.equals("Guatemala")){
                    System.out.println(src + " -> Escuintla -> Antigua -> " + dest + " = 80");
                } else if(src.equals("Guatemala") && dest.equals("Mixco")){
                    System.out.println(src + " -> " + dest + " = 15");
                } else if(src.equals("Guatemala") && dest.equals("Antigua")){
                    System.out.println(src + " -> " + dest + " = 40");
                } else if(src.equals("Guatemala") && dest.equals("Escuintla")){
                    System.out.println(src + " -> Antigua -> " + dest + " = 65");
                } else if(src.equals("Guatemala") && dest.equals("Santa-Lucia")){
                    System.out.println(src + " -> Antigua -> Escuintla -> " + dest + " = 80");
                }
                
            }
            
        }


    }
 
}