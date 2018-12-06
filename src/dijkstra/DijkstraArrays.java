package dijkstra;

import java.util.ArrayList;
import java.util.Collections;
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
		List<Node> path = new ArrayList<Node>();
		path.add(p);
		int id = p.getId();
		Node q = prev[id];
		while(true) {
			path.add(q);
			id = q.getId();
			if(prev[id] == null) {
				break;
			} else {
				q = prev[id];
			}
		}
		Collections.reverse(path);
		return path;
	}

	@Override
	public int getDistanceTo(Node p) {
		return dist[p.getId()];
	}

}
