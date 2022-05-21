import java.util.*;

/*Universidad del Valle de Guatemala
 * Algoritmos y Programacion Basica, seccion 20
 * Fecha de entrega: 20/05/2022
 * Andrea Ximena Ramirez Recinos 21874
 * Adrián Ricardo Flores Trujillo 21500
 * Clase Edge
 */

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
    public Edge(int val, String string, String string2, int w) {
        this.val = val;
        this.src = string;
        this.dest = string2;
        this.weight = w;
    }
}