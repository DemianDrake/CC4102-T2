package dijkstra;

import graph.Node;

public class DijkstraResult {
	private graph.Node origin;
	private double[] distanceTo;
	private graph.Node[] pathTo;
	private long time;
	
	public DijkstraResult(graph.Node source, double[] dist, graph.Node[] prev, long t) {
		setOrigin(source);
		setDistanceTo(dist);
		setPathTo(prev);
		setTime(t);
	}

	public graph.Node getOrigin() {
		return origin;
	}

	public void setOrigin(graph.Node origin) {
		this.origin = origin;
	}

	public double[] getDistanceTo() {
		return distanceTo;
	}

	public void setDistanceTo(double[] distanceTo) {
		this.distanceTo = distanceTo;
	}

	public graph.Node[] getPathTo() {
		return pathTo;
	}

	public void setPathTo(graph.Node[] pathTo) {
		this.pathTo = pathTo;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}
}
