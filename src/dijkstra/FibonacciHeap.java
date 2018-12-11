package dijkstra;

public class FibonacciHeap implements Heap {
	
	private Node min;
	private int n;
	
	
	public FibonacciHeap() {
		this.n=0;
		this.min=null;
	}
	
	public Node getMin() {
		return this.min;
	}
	
	public int getN() {
		return this.n;
	}
	
	public void setMin(Node n) {
		this.min=n;
	}
	
	public void setN(int i) {
		this.n=i;
	}
	
	@Override
	public void insert(Node x) {
		FibonacciHeap.insert(this, x);
	}
	
	public static void insert (FibonacciHeap H, Node x) {
		x.setDegree(0);
		x.setP(null);
		x.setChild(null);
		x.setMark(false);
		if(H.getMin()==null) {
			H.setMin(x);
			x.setLeft(x);
			x.setRight(x);
		}
		else {
			x.setLeft(H.getMin().getLeft());
			x.setRight(H.getMin());
			x.getLeft().setRight(x);
			x.getRight().setLeft(x);
			if(x.getKey()<H.getMin().getKey()) {
				H.setMin(x);
			}
		}
		H.setN(H.getN()+1);
	}
	
	@Override
	public Node minimum() {
		return FibonacciHeap.minimum(this);
	}
	
	public static Node minimum(FibonacciHeap H) {
		return H.getMin();
	}
	
	@Override
	public Node extract_min() {
		return FibonacciHeap.extract_min(this);
	}
	
	public static Node extract_min(FibonacciHeap H) {
		Node z = H.getMin();
		if(z!=null) {
			Node x=z.getChild();
			Node y=x.getRight();
			for(int i=0; i<z.getDegree();i++) {
				insert(H,x);
				x.setP(null);
				x=y;
				y=y.getRight();
			}
			z.getRight().setLeft(z.getLeft());
			z.getLeft().setRight(z.getRight());
			if(z==z.getRight()) {
				H.setMin(null);
			}
			else {
				H.setMin(z.getRight());
				consolidate(H);
			}
			H.setN(H.getN()-1);
		}
		return z;	
	}
	
	public static FibonacciHeap union (FibonacciHeap H1, FibonacciHeap H2) {
		FibonacciHeap H=new FibonacciHeap();
		H.setMin(H1.getMin());
		H.getMin().getLeft().setRight(H2.getMin());
		H2.getMin().getLeft().setRight(H.getMin());
		Node aux = H2.getMin().getLeft();
		H2.getMin().setLeft(H.getMin().getLeft());
		H.getMin().setLeft(aux);
		if(H1.getMin()==null || H2.getMin()!=null && H2.getMin().getKey() < H1.getMin().getKey()) {
			H.setMin(H2.getMin());
		}
		H.setN(H1.getN()+H2.getN());
		return H;
	}
	
	@Override
	public void decrease_key(Node x, double k) {
		FibonacciHeap.decrease_key(this, x, k);
	}
	
	public static void decrease_key(FibonacciHeap H, Node x, double k) {
		if(k>x.getKey()) {
			/*error*/
		}
		x.setKey(k);
		Node y = x.getP();
		if (y!=null && x.getKey()<y.getKey()) {
				cut(H,x,y);
				cascading_cut(H,y);
		}
		if (x.getKey()<H.getMin().getKey()) {
			H.setMin(x);
		}
	}
	
	public static void delete (FibonacciHeap H, Node x) {
		decrease_key(H, x, Integer.MIN_VALUE);
		extract_min(H);
	}
	
	public static void consolidate(FibonacciHeap H) {
		int D=30; /* hardcodeado */
		Node[] A = new Node[D];
		for (int i=0; i<D;i++) {
			A[i]=null;
		}
		Node w=H.getMin();
		Node x;
		Node y;
		Node z;
		for(int i=0; i<H.getN(); i++) {
			x=w;
			int d = x.getDegree();
			while(A[d]!=null) {
				y=A[d];
				if(x.getKey()>y.getKey()) {
					z=x;
					x=y;
					y=z;
				}
				link(H,y,x);
				A[d]=null;
				d++;
			}
		}
		H.setMin(null);
		for(int i=0; i<D; i++) {
			if(A[i]!=null) {
				if(H.getMin()!=null) {
					H.setMin(A[i]);
					A[i].setLeft(A[i]);
					A[i].setRight(A[i]);
				}
				else {
					insert(H, A[i]);
					if(A[i].getKey()<H.getMin().getKey()) {
						H.setMin(A[i]);
					}
				}
			}
		}
	}
	
	public static void link(FibonacciHeap H, Node y, Node x) {
		y.getRight().setLeft(y.getLeft());
		y.getLeft().setRight(y.getRight());
		y.setLeft(x.getLeft());
		y.setRight(x);
		y.getLeft().setRight(y);
		y.getRight().setLeft(y);
		x.setDegree(x.getDegree()+1);
		y.setMark(false);
	}
	
	public static void cut(FibonacciHeap H, Node x, Node y) {
		x.getRight().setLeft(x.getLeft());
		x.getLeft().setRight(x.getRight());
		y.setDegree(y.getDegree()-1);
		insert(H, x);
		x.setP(null);
		x.setMark(false);
	}
	
	public static void cascading_cut(FibonacciHeap H, Node y) {
		Node z = y.getP();
		if (z!=null) {
			if (y.getMark()==false) {
				y.setMark(true);
			}
			else {
				cut(H,y,z);
				cascading_cut(H,z);
			}
		}
	}
	
	@Override
	public boolean isEmpty() {
		return this.minimum() == null;
	}
}
