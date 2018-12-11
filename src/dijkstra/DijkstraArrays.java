package dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import graph.Graph;
import graph.Node;

/**
 * A structure made of multiple arrays to implement naively DijkstraMPA
 *
 * @author Damian Ibarra Z.
 */
public class DijkstraArrays implements DijkstraMPA {
	private double[] dist;
	private Node[] prev;
	private boolean[] ready;

	/**
	 * Initializes a DijstraArrays structure with the size of its arrays,
	 * which should be equal to the amount of nodes in the graph.
	 *
	 * @param size
	 */
	public DijkstraArrays(int size) {
		this.setSize(size);
	}

	/**
	 * Returns the size of DijkstraArrays' arrays
	 *
	 * @return Arrays' size
	 */
	public int getSize() {
		return dist.length;
	}

	/**
	 * Allows to change arrays' size
	 *
	 * @param size New size of DijkstraArrays' arrays
	 */
	public void setSize(int size) {
		dist = new double[size];
		prev = new Node[size];
		ready = new boolean[size];
	}

	@Override
	public DijkstraResult dijkstra(Graph g, Node origin) {
		long t0 = System.currentTimeMillis();
		int size = g.getSize();
		if (size != dist.length) {
			this.setSize(size);
		}

		int i, j, minNodeId;
		double minDist;

		// Initialize array values
		for (i = 0; i < size; i++) {
			if (i == origin.getId()) {
				dist[i] = 0;
			} else {
				dist[i] = Double.MAX_VALUE;
			}
			ready[i] = false;
			prev[i] = null;
		}

		for (i = 0; i < size; i++) {
			minDist = Double.MAX_VALUE;
			minNodeId = -1;

			for (j = 0; j < size; j++) {
				if (!ready[j] && dist[j] <= minDist) {
					minDist = dist[j];
					minNodeId = j;
				}
			}
			
			Node u = g.getNode(minNodeId);
			ready[u.getId()] = true;

			Iterator<Map.Entry<Integer, Double>> it = u.getAdjacents().entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<Integer, Double> entry = (Map.Entry<Integer, Double>) it.next();
				double currentDistance = dist[minNodeId] + entry.getValue();
				int v = entry.getKey();
				if (dist[v] > currentDistance) {
					dist[v] = currentDistance;
					prev[v] = u;
				}
			}
		}

		long tf = System.currentTimeMillis() - t0;
		
		return new DijkstraResult(origin, dist, prev, tf);
	}

	@Override
	public List<Node> getPathTo(Node p) {
		List<Node> path = new ArrayList<Node>();
		path.add(p);
		int id = p.getId();
		Node q = prev[id];
		while (true) {
			path.add(q);
			id = q.getId();
			if (prev[id] == null) {
				break;
			} else {
				q = prev[id];
			}
		}
		Collections.reverse(path);
		return path;
	}

	@Override
	public double getDistanceTo(Node p) {
		return dist[p.getId()];
	}

}
