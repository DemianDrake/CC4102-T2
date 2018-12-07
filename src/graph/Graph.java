package graph;

import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.Random;

import javafx.util.Pair;

/**
 * @author Alexis Espinoza G.
 * <p>
 * Singleton class used to create connected graphs
 */
public class Graph {

    private static Graph singleton;

    private Graph() {
    }

    public static Graph getInstance() {
        if (singleton == null) {
            singleton = new Graph();
        }
        return singleton;
    }

    // Initial implementation without nodes
    public static ArrayList<Pair<Integer, Double>>[] createRandom(int vertices, int edges)
            throws IllegalArgumentException {

        // Check if there are enough edges to return a connected graph
        if (edges < vertices - 1) {
            throw new IllegalArgumentException("Not enough edges to connect the graph");
        }

        // Create a random number generator
        Random rng = new Random();

        // Create the graph representation
        @SuppressWarnings("unchecked")
        ArrayList<Pair<Integer, Double>>[] graph =
                (ArrayList<Pair<Integer, Double>>[]) new ArrayList[vertices]; // Ahí hay n

        // Create (vertices - 1) edges connecting every vertex to the next
        double weight;
        for (int i = 0; i < vertices - 1; i++) { // Aquí hay que hacer n - 1 aristas
            weight = rng.nextDouble();
            graph[i].add(new Pair<>(i + 1, weight));
            graph[i + 1].add(new Pair<>(i, weight));
        }

        //  Create (edges - (vertices - 1)) edges at random
        int v1, v2;
        for (int i = 0; i < edges - (vertices - 1); i++) { // Aquí se hacen e - (n - 1) aristas
            v1 = rng.nextInt(vertices);
            v2 = rng.nextInt(vertices);
            weight = rng.nextDouble();
            graph[v1].add(new Pair<>(v2, weight));
            graph[v2].add(new Pair<>(v1, weight));
        }

        return graph;
    }

}
