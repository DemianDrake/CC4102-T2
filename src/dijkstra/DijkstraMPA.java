package dijkstra;

import java.util.List;
import graph.*;

/** Interface for classes that implements Dijkstra Minimal Path Algorithm (MPA)
 * 
 * @author Damian Ibarra Z.
 *
 */
public interface DijkstraMPA {
	/** Applies Dijkstra's Minimal Path Algorithm according to structure implementation
	 *  to a given graph, and specifying an origin node. Modifies the structure to show
	 *  minimal path from origin to every node. Minimal path from origin to origin is 0.
	 * 
	 * @param g			Graph for which we want to calculate minimal paths
	 * @param origin	Origin node from which every path will start
	 * @return			Time that algorithm took to execute
	 */
	public long dijkstra(Graph g, Node origin);
	
	/** Returns a list of nodes representing a minimal path from the first node of itself to the
	 *  node received as argument. Should only be used after dijkstra method.
	 * 
	 * @param p		The last node of the path
	 * @return		List of nodes conforming minimal path from origin to argument
	 */
	public List<Node> getPathTo(Node p);
	
	/** Returns the distance of a minimal path between an origin node (set when dijkstra is used)
	 *  to the argument node p. Should only be used after dijkstra method.
	 * 
	 * @param p		The last node of the path
	 * @return		Minimal path's distance from origin to p
	 */
	public int getDistanceTo(Node p);
}
