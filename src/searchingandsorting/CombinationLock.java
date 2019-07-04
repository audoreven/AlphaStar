package searchingandsorting;

import java.util.Scanner;

public class CombinationLock {
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		int N=Integer.parseInt(reader.nextLine());
		int[] combo=new int[3];
		int[] mc=new int[3];
		String[] temp=reader.nextLine().split(" ");
		for (int i=0; i<temp.length; i++) {
			combo[i]=Integer.parseInt(temp[i]);
		}
		String[] temp2=reader.nextLine().split(" ");
		for (int i=0; i<temp2.length; i++) {
			mc[i]=Integer.parseInt(temp2[i]);
		}
		if (N<=5) {
			System.out.println(N*N*N);
		}
		else {
			System.out.println(250-overlap(combo, mc, N));
		}
		reader.close();
	}
	
	static int overlap(int[] combo1, int[] combo2, int N){
		int x=0;
		int y=0;
		int z=0;
		if (Math.abs(combo1[0]-combo2[0])<5 || Math.abs(combo1[0]-combo2[0])>N-2) {
			x=5-Math.abs(combo1[0]-combo2[0]);
			if (combo1[0]+combo2[0]>N) {
				if (combo1[0]>N/2) {
					combo1[0]=combo1[0]-N;
				}
				else if (combo2[0]>N/2) {
					combo2[0]=combo2[0]-N;
				}
				x=5-Math.abs(combo1[0]-combo2[0]);
			}
		}
		if (Math.abs(combo1[1]-combo2[1])<5 || Math.abs(combo1[1]-combo2[1])>N-2) { 
			y=5-Math.abs(combo1[1]-combo2[1]);
			if (combo1[1]+combo2[1]>N) {
				if (combo1[1]>N/2) {
					combo1[1]=combo1[1]-N;
				}
				else if (combo2[1]>N/2) {
					combo2[1]=combo2[1]-N;
				}
				x=5-Math.abs(combo1[1]-combo2[1]);
			}
		}
		if (Math.abs(combo1[2]-combo2[2])<5 || Math.abs(combo1[2]-combo2[2])>N-2) {
			z=5-Math.abs(combo1[2]-combo2[2]);
			if (combo1[2]+combo2[2]>N) {
				if (combo1[2]>N/2) {
					combo1[2]=combo1[2]-N;
				}
				else if (combo2[2]>N/2) {
					combo2[2]=combo2[2]-N;
				}
				x=5-Math.abs(combo1[2]-combo2[2]);
			}
		}
		return x*y*z;
	}
}
