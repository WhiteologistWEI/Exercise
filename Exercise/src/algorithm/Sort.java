package algorithm;

import java.util.Arrays;
import java.util.Random;

public class Sort {
	
	static int c=0;
	
	/**
	 * 交换排序-冒泡排序<br>
	 * 注意事项：每一轮排序时，循环从次数少1
	 */
	static void bubble(int[] a) {
		int size=a.length;
		int temp; // 用于交换的临时变量
		for(int j=0;j<size;j++) {
			for(int i=0;i<size-1-j;i++) {
				if(a[i]>a[i+1]) {
					temp=a[i];
					a[i]=a[i+1];
					a[i+1]=temp;
				}
			}
			// 第i轮排序结束后，第i大的元素就会被交换到倒数第i位
			System.out.println("第"+(j+1)+"轮排序结果："+Arrays.toString(a));
		}
	}
	
	/**
	 * 简单选择排序<br>
	 * 注意事项：外侧循环次数为数组长度减一
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
			System.out.println("第"+(i+1)+"轮排序结果："+Arrays.toString(a));
		}
	}
	
	/**
	 * 直接插入排序<br>
	 * 将数组分为有序区和无序区
	 * @param arr
	 */
	static void directInsert(int[] arr) {
		// 有序区初始长度为1、初始元素下标为0，因此无序区指针从下标1开始
		for(int i=1;i<arr.length;i++) {
			int beingInsertedElement = arr[i]; // 无序区中待插入到有序区的元素
			
			int j=i-1;	// 有序区的指针，从后向前遍历有序区
			/*
			 * 有序区停止遍历的条件：
			 * a.指针遍历完有序区的第一位
			 * b.待插入元素找到小于等于它的元素
			 */
			while(!(j < 0 || arr[j] <= beingInsertedElement)) {
				// 如果没找到元素，则将当前位置及之后的有序区元素后移一位
				arr[j+1] = arr[j];
				j--;
			}
			
			/*
			 * 有序区遍历停止时指针（j）指向的元素时第一个比待插入元素小的元素
			 * 因此待插入元素应该插入的位置时j+1
			 */
			arr[j+1] = beingInsertedElement;
		}
	}
	
	/**
	 * 希尔插入排序（移位式）
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
	 * 快速排序-同时交换
	 * @param left
	 * @param right
	 */
	static void fastSort(int[] a, int left, int right) {
		int l=left;
		int r=right;

		if(l>=r)
			return;
		
		int baseValue = a[l];	// 选取数组的第一个元素作为基准值
		
		/*
		 * 从左右两侧同时遍历，每当左右分别找到一个比基准值大、小的数值时，将他们交换
		 * 目的是在遍历后，找到基准值的位置，并让左侧都小于基准值，右侧都大于基准值
		 * 分别对基准值左右两侧数组进行同样的操作，知道数组中只剩下一个数
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
			System.out.println("数组中元素...");
		else
			System.out.println("【排序后】数组中元素...");
		for(int i:a) {
			System.out.print(i+"，");
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
	 * 快速排序-轮流交换
	 * @param s
	 * @param l
	 * @param r
	 */
	static void quickSort(int s[], int l, int r)
	{
	    if (l < r)
	    {
	        //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
	        int i = l, j = r, x = s[l];
	        while (i < j)
	        {
	            while(i < j && s[j] >= x) // 从右向左找第一个小于x的数
	                j--;  
	            if(i < j) 
	                s[i++] = s[j];
	            
	            while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数
	                i++;  
	            if(i < j) 
	                s[j--] = s[i];
	        }
	        s[i] = x;
	        quickSort(s, l, i - 1); // 递归调用 
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
	 * 归并排序<br>
	 * 使用递归的方法通常由两部分组成：<br>
	 * 负责递归的方法（此处是mergeSort）<br>
	 * 以及负责操作的的方法（此处是merge），此方法需要输入参数来确定需要操作的内容
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
		
		int li=l; 		// 左半侧数组的指针
		int ri=m+1; 	// 右半侧数组的指针
		int ti=0;		// 临时数组的起始下标		
		int[] t = new int[r-l+1];	// 为临时数组分配内存
		
		/*
		 * 同时遍历左半边和右半边，将较小的元素放到临时数组中
		 * 遍历结束后，临时数组中的数按升序排列
		 */
		while(li<=m && ri<=r) {
			if(a[li]>a[ri]) 
				t[ti++]=a[ri++];
			else
				t[ti++]=a[li++];
		}
		
		/*
		 * 存在一种情况，其中一边的数组遍历完并将元素放入临时数组后，
		 * 另一版本元素依然有没有放入到临时数组的元素，
		 * 需要将剩余元素放到临时数组中
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
