package dijkstra;

public class Node{
	
	private int key;
	private int value;
	private Node left;
	private Node right;
	private Node p;
	private Node child;
	private int degree;
	private boolean mark;
	
	public Node (int key, int value) {
		this.key=key;
		this.value=value;
	}
	
	public void setKey(int i) {
		this.key=i;
	}
	
	public void setValue(int i) {
		this.value=i;
	}
	
	public void setLeft(Node n) {
		this.left=n;
	}
	
	public void setRight(Node n) {
		this.right=n;
	}
	
	public void setP(Node n) {
		this.p=n;
	}
	
	public void setChild(Node n) {
		this.child=n;
	}
	
	public void setDegree(int i) {
		this.degree=i;
	}
	
	public void setMark(boolean b) {
		this.mark=b;
	}
	
	public int getKey() {
		return this.key;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public Node getLeft() {
		return this.left;
	}
	
	public Node getRight() {
		return this.right;
	}
	
	public Node getP() {
		return this.p;
	}
	
	public Node getChild() {
		return this.child;
	}
	
	public int getDegree() {
		return this.degree;
	}
	
	public boolean getMark() {
		return this.mark;
	}
	
}