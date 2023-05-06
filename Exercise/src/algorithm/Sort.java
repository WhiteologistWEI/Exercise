package algorithm;

import java.util.Arrays;
import java.util.Random;

public class Sort {
	
	static int c=0;
	
	/**
	 * ��������-ð������<br>
	 * ע�����ÿһ������ʱ��ѭ���Ӵ�����1
	 */
	static void bubble(int[] a) {
		int size=a.length;
		int temp; // ���ڽ�������ʱ����
		for(int j=0;j<size;j++) {
			for(int i=0;i<size-1-j;i++) {
				if(a[i]>a[i+1]) {
					temp=a[i];
					a[i]=a[i+1];
					a[i+1]=temp;
				}
			}
			// ��i����������󣬵�i���Ԫ�ؾͻᱻ������������iλ
			System.out.println("��"+(j+1)+"����������"+Arrays.toString(a));
		}
	}
	
	/**
	 * ��ѡ������<br>
	 * ע��������ѭ������Ϊ���鳤�ȼ�һ
	 * @param a
	 */
	static void simpleSelect(int[] a) {
		int min;
		int an=0;
		for(int i=0;i<a.length-1;i++) {
			min=a[i];
			for(int j=i+1;j<a.length;j++) {
				if(min>a[j]) {
					min=a[j];
					an=j;
				}
			}
			a[an]=a[i];
			a[i]=min;
			System.out.println("��"+(i+1)+"����������"+Arrays.toString(a));
		}
	}
	
	/**
	 * ֱ�Ӳ�������<br>
	 * �������Ϊ��������������
	 * @param arr
	 */
	static void directInsert(int[] arr) {
		// ��������ʼ����Ϊ1����ʼԪ���±�Ϊ0�����������ָ����±�1��ʼ
		for(int i=1;i<arr.length;i++) {
			int beingInsertedElement = arr[i]; // �������д����뵽��������Ԫ��
			
			int j=i-1;	// ��������ָ�룬�Ӻ���ǰ����������
			/*
			 * ������ֹͣ������������
			 * a.ָ��������������ĵ�һλ
			 * b.������Ԫ���ҵ�С�ڵ�������Ԫ��
			 */
			while(!(j < 0 || arr[j] <= beingInsertedElement)) {
				// ���û�ҵ�Ԫ�أ��򽫵�ǰλ�ü�֮���������Ԫ�غ���һλ
				arr[j+1] = arr[j];
				j--;
			}
			
			/*
			 * ����������ֹͣʱָ�루j��ָ���Ԫ��ʱ��һ���ȴ�����Ԫ��С��Ԫ��
			 * ��˴�����Ԫ��Ӧ�ò����λ��ʱj+1
			 */
			arr[j+1] = beingInsertedElement;
		}
	}
	
	/**
	 * ϣ������������λʽ��
	 * @param a
	 */
	static void shellInsert(int[] a) {
		int step=a.length/2;
		while(step>=1) {
			
			for(int k=0;k<step;k++){
				for(int i=k+step;i<a.length;i+=step) {
					int e=a[i];
					int j=i-step;
					while(j>=0&&e<a[j]) {
						a[j+step]=a[j];
						j-=step;
					}
					a[j+step]=e;
				}
			}
			step=step/2;
		}
	}
	
	static void fastSort(int[] a) {
		fastSort(a, 0, a.length-1);
	}
	
	/**
	 * ��������-ͬʱ����
	 * @param left
	 * @param right
	 */
	static void fastSort(int[] a, int left, int right) {
		int l=left;
		int r=right;

		if(l>=r)
			return;
		
		int baseValue = a[l];	// ѡȡ����ĵ�һ��Ԫ����Ϊ��׼ֵ
		
		/*
		 * ����������ͬʱ������ÿ�����ҷֱ��ҵ�һ���Ȼ�׼ֵ��С����ֵʱ�������ǽ���
		 * Ŀ�����ڱ������ҵ���׼ֵ��λ�ã�������඼С�ڻ�׼ֵ���Ҳ඼���ڻ�׼ֵ
		 * �ֱ�Ի�׼ֵ���������������ͬ���Ĳ�����֪��������ֻʣ��һ����
		 */
		while(l<r) {
			while(l<r&&a[r]>baseValue)
				r--;
			while(l<r&&a[l]<=baseValue)
				l++;
			if(l<r) {
				int temp=a[l];
				a[l--]=a[r];
				a[r--]=temp;
			}
		}
		
		a[left]=a[l];
		a[l]=baseValue;
//		show(a,'h');

		fastSort(a, left, l-1);
		fastSort(a, l+1, right);
	}
	
	static void show(int[] a, char mode) {
		if(mode=='q')
			System.out.println("������Ԫ��...");
		else
			System.out.println("�������������Ԫ��...");
		for(int i:a) {
			System.out.print(i+"��");
		}
		System.out.println();
	}
	
	static int[] generateArray(int s) {
		int[] arr=new int[s];
		Random r=new Random();
		for(int i=0;i<s;i++) {
			int val = r.nextInt(10*s) - 5*s;
			arr[i]=val;
		}
		return arr;
	}
	
	/**
	 * ��������-��������
	 * @param s
	 * @param l
	 * @param r
	 */
	static void quickSort(int s[], int l, int r)
	{
	    if (l < r)
	    {
	        //Swap(s[l], s[(l + r) / 2]); //���м��������͵�һ�������� �μ�ע1
	        int i = l, j = r, x = s[l];
	        while (i < j)
	        {
	            while(i < j && s[j] >= x) // ���������ҵ�һ��С��x����
	                j--;  
	            if(i < j) 
	                s[i++] = s[j];
	            
	            while(i < j && s[i] < x) // ���������ҵ�һ�����ڵ���x����
	                i++;  
	            if(i < j) 
	                s[j--] = s[i];
	        }
	        s[i] = x;
	        quickSort(s, l, i - 1); // �ݹ���� 
	        quickSort(s, i + 1, r);
	    }
	}
	
	static void Quick_Sort(int[] a, int left, int right){
	    if(left > right)
	        return;
	    int tmp = a[left];
	    int l = left;
	    int r = right;
	    while(l != r){
	        while(a[r] >= tmp && r > l)
	            r--;
	        while(a[l] <= tmp && r > l)
	            l++;
	        if(r > l){
	            int t = a[l];
	            a[l] = a[r];
	            a[r] = t;
	        }
	    }
	    a[left] = a[l];
	    a[l] = tmp;
	    Quick_Sort(a, left, l-1);
	    Quick_Sort(a, l+1, right);
	}


	/**
	 * �鲢����<br>
	 * ʹ�õݹ�ķ���ͨ������������ɣ�<br>
	 * ����ݹ�ķ������˴���mergeSort��<br>
	 * �Լ���������ĵķ������˴���merge�����˷�����Ҫ���������ȷ����Ҫ����������
	 * @param a
	 * @param l
	 * @param r
	 */
	static void mergeSort(int[] a, int l, int r) {
		if(l<r) {
			int m = (l+r)/2;
			mergeSort(a, l, m);
			mergeSort(a, m+1, r);
			merge(a,l,r,m);
		}
	}
	
	static void merge(int[] a, int l, int r, int m) {
		
		int li=l; 		// ���������ָ��
		int ri=m+1; 	// �Ұ�������ָ��
		int ti=0;		// ��ʱ�������ʼ�±�		
		int[] t = new int[r-l+1];	// Ϊ��ʱ��������ڴ�
		
		/*
		 * ͬʱ�������ߺ��Ұ�ߣ�����С��Ԫ�طŵ���ʱ������
		 * ������������ʱ�����е�������������
		 */
		while(li<=m && ri<=r) {
			if(a[li]>a[ri]) 
				t[ti++]=a[ri++];
			else
				t[ti++]=a[li++];
		}
		
		/*
		 * ����һ�����������һ�ߵ���������겢��Ԫ�ط�����ʱ�����
		 * ��һ�汾Ԫ����Ȼ��û�з��뵽��ʱ�����Ԫ�أ�
		 * ��Ҫ��ʣ��Ԫ�طŵ���ʱ������
		 */
		while(li<=m)
			t[ti++]=a[li++];
		while(ri<=r)
			t[ti++]=a[ri++];
		
		show(t,'h');
		for(ti=0;ti<r-l+1;ti++)
			a[ti+l]=t[ti];
	}

	static void radixSort(int[] a) {
		
	}
	
	public static void main(String[] args) {
//		int[] a=new int[] {1,-3,8,2,9};
		for(int i=0;i<3;i++) {
			int[] a=generateArray(7);
			show(a,'q');
//			bubble(a);
//			simpleSelect(a);
//			directInsert(a);
//			shellInsert(a);
//			fastSort(a);
//			mergeSort(a, 0, 6);
//			Quick_Sort(a,0,a.length-1);
			show(a,'h');
			
		}
	}
}
