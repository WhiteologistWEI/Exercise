package datastructure;

import java.util.Scanner;

public class RingArrayQueue {

	int size;
	int front;
	int rear;
	int[] q;
	
	Scanner sc=new Scanner(System.in);
	
	boolean isEmpty() {
		return front==rear;
	}
	
	boolean isFull() {
		return (rear+1)%size==front;
	}
	
	RingArrayQueue in(int i) {
		if(isFull())
			throw new RuntimeException("队列已满...");
		
		q[rear]=i;
		rear=(rear+1)%size;
		
		return this;
	}
	
	int out() {
		int e;
		
		if(isEmpty()) 
			throw new RuntimeException("队列为空...");
		
		e=q[front];
		front=(front+1)%size;
		
		System.out.println("元素["+e+"]出队...");
		return e;
	}
	
	void show() {
		if(isEmpty())
			System.out.println("队列为空...");
		else {
			System.out.print("|");
			for(int i=front;i<front+(rear+size-front)%size;i++) {
				System.out.print(q[i%size]+"|");
			}
			System.out.println();
		}
	}
	
	void menu() {
		System.out.println("请输入队列长度...");
		size=sc.nextInt()+1;
		q=new int[size];
		
		boolean exit=false;
		while(!exit) {
			System.out.println(">>>>>>>菜单>>>>>>>");
			System.out.println("s");
			System.out.println("e");
			System.out.println("i");
			System.out.println("o");
			
			char key=sc.next().charAt(0);
			switch (key) {
			case 's':
				this.show();
				break;
			case 'e':
				sc.close();
				System.out.println("程序结束...");
				exit=true;
				break;
			case 'i':
				System.out.println("请输入要入队的元素...");
				int e=sc.nextInt();
				try {
					this.in(e);
				} catch (Exception e2) {
					System.out.println("警告！"+e2.getMessage());
				}
				break;
			case 'o':
				try {
					this.out();
				}catch(Exception e2) {
					System.out.println("警告！"+e2.getMessage());
				}
				break;

			default:
				break;
			}
			
		}
	}
	
	public static void main(String[] args) {
		new RingArrayQueue().menu();
	}
}
