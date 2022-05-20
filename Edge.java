import java.util.*;
 
//class to store edges of the weighted graph
class Edge {
    int weight, val;
    String dest, src;
	public Edge(int val, String string, String string2, String string3) {
        this.val = val;
		this.src = string;
        this.dest = string2;
        this.weight = Integer.parseInt(string3);
	}
}