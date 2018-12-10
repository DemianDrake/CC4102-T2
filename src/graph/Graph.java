package graph;

import java.lang.IllegalArgumentException;
import java.util.Random;

/**
 * @author Alexis Espinoza G.
 * <p>
 * Singleton class used to create connected graphs
 */
public class Graph {

    private static Graph singleton;
    private Node[] graph;

    private Graph() {
    }

    public static Graph getInstance() {
        if (singleton == null) {
            singleton = new Graph();
            singleton.graph = null;
        }
        return singleton;
    }

    /**
     * Creates a new random connected graph in the instance, replacing the previous graph.
     *
     * @param vertices Amount of vertices for the new random graph
     * @param edges    Amount of edges for the new random graph
     * @throws IllegalArgumentException if the amount of edges isn't enough to generate a connected graph
     */
    public static void createRandom(int vertices, int edges) throws IllegalArgumentException {

        // Check if there are enough edges to return a connected graph
        if (edges < vertices - 1) {
            throw new IllegalArgumentException("Not enough edges to connect the graph");
        }

        // Create a random number generator
        Random rng = new Random();

        // Create the graph representation and the new Nodes
        Graph instance = getInstance();
        instance.graph = new Node[vertices];
        for (int i = 0; i < vertices; i++) {
            instance.graph[i] = new Node(i);
        }


        // Create (vertices - 1) edges connecting every vertex to the next
        double weight;
        for (int i = 0; i < vertices - 1; i++) {
            weight = rng.nextDouble();
            instance.graph[i].addAdjacentNode(instance.graph[i + 1], weight);
            instance.graph[i + 1].addAdjacentNode(instance.graph[i], weight);
        }

        //  Create (edges - (vertices - 1)) edges at random
        int v1, v2;
        for (int i = 0; i < edges - (vertices - 1); i++) {
            v1 = rng.nextInt(vertices);
            v2 = rng.nextInt(vertices);
            weight = rng.nextDouble();
            instance.graph[v1].addAdjacentNode(instance.graph[v2], weight);
            instance.graph[v2].addAdjacentNode(instance.graph[v1], weight);
        }
    }

    /**
     * Returns the current graph contained in the instance.
     *
     * @return The current graph.
     */
    public static Node[] getGraph() {
        return getInstance().graph;
    }

}
