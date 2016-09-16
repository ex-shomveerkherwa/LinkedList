package linkedListConcepts;

public class LinkNode {
	
	int data;
	LinkNode neighbour;
	
	public LinkNode getNeighbour() {
		return neighbour;
	}

	public void setNeighbour(LinkNode neighbour) {
		this.neighbour = neighbour;
	}

	public LinkNode( int value) {
		data = value;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}
