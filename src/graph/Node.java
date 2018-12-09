package graph;

import java.util.HashMap;
import java.util.Map;

/** A basic Node composed by a number identifying it
 * 
 * @author Damian Ibarra Z.
 *
 */
public class Node {
	private int i;
	private Map<Integer, Double> adjNodes;
	
	public Node() {
		adjNodes = new HashMap<Integer, Double>();
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
		adjNodes.put(n.getId(), weight);
	}
	
	public int countAdjNodes() {
		return adjNodes.size();
	}
	
	public Map<Integer, Double> getAdjacents() {
		return adjNodes;
	}
}