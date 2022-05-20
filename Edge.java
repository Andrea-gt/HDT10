import java.util.*;
 
//class to store edges of the weighted graph
class Edge {
    int weight;
    String dest, src;
	public Edge(String string, String string2, String string3) {
		this.src = string;
        this.dest = string2;
        this.weight = Integer.parseInt(string3);
	}
}