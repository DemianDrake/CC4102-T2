package dijkstra;

import java.util.List;

import graph.Graph;
import graph.Node;

/** A structure made of multiple arrays to implement naively DijkstraMPA
 * 
 * @author Damian Ibarra Z.
 *
 */
public class DijkstraArrays implements DijkstraMPA {
	private int[] dist;
	private Node[] prev;
	private boolean[] ready;
	
	/** Initializes a DijstraArrays structure with the size of its arrays,
	 *  which should be equal to the amount of nodes in the graph.
	 * 
	 * @param size
	 */
	public DijkstraArrays(int size) {
		this.setSize(size);
	}
	
	/** Returns the size of DijkstraArrays' arrays
	 * 
	 * @return	Arrays' size
	 */
	public int getSize() {
		return dist.length;
	}
	
	/** Allows to change arrays' size
	 * 
	 * @param size	New size of DijkstraArrays' arrays
	 */
	public void setSize(int size) {
		dist = new int[size];
		prev = new Node[size];
		ready = new boolean[size];
	}

	@Override
	public long dijkstra(Graph g, Node origin) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Node> getPathTo(Node p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getDistanceTo(Node p) {
		// TODO Auto-generated method stub
		return 0;
	}

}
