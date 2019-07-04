package searchingandsorting;

import java.util.Scanner;

public class Leprechaun {
	int[] dx={1,-1,1,0};
	int[] dy={1,1,0,1};
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		int n=Integer.parseInt(reader.nextLine());
		int[][] grid=new int[n][n];
		for (int i=0; i<n; i++) {
			String[] temp=reader.nextLine().split(" ");
			int[] in=new int[n];
			for (int j=0; j<n; j++) {
				in[j]=Integer.parseInt(temp[j]);
			}
			grid[i]=in;
		}
		
		reader.close();
	}
}
