package datastructure;

import java.util.Scanner;

public class ArrayStack {

	int[] stack;
	int size;
	int top=-1;
	Scanner sc=new Scanner(System.in);

	public ArrayStack() {}

	public ArrayStack(int size) {
		this.size = size;
		stack=new int[size];
	}

	boolean isEmpty() {
		return top==-1;
	}
	
	boolean isFull() {
		return (top+1)==size;
	}
	
	ArrayStack push(int e) {
		if(isFull())
			throw new RuntimeException("ջ����...");
		
		System.out.println(">>>Ԫ��["+e+"]��ջ...");
		stack[++top]=e;
		return this;
	}
	
	int pop() {
		if(isEmpty())
			throw new RuntimeException("ջΪ��...");
		
		int e=stack[top--];
		System.out.println(">>>Ԫ��["+e+"]��ջ...");
		return e;
	}
	
	void show() {
		if(isEmpty())
			System.out.println("ջΪ��...");
		else {
			System.out.println(">>>>ջ��Ԫ��>>>>>");
			for(int i=top;i>-1;i--) {
				System.out.println(stack[i]);
			}
		}
	}
	
	void show1() {
		if(isEmpty())
			System.out.println("ջΪ��...");
		else {
			System.out.println(">>>>ջ��Ԫ��>>>>>");
			for(int i=top;i>-1;i--) {
				System.out.println((char)stack[i]);
			}
		}
	}
	
	int getTop() {
		return stack[top];
	}
	
	void menu() {
		System.out.println("������ջ����...");
		int s=sc.nextInt();
		this.size=s;
		stack=new int[size];
		
		boolean exit = false;
		while(!exit) {
			System.out.println("=========================");
			System.out.println("s����ʾ����");
			System.out.println("e���˳�����");
			System.out.println("i�����");
			System.out.println("o������");
			
			char key = sc.next().charAt(0);
			switch (key) {
			case 's':
				this.show();
				break;
			case 'e':
				exit = true;
				sc.close();
				System.out.println(">>>>�������>>>>");
				break;
			case 'i':
					try {
						System.out.println("������Ԫ��...");
						int i = sc.nextInt();
						this.push(i);
					}catch (Exception e) {
						System.out.println(e.getMessage());
					}
				break;
			case 'o':
				try {
					this.pop();
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;
			case 'c':
				System.out.println("��������ʽ...");
				String exp=sc.next();
				this.calculateMedium(exp);

				break;

			default:
				break;
			}
		}
	}
	
	void calculateMedium(String exp) {
		char[] chs=exp.toCharArray();
		int size=exp.length();
		
		ArrayStack ns=new ArrayStack(50);
		ArrayStack os=new ArrayStack(50);
		
		for(int i=0;i<size;i++) {
			String number="";
			char c=chs[i];
			if(!isOpe(c)) {
				number+=c;

				if(i==size-1||isOpe(chs[i+1])) {
					ns.push(Integer.parseInt(number));
					number="";
				}				
			} else {
				if(os.isEmpty())
					os.push(c);
				else {
					char ope=(char)os.getTop();	// ջ�ڷ���
					if(this.getPriority(c)<=this.getPriority(ope)) {
						int n2=ns.pop();
						int n1=ns.pop();
						os.pop();
						int res=this.calculate(n1, n2, ope);
						os.push(c);
						ns.push(res);
					}else {
						os.push(c);
					}
				}
			}
				
		}
		
		int n1;
		int n2;
		int res=0;
		char ope;
		System.out.println("��ʼ��ջ����.");
		ns.show();
		System.out.println("----------");
		os.show1();
		while(!os.isEmpty()) {
			n2=ns.pop();
			n1=ns.pop();
			ope=(char)os.pop();
			res=this.calculate(n1, n2, ope);
			ns.push(res);
		}
		System.out.println("��������"+res);
	}
	
	int getPriority(char ope) {
		if(ope=='*'||ope=='/')
			return 1;
		else
			return 0;
	}
	
	/**
	 * 
	 * @param n1 ����ջ�׵���
	 * @param n2 ����ջ������
	 * @param ope
	 * @return
	 */
	int calculate(int n1, int n2, int ope) {
		int res=0;
		switch (ope) {
		case '+':
			res=n1+n2;
			break;
		case '-':
			res=n1-n2;
			break;
		case '*':
			res=n1*n2;
			break;
		case '/':
			res=n1/n2;
			break;

		default:
			break;
		}
		
		return res;
	}
	
	boolean isOpe(char c) {
		return c=='+'||c=='-'||c=='*'||c=='/';
	}
	
	void calc() {
		System.out.println("��������ʽ...");
		String exp=sc.next();
		this.calculateMedium(exp);
	}
	
	public static void main(String[] args) {
		new ArrayStack().calc();
		//.menu();
	}
}
