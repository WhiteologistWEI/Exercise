package datastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SparseArray {
	int s=5;
	int[][] t=new int[s][s];
	int[][] zt=new int[s+1][3];
	static final String INPUT_PATH="";
	static final String OUTPUT_PATH="C://办公资料//sdata.txt";
	
	
	
	public SparseArray() {
		t[2][4]=1;
		t[1][0]=1;
		t[3][3]=2;
		t[4][4]=2;
		t[0][2]=2;
	}
	
	void show(int key) {
		if(key==1) {
			System.out.println(">>>>>>>原表>>>>>>>");
			for(int i=0;i<s;i++) {
				for(int j=0;j<s;j++) {
					System.out.print(t[i][j]+" ");
				}
				System.out.println();
			}
		}else {
			System.out.println(">>>>>>>压缩表>>>>>>>");
			for(int i=0;i<s+1;i++) {
				for(int j=0;j<3;j++) {
					System.out.print(zt[i][j]+" ");
				}
				System.out.println();
			}
		}
		

	}
	
	void zip() {
		zt[0][0]=0;
		zt[0][1]=s;
		zt[0][2]=s;
		
		int it=1;
		for(int i=0;i<s;i++) {
			for(int j=0;j<s;j++) {
				if(t[i][j]!=0) {
					zt[it][0]=t[i][j];
					zt[it][1]=i;
					zt[it][2]=j;
					it++;
				}
			}
		}
	}
	
	void load() throws IOException {
		FileInputStream input=new FileInputStream(INPUT_PATH);
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		
	}
	
	void save() throws IOException {
		FileOutputStream output=new FileOutputStream(OUTPUT_PATH);
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(output,"GBK"));
		
		for(int i=0;i<s+1;i++) {
			for(int j=0;j<3;j++) {
				writer.write(zt[i][j]);
			}
			writer.write("\n");
		}
		
		writer.close();
		output.close();
	}
	
	public static void main(String[] args) throws IOException {
		SparseArray s = new SparseArray();
		s.show(1);
		s.zip();
		s.show(2);
		s.save();
	}
}
