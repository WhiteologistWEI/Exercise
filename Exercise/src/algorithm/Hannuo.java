package algorithm;

import java.util.Scanner;

public class Hannuo {

	static char A='A';
	static char B='B';
	static char C='C';
	
	
	void hannuo(int n, char from, char to) {
		if(n==1) {
			move(1,A,C);
		}else {
			hannuo(n-1, A,B );
			move(n,A,C);
			hannuo(n-1,B,C);
		}
	}
	
	
	
	void move(int n, char from, char to) {
		System.out.println("["+n+"]��"+from+">>>>"+to);
	}
	
	/**
	 * �����ǿ����õ�
	 * @param n
	 * @param from
	 * @param medi
	 * @param to
	 */
	void moveAC(int n, char from, char medi, char to) {
		if(n==1)
			System.out.println("["+n+"]��"+from+">>>>"+to);
		else {
			this.moveAC(n-1, from, to, medi);
			System.out.println("["+n+"]��"+from+">>>>"+to);
			this.moveAC(n-1, to, medi, from);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Hannuo h = new Hannuo();
		while(true) {
			System.out.println("������������");
			int n=sc.nextInt();
			if(n==0)
				break;
			h.moveAC(n, 'A', 'B', 'C');
		}
		sc.close();
	}
}
