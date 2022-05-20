import java.util.ArrayList;
import java.util.List;

// Graph class
class Graph {

    final static int INF = 99999, V = 4;

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
 
    //Graph Constructor
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


    void floydWarshall(int graph[][]){

        int dist[][] = new int[V][V];
        int i, j, k;
        /* Initialize the solution matrix 
           same as input graph matrix.
           Or we can say the initial values 
           of shortest distances
           are based on shortest paths 
           considering no intermediate
           vertex. */

        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                dist[i][j] = graph[i][j];
 
        /* Add all vertices one by one 
           to the set of intermediate
           vertices.
          ---> Before start of an iteration, 
               we have shortest
               distances between all pairs 
               of vertices such that
               the shortest distances consider 
               only the vertices in
               set {0, 1, 2, .. k-1} as 
               intermediate vertices.
          ----> After the end of an iteration, 
                vertex no. k is added
                to the set of intermediate 
                vertices and the set
                becomes {0, 1, 2, .. k} */

        for (k = 0; k < V; k++){

            // Pick all vertices as source one by one
            for (i = 0; i < V; i++){
                // Pick all vertices as destination for the
                // above picked source
                for (j = 0; j < V; j++){

                    // If vertex k is on the shortest path from
                    // i to j, then update the value of dist[i][j]
                    if (dist[i][k] + dist[k][j] < dist[i][j])

                        dist[i][j] = dist[i][k] + dist[k][j];

                }

            }

        }
 

        // Print the shortest distance matrix

        printSolution(dist);

    }
 

    void printSolution(int dist[][])

    {

        System.out.println("The following matrix shows the shortest "+

                         "distances between every pair of vertices");

        for (int i=0; i<V; ++i)

        {

            for (int j=0; j<V; ++j)

            {

                if (dist[i][j]==INF)

                    System.out.print("INF ");

                else

                    System.out.print(dist[i][j]+"   ");

            }

            System.out.println();

        }

    }
 
}