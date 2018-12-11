package dijkstra;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import graph.Graph;
import graph.Node;

/**
 * 
 * @author Damian Ibarra Z.
 *
 */
public class DijkstraHeap implements DijkstraMPA {
	private Heap heap;
	private double[] dist;
	private Node[] prev;
	
	public DijkstraHeap() {
		heap = new FibonacciHeap(); // default
	}
	
	public DijkstraHeap(Heap h) {
		heap = h;
	}
	
	public void setHeap(Heap h) {
		heap = h;
	}
	
	public void setSize(int n) {
		dist = new double[n];
		prev = new Node[n];
	}

	@Override
	public DijkstraResult dijkstra(Graph g, Node origin) {
		long t0 = System.currentTimeMillis();
		graph.Node[] nodes = g.getVerticesArray();
		int n = g.getSize();
		this.setSize(n);
		for(int i = 0; i < nodes.length; i++) {
			if(nodes[i].getId() == origin.getId()) {
				dist[i] = 0;
			} else {
				dist[i] = Double.MAX_VALUE;
			}
			prev[i] = null;
			heap.insert(new dijkstra.Node(dist[i], i));
		}
		while(!heap.isEmpty()) {
			dijkstra.Node min = heap.extract_min();
			graph.Node m = g.getNode(min.getValue());
			Iterator<Map.Entry<Integer, Double>> it = m.getAdjacents().entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<Integer, Double> entry = (Map.Entry<Integer, Double>) it.next();
				double currentDistance = dist[min.getValue()] + entry.getValue();
				int v = entry.getKey();
				if (dist[v] > currentDistance) {
					dist[v] = currentDistance;
					prev[v] = m;
					heap.decrease_key(new dijkstra.Node(entry.getValue(), entry.getKey()), currentDistance);
				}
			}
		}
		long tf = System.currentTimeMillis() - t0;
		return new DijkstraResult(origin, dist, prev, tf);
	}

	@Override
	public List<Node> getPathTo(Node p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getDistanceTo(Node p) {
		// TODO Auto-generated method stub
		return 0;
	}

}
