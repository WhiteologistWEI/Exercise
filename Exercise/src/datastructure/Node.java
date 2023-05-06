package datastructure;

public class Node{
	int no;
	String info;
	Node next;
	
	public Node(int no, String info) {
		this.no = no;
		this.info = info;
	}
	
	public Node(int no) {
		this.no = no;
		this.info="data"+no;
	}
	
	@Override
	public String toString() {
		return "[No" + no + ", " + info + "]";
	}



	Node next() {
		return next;
	}
}