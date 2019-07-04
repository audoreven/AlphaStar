package searchingandsorting;

import java.util.Arrays;
import java.util.Scanner;

public class Farmoff {
	/** static int pow(int base, int exp, int mod) {
		if (exp==0) {
			return 1;
		}
		return (base*pow(base, exp-1, mod))%mod;
	} **/
	
	 static long pow(long base, int exp, int mod) {
		if (exp==0) {
			return 1;
		}
	 	if (exp%2==0) {
	 		long half=pow(base, exp/2, mod);
	 		return (half*half)%mod;
	 	}
	 	long half=pow(base, exp/2, mod);
	 	return ((half*half%mod)*base)%mod;
	 } 
	
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		String[] temp=reader.nextLine().split(" ");
		int[] given=new int[10];
		for (int i=0; i<10; i++) {
			given[i]=Integer.parseInt(temp[i]);
		}
		int N=given[0];
		int a=given[1]; int b=given[2]; int c=given[3]; int d=given[4];
		int e=given[5]; int f=given[6]; int g=given[7]; int h=given[8];
		int M=given[9];
		Pair[] wu=new Pair[3*N];
		for (int i=0; i<3*N; i++) {
			int w=(int) ((a*pow(i,5,d))%d+ (b*pow(i,2,d))%d + (c*pow(i,0,d))%d)%d;
			int u=(int) ((e*pow(i,5, h))%h+ (f*pow(i,3, h))%h + (g*pow(i,0,h))%h)%h;
			wu[i]=new Pair(w, u);
		}
		Arrays.sort(wu);
		int combined=0;
		for (int i=N*3-1; i>N*2-1; i--) {
			combined=(combined+wu[i].weight)%M;
		}
		System.out.println(combined);
		reader.close();
	}
	
	static class Pair implements Comparable<Pair> {
		int weight, utility;
		public Pair(int x, int y){
			weight=x;
			utility=y;
		}
		
		public int compareTo(Pair p) {
			if (this.utility>p.utility) {
				return 1;
			}
			else if (this.utility==p.utility) {
				return 0;
			}
			else {
				return -1;
			}		
		}
		public String toString() {
			return ""+ this.utility;
		}
		
	}
}
