package datastructure;

import java.util.Scanner;

public class ArrayQueue {

	int size=3;
	int f=-1;
	int r=-1;
	int[] q;
	int s=0; //0-空 1-满 2-其他
	
	Scanner scan = new Scanner(System.in);
	
	void show() {
		if(isEmpty()) {
			System.out.println("队列为空...");
		}else {
			
			int begin = (f+size+1)%size;
			int end = (r+size-f)%size;
			
			System.out.println("front: "+f+"rear: "+r+"begin: "+begin+"end: "+end);
			if(begin==end)
				end=size+end-1;
			System.out.print("|");
			for(int i=begin;i<=end;i++) {
				System.out.print(q[i%size]+"|");
			}
			
			System.out.println();
		}
	}
	
	boolean isEmpty() {
		return s==0;
	}
	
	boolean isFull() {
		return s==1;
	}
	
	void in(int i) {
		if(isFull()) {
			throw new RuntimeException("队列已满...");
		}else {
			r = (r+size+1)%size;
			System.out.println("==="+r+"===");
			q[r]=i;
			
			if(r%size==(f+size)%size)
				s=1;
			else
				s=2;
		}
	}
	
	int out() {
		if(isEmpty()) {
			throw new RuntimeException("队列为空...");
		}else {
			f = (f+size+1)%size;
			
			if(f%size==(r+size)%size)
				s=0;
			else
				s=2;
			
			return q[f];
		}
	}
	
	void menu() {
		System.out.println("请输入队列长度...");
//		int l = scan.nextInt();
		q = new int[3];
		
		boolean exit = false;
		while(!exit) {
			System.out.println("=========================");
			System.out.println("s：显示队列");
			System.out.println("e：退出队列");
			System.out.println("i：入队");
			System.out.println("o：出队");
			
			char key = scan.next().charAt(0);
			switch (key) {
			case 's':
				this.show();
				break;
			case 'e':
				exit = true;
				scan.close();
				System.out.println(">>>>程序结束>>>>");
				break;
			case 'i':
					try {
						System.out.println("请输入元素...");
						int i = scan.nextInt();
						this.in(i);
					}catch (Exception e) {
						System.out.println(e.getMessage());
					}
				break;
			case 'o':
				try {
					int val = this.out();
					System.out.println("元素["+val+"]出队...");
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;

			default:
				break;
			}
		}
	}
	public static void main(String[] args) {
		new ArrayQueue().menu();
	}
}
