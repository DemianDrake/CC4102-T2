package dijkstra;

public interface Heap {

	public void decrease_key(Node x, double k);

	public Node extract_min();

	public Node minimum();

	void insert(Node x);

	boolean isEmpty();

}
