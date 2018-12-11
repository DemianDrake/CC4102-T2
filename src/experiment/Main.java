package experiment;

import graph.*;
import dijkstra.*;

public class Main {
	public static void main(String[] args) {
		int n = 100000; // nodes
		
		System.out.println("First experiment n = 100.000, e = n * 10");
		
		Graph g = Graph.createRandom(n, n*10);
		graph.Node origin = g.getNode(42); // Origin is 42 because reasons
		DijkstraMPA a = new DijkstraArrays(n);
		DijkstraHeap h = new DijkstraHeap();
		
		FibonacciHeap fh = new FibonacciHeap();
		BinaryHeap bh = new BinaryHeap();
		
		System.out.println("Calculating minimal path from node 42...");
		
		DijkstraResult arrayResult = a.dijkstra(g, origin);
		
		h.setHeap(fh);
		DijkstraResult fibonacciResult = h.dijkstra(g, origin);
		//DijkstraResult binaryResult = bh.dijkstra(g, origin);
		
		System.out.println("<Arrays> took " + Double.toString(arrayResult.getTime()) + " miliseconds to complete the operation.");
		System.out.println("<FibonacciHeap> took " + Double.toString(fibonacciResult.getTime()) + " miliseconds to complete the operation.");
		//System.out.println("<BinaryHeap> took " + Double.toString(binaryResult.getTime()) + " miliseconds to complete the operation.");
		
		
		System.out.println("\nSecond experiment n = 100.000, e = n * 100");
		
		g = Graph.createRandom(n,  n*100);
		origin = g.getNode(42);
		
		System.out.println("Calculating minimal path from node 42...");
		
		arrayResult = a.dijkstra(g, origin);
		fibonacciResult = h.dijkstra(g, origin);
		
		System.out.println("<Arrays> took " + Double.toString(arrayResult.getTime()) + " miliseconds to complete the operation.");
		System.out.println("<FibonacciHeap> took " + Double.toString(fibonacciResult.getTime()) + " miliseconds to complete the operation.");

		System.out.println("\nThird experiment n = 100.000, e = n * 1000");
		
		g = Graph.createRandom(n,  n*1000);
		origin = g.getNode(42);
		
		System.out.println("Calculating minimal path from node 42...");
		
		arrayResult = a.dijkstra(g, origin);
		fibonacciResult = h.dijkstra(g, origin);
		
		System.out.println("<Arrays> took " + Double.toString(arrayResult.getTime()) + " miliseconds to complete the operation.");
		System.out.println("<FibonacciHeap> took " + Double.toString(fibonacciResult.getTime()) + " miliseconds to complete the operation.");

	}
}
