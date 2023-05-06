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
			throw new RuntimeException("����Ϊ��...");
		else {
			Node prev=this.getLast();
			boolean end=false;
			while(!end) {
				if(first.next==first) {
					l.add(first);
					System.out.println(first+"�����ֵ������...");
					first=null;
					
					end= true;
				}else {	
					for(int i=0;i<no-1;i++) {
						first=first.next;
						prev=prev.next;
						
					}
					System.out.print(first+"����...");
					l.add(first);

					first=first.next;
					prev.next=first;
				}
			}
			
		}
	}
	
	void outAll(int no) {
		System.out.println("ȫ������...");
		boolean con=true;
		while(con) {
//			con=this.out(no);
		}
	}
	
	void showOut() {
		System.out.println("����˳��...");
		for(Node n:l) {
			System.out.print(n);
		}
	}
	
	void show() {
		if(first==null)
			System.out.println("����Ϊ��...");
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
			System.out.println(">>>>>>>>>>>>\n�˵�....");
			
			char key=sc.next().charAt(0);
			switch (key) {
			case 'a':
				System.out.println("���������...");
				int noi=sc.nextInt();
				this.add(new Node(noi));
				break;
			case 's':
				this.show();
				break;
			case 'e':
				sc.close();
				exit=true;
				System.out.println("�����˳�...");
				break;
			case 'o':
				System.out.println("���������...");
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
