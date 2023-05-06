package datastructure;

public class UnidirectionalLinkedTable {

	Node head = new Node(0,"");
	
	UnidirectionalLinkedTable getLinkedTable() {
		return this;
	}
	
	void addNode(Node n) {
		Node index = this.head;
		while(true) {
			if(index.next==null)
				break;
			index = index.next();
		}
		index.next = n;
	}
	
	void addByOrder(Node n) {
		Node index = this.head;
		while(true) {
			if(index.next==null)
				break;
			if(n.no>=index.no&&n.no<index.next().no)
				break;
			index = index.next();
		}
		n.next = index.next();
		index.next = n;
	}
	
	UnidirectionalLinkedTable update(Node n) {
		Node idx = head;
		while(true) {
			if(idx.no == n.no)
				break;
			if(idx.next==null)
				throw new RuntimeException("节点不存在！");
			idx = idx.next;
		}
		idx.info=n.info;
		return this;
	}
	
	void show() {
		Node index = this.head;
		while(null != index.next()) {
			index = index.next();
			System.out.printf("→"+index);
		}
		System.out.println();
	}
	
	int getLength() {
		Node p = head.next;
		int i=0;
		while(p!=null) {
			i++;
			p = p.next;
		}
		System.out.println("链表长度："+i);
		return i;
	}
	
	UnidirectionalLinkedTable reverse() {
		System.out.println("Reverse...");
		UnidirectionalLinkedTable lt = new UnidirectionalLinkedTable();
		Node rHead=lt.head;
		Node cur=head.next;
		Node next;
		
		while(cur!=null) {
			next=cur.next;
			
			cur.next=rHead.next;
			rHead.next=cur;			
			cur=next;
		}
		return lt;
	}
	
	UnidirectionalLinkedTable reverse1(){
		System.out.println("Reverse1...");
		Node p = head;
		UnidirectionalLinkedTable lt = new UnidirectionalLinkedTable();
		while(p.next!=null){
			p = p.next;
			
			Node p2 = new Node(p.no, p.info);
			if(lt.head.next==null)
				lt.head.next=p2;
			else{
				p2.next=lt.head.next;
				lt.head.next=p2;
			}
		}
		return lt;
			
	}
	
	UnidirectionalLinkedTable reverse2(){
		System.out.println("Reverse2...");
		UnidirectionalLinkedTable lt = new UnidirectionalLinkedTable();
		Node rHead = lt.head;
		Node cur=head.next;
		Node next;
		
		while(null!=cur){
			next=cur.next;
			
			cur.next=rHead.next;
			rHead.next=cur;
			cur = next;
		}
		return lt;
	}
	
	public static void main(String[] args) {
		
		UnidirectionalLinkedTable lt1 = new UnidirectionalLinkedTable();
		lt1.addByOrder(new Node(6,"data6"));
		lt1.addByOrder(new Node(2,"data21"));
		lt1.addByOrder(new Node(4,"data4"));
		lt1.addByOrder(new Node(3,"data3"));
		lt1.addByOrder(new Node(5,"data5"));
		lt1.addByOrder(new Node(1,"data1"));
		lt1.addByOrder(new Node(2,"data22"));
		lt1.show();
		
		UnidirectionalLinkedTable lt2 = new UnidirectionalLinkedTable();
		lt2.addNode(new Node(6,"data6"));
		lt2.addNode(new Node(2,"data21"));
		lt2.addNode(new Node(4,"data4"));
		lt2.addNode(new Node(3,"data3"));
		lt2.addNode(new Node(5,"data5"));
		lt2.addNode(new Node(1,"data1"));
		lt2.addNode(new Node(2,"data22"));
		lt2.show();
		lt1.update(new Node(6,"data六"));
		lt1.show();
		lt1.getLength();
		lt1.reverse().show();
	}
}


