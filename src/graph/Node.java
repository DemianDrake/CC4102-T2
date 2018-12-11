package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A basic Node composed by a number identifying it
 *
 * @author Damian Ibarra Z.
 */
public class Node {
	private int i;
	private List<Node> adjNodes;
	private List<Double> adjNodesWeight;
	//private Map<Integer, Double> adjNodes;

	public Node() {
		//adjNodes = new HashMap<Integer, Double>();
		adjNodes = new ArrayList<Node>();
		adjNodesWeight = new ArrayList<Double>();
	}

	public Node(int i) {
		this();
		this.setId(i);
	}

	public int getId() {
		return i;
	}

	public void setId(int i) {
		this.i = i;
	}

	public void addAdjacentNode(Node n) {
		addAdjacentNode(n, 1);
	}

	public void addAdjacentNode(Node n, double weight) {
		//adjNodes.put(n.getId(), weight);
		adjNodes.add(n);
		adjNodesWeight.add(weight);
	}

	public int countAdjNodes() {
		//return adjNodes.size();
		return adjNodes.size();
	}

	public List<Node> getAdjacents() {
		//return adjNodes;
		return adjNodes;
	}
	
	public double getWeightEdgeTo(Node p) {
		return adjNodesWeight.get(adjNodes.indexOf(p));
	}
}