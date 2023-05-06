package datastructure;

import java.util.LinkedList;
import java.util.Scanner;

public class RingLinkedTable {

	int no;
	String data;
	Node first;
	int size;
//	UnidirectionalLinkedTable t=new UnidirectionalLinkedTable();
	LinkedList<Node> l=new LinkedList<>();
	Scanner sc= new Scanner(System.in);
	
	public RingLinkedTable(int no) {
		this.no=no;
		this.data="data"+no;
	}
	
	public RingLinkedTable() {
		
	}
	
	RingLinkedTable add(int n) {
		this.add(new Node(n));
		return this;
	}
	
	RingLinkedTable add(Node n) {
		if(null==first) {
			first=n;
			n.next=first;
		}
		else {
			Node p=first;
			while(p.next!=first) {
				p=p.next;
			}
			p.next=n;
			n.next=first;
		}
		this.size++;	
		
		return this;
	}
	
	Node getLast() {
		Node p=first;
		while(p.next!=first) {
			p=p.next;
		}
		return p;
		
	}
	
	void out(int no) {
		if(first==null)
			throw new RuntimeException("队列为空...");
		else {
			Node prev=this.getLast();
			boolean end=false;
			while(!end) {
				if(first.next==first) {
					l.add(first);
					System.out.println(first+"（最后值）出队...");
					first=null;
					
					end= true;
				}else {	
					for(int i=0;i<no-1;i++) {
						first=first.next;
						prev=prev.next;
						
					}
					System.out.print(first+"出队...");
					l.add(first);

					first=first.next;
					prev.next=first;
				}
			}
			
		}
	}
	
	void outAll(int no) {
		System.out.println("全部出队...");
		boolean con=true;
		while(con) {
//			con=this.out(no);
		}
	}
	
	void showOut() {
		System.out.println("出队顺序...");
		for(Node n:l) {
			System.out.print(n);
		}
	}
	
	void show() {
		if(first==null)
			System.out.println("队列为空...");
		else {
			Node p=first;
			do {
				System.out.print(p);
				p=p.next;
			}while(p!=first);
			System.out.println();
		}
	}
	
	//24153
	void menu() {
		boolean exit=false;
		while(!exit) {
			System.out.println(">>>>>>>>>>>>\n菜单....");
			
			char key=sc.next().charAt(0);
			switch (key) {
			case 'a':
				System.out.println("请输入序号...");
				int noi=sc.nextInt();
				this.add(new Node(noi));
				break;
			case 's':
				this.show();
				break;
			case 'e':
				sc.close();
				exit=true;
				System.out.println("程序退出...");
				break;
			case 'o':
				System.out.println("请输入序号...");
				int noo=sc.nextInt();
				this.out(noo);
				break;
			case 't':
				this.showOut();
				break;


				
			default:
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		new RingLinkedTable().add(1).add(2)
		.add(3).add(4).add(5)
		.menu();
	}
}
