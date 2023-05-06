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
			throw new RuntimeException("栈已满...");
		
		System.out.println(">>>元素["+e+"]入栈...");
		stack[++top]=e;
		return this;
	}
	
	int pop() {
		if(isEmpty())
			throw new RuntimeException("栈为空...");
		
		int e=stack[top--];
		System.out.println(">>>元素["+e+"]出栈...");
		return e;
	}
	
	void show() {
		if(isEmpty())
			System.out.println("栈为空...");
		else {
			System.out.println(">>>>栈中元素>>>>>");
			for(int i=top;i>-1;i--) {
				System.out.println(stack[i]);
			}
		}
	}
	
	void show1() {
		if(isEmpty())
			System.out.println("栈为空...");
		else {
			System.out.println(">>>>栈中元素>>>>>");
			for(int i=top;i>-1;i--) {
				System.out.println((char)stack[i]);
			}
		}
	}
	
	int getTop() {
		return stack[top];
	}
	
	void menu() {
		System.out.println("请输入栈长度...");
		int s=sc.nextInt();
		this.size=s;
		stack=new int[size];
		
		boolean exit = false;
		while(!exit) {
			System.out.println("=========================");
			System.out.println("s：显示队列");
			System.out.println("e：退出队列");
			System.out.println("i：入队");
			System.out.println("o：出队");
			
			char key = sc.next().charAt(0);
			switch (key) {
			case 's':
				this.show();
				break;
			case 'e':
				exit = true;
				sc.close();
				System.out.println(">>>>程序结束>>>>");
				break;
			case 'i':
					try {
						System.out.println("请输入元素...");
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
				System.out.println("请输入表达式...");
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
					char ope=(char)os.getTop();	// 栈内符号
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
		System.out.println("开始出栈计算.");
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
		System.out.println("计算结果："+res);
	}
	
	int getPriority(char ope) {
		if(ope=='*'||ope=='/')
			return 1;
		else
			return 0;
	}
	
	/**
	 * 
	 * @param n1 靠近栈底的数
	 * @param n2 靠近栈顶的数
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
		System.out.println("请输入表达式...");
		String exp=sc.next();
		this.calculateMedium(exp);
	}
	
	public static void main(String[] args) {
		new ArrayStack().calc();
		//.menu();
	}
}
