package graph;

/** A basic Node composed by a number identifying it
 * 
 * @author Damian Ibarra Z.
 *
 */
public class Node {
	private int i;
	
	public Node() {}
	
	public Node(int i) {
		this.setId(i);
	}
	
	public int getId() {
		return i;
	}
	
	public void setId(int i) {
		this.i = i;
	}
}