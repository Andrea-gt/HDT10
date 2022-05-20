import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

public class TestGraph extends TestCase {
	private Graph graph;
	private List<Edge> edges = Arrays.asList(new Edge(0, "Mixco", "Antigua","30"),new Edge(1,"Antigua","Escuintla","25"), new Edge(2,"Escuintla","Santa Lucia","15"));
	
	 public void initialize() {
		 graph = new Graph(edges);
	}
	 
	 public void testPrint() {
		 initialize();
		 assertEquals(",Vertice: Mixco ==> Antigua (30),Vertice: Antigua ==> Escuintla (25),Vertice: Escuintla ==> Santa Lucia (15)",Graph.printGraph(graph));
	 }
}
