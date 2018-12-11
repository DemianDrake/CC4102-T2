package dijkstra;

import java.util.Arrays;

public class BinaryHeap implements Heap {
	
	private static final int DEFAULT_CAPACITY=10;
	protected Node[] array;
	protected int size;
	
	
	public BinaryHeap() {
		size=0;
		array=new Node[DEFAULT_CAPACITY];
	}
	
	public Node[] getArray() {
		return this.array;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void setArray(Node[] n) {
		this.array=n;
	}
	
	public void setSize(int i) {
		this.size=i;
	}
	
	public boolean isEmpty() {
		return size==0;
	}

	public void insert (Node x) {
		if (size >= array.length - 1) {
            array = this.resize();
        }        
        size++;
        int index = size;
        array[index] = x;
        bubbleUp();
    }
	
	public Node minimum() {
		 if (this.isEmpty()) {
	            throw new IllegalStateException();
		 }
	        return array[1];
	}
	
	public Node extract_min(BinaryHeap H) {
    	Node result = minimum();
    	array[1] = array[size];
    	array[size] = null;
    	size--;
    	bubbleDown();
    	return result;
    }
	
	protected void bubbleDown() {
        int index = 1;
        while (hasLeftChild(index)) {
            int smallerChild = leftIndex(index);
            if (hasRightChild(index)
                && array[leftIndex(index)].getKey() > array[rightIndex(index)].getKey()) {
                smallerChild = rightIndex(index);
            } 
            
            if (array[index].getKey() > array[smallerChild].getKey()) {
                swap(index, smallerChild);
            } else {
                break;
            }
            index = smallerChild;
        }        
    }
	 
	protected void bubbleUp() {
		int index = this.size;
		while (hasParent(index)
		        && (parent(index).getKey() > array[index].getKey())) {
		    swap(index, parentIndex(index));
		    index = parentIndex(index);
		}        
    }
	
    protected boolean hasParent(int i) {
        return i > 1;
    }
    
    protected int leftIndex(int i) {
        return i * 2;
    }
    
    protected int rightIndex(int i) {
        return i * 2 + 1;
    }
    
    protected boolean hasLeftChild(int i) {
        return leftIndex(i) <= size;
    }
    
    protected boolean hasRightChild(int i) {
        return rightIndex(i) <= size;
    }
    
    protected Node parent(int i) {
        return array[parentIndex(i)];
    }
    
    protected int parentIndex(int i) {
        return i / 2;
    }
    
    protected Node[] resize() {
        return Arrays.copyOf(array, array.length * 2);
    }
    
    protected void swap(int index1, int index2) {
        Node tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;        
    }
    
    public static void decrease_key(BinaryHeap H, Node x, double k) {
    	if (x.getKey()>k) {
    		x.setKey(k);
    	}		
	}

	@Override
	public void decrease_key(Node x, double k) {
		BinaryHeap.decrease_key(this, x, k);		
	}

	@Override
	public Node extract_min() {
		return this.extract_min(this);
	}
    
}