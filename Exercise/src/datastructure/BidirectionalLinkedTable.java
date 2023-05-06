package datastructure;

public class BidirectionalLinkedTable {

	BiNode head=new BiNode(0,"");
	
	BidirectionalLinkedTable add(BiNode bn) {
		BiNode p= head;
		while(p.next!=null) {
			p=p.next;
		}
		p.next=bn;
		bn.prev=p;
		return this;
	}
	
	
	BidirectionalLinkedTable update(BiNode bn) {
		if(head.next==null)
			throw new RuntimeException("列表为空...");
		
		BiNode p= head.next;
		while(p!=null) {
			if(p.no==bn.no) {
				break;
			}
			if(p.next==null) {
				throw new RuntimeException("未找到对应节点..."); 
			}
			p=p.next;
		}
		p.data=bn.data;
		
		return this;
	}
	
	BidirectionalLinkedTable delete(int i) {
		if(head.next==null)
			throw new RuntimeException("列表为空...");
		
		BiNode p= head.next;
		while(p!=null) {
			if(p.no==i) {
				break;
			}
			if(p.next==null) {
				throw new RuntimeException("未找到对应节点..."); 
			}
			p=p.next;
		}
		p.prev.next=p.next;
		if(p.next!=null)
			p.next.prev=p.prev;
		
		return this;
	}
	
	void show() {
		BiNode p= head.next;
		while(p!=null) {
			System.out.print("→"+p);
			p=p.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		BidirectionalLinkedTable blb = new BidirectionalLinkedTable();
		BiNode bn1 = new BiNode(1, "data1");
		BiNode bn2 = new BiNode(2, "data2");
		BiNode bn3 = new BiNode(3, "data3");
		BiNode bn4 = new BiNode(4, "data4");
		BiNode bn5 = new BiNode(5, "data5");
		blb.add(bn5).add(bn4)
			.add(bn3).add(bn2).add(bn1).show();
		blb.update(new BiNode(2, "数据二")).delete(3)
			.show();
		
	}
	
	
}

class BiNode{
	int no;
	String data;
	BiNode next;
	BiNode prev;
	
	public BiNode(int no, String data) {
		this.no=no;
		this.data=data;
	}

	@Override
	public String toString() {
		return "[No" + no + ", " + data + "]";
	}
	
}
