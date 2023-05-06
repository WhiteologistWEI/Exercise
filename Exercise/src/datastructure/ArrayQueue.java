package datastructure;

import java.util.Scanner;

public class ArrayQueue {

	int size=3;
	int f=-1;
	int r=-1;
	int[] q;
	int s=0; //0-�� 1-�� 2-����
	
	Scanner scan = new Scanner(System.in);
	
	void show() {
		if(isEmpty()) {
			System.out.println("����Ϊ��...");
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
			throw new RuntimeException("��������...");
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
			throw new RuntimeException("����Ϊ��...");
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
		System.out.println("��������г���...");
//		int l = scan.nextInt();
		q = new int[3];
		
		boolean exit = false;
		while(!exit) {
			System.out.println("=========================");
			System.out.println("s����ʾ����");
			System.out.println("e���˳�����");
			System.out.println("i�����");
			System.out.println("o������");
			
			char key = scan.next().charAt(0);
			switch (key) {
			case 's':
				this.show();
				break;
			case 'e':
				exit = true;
				scan.close();
				System.out.println(">>>>�������>>>>");
				break;
			case 'i':
					try {
						System.out.println("������Ԫ��...");
						int i = scan.nextInt();
						this.in(i);
					}catch (Exception e) {
						System.out.println(e.getMessage());
					}
				break;
			case 'o':
				try {
					int val = this.out();
					System.out.println("Ԫ��["+val+"]����...");
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
