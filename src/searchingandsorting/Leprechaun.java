package searchingandsorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Leprechaun {
	static int[] dx = { 1, -1, 0, 1 };
	static int[] dy = { 1, 1, 1, 0 };
	static int move(int[][] grid) {
		// vertical & diag 
		int large=-1000000;
		int[] numbers=new int[grid.length];
		for(int i=0; i<grid.length; i++) {
			for (int j=0; j<3; j++) {
				 int mx=i; int my=0;
				for (int k=0; k<grid.length; k++) {
					numbers[k]=grid[mx][my];
					mx=dx[j]+mx;
					my=dy[j]+my;
					if (mx<0) {
						mx=grid.length-1;
					}
					else if (mx==grid.length) {
						mx=0;
					}
					else if (my==grid.length) {
						my=0;
					}
					else if (mx<0) {
						my=grid.length-1;
					}
				}
				large=Math.max(largest(numbers), large);
			}
		}
		// hori
		for (int i=0; i<grid.length; i++) {
			large=Math.max(largest(grid[i]), large);
		}
		return large;
	}
	
	static int largest(int[] num) {
		int max=0; int sum=0;
		// find max
		for (int i=1; i<num.length; i++) {
			if (num[max]<num[i]) {
				max=i;
			}
		}
		sum=num[max];
		int p=max; int q=max; int pcount=0;
		while (num[p]>0 && pcount<num.length) {
			if (p!=max) {
				sum=sum+num[p];
			}
			p--;
			if (p==-1) {
				p=num.length-1;
			}
			pcount++;
		}
		while (num[q]>0 && q!=p) {
			if (q!=max) {
				sum=sum+num[q];
			}
			q++;
			if (q==num.length) {
				q=0;
			}
		} 
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		// #done with grid ;-;;
		int[][] grid = new int[n][n];
		for (int i = 0; i < n; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				grid[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int sum=move(grid);
		System.out.println(sum);
	}
}

