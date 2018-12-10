package experiment;

import graph.*;
import dijkstra.*;

public class Main {
	public static void main(String[] args) {
		int n = 100000; // nodes
		
		System.out.println("First experiment n = 100.000, e = n * 10");
		
		Graph g = Graph.createRandom(n, n*10);
		graph.Node origin = g.getNode(42); // Origin is 42 because reasons
		DijkstraArrays a = new DijkstraArrays(n);
		FibonacciHeap fh = new FibonacciHeap();
		ClassicHeap ch = new ClassicHeap();
		
		System.out.println("Calculating minimal path from node 42...");
		
		double tArrays = a.dijkstra(g, origin) / 1000.;
		double tFibonacci = fh.dijkstra(g, origin) / 1000.;
		double tHeap = ch.dijkstra(g, origin) / 1000.;
		
		System.out.println("<Arrays> took " + Double.toString(tArrays) + " seconds to complete the operation.");
		System.out.println("<FibonacciHeap> took " + Double.toString(tFibonacci) + " seconds to complete the operation.");
		System.out.println("<ClassicHeap> took " + Double.toString(tHeap) + " seconds to complete the operation.");
		
	}
}
