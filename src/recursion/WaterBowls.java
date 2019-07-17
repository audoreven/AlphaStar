package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WaterBowls {
	// 
	static int number1s=0;
	static void toggle(int i, int[] bowls) {
		if (bowls[i]==0) {
			number1s++;
			bowls[i]=1;
		} else {
			number1s--;
			bowls[i]=0;
		}
		
	}
	static int n=numberOfPossibilities(20);
	static int f(int[] bowls) {
		int least=20; int flip=0;
		for (int j=0; j<n; j++) {
			int[] flips=convertBinary(j, 20);
			// toggle
			for (int i=0; i<19; i++) {
				if (flips[i]==1) {
					flip++;
					toggle(i, bowls);
					toggle(i+1, bowls);
					if (i>0 && i<18) {
						toggle(i-1, bowls);
					}
				}
			}
			if (number1s==0){ 
				least=Math.min(least, flip);
			}
			// untoggle
			for (int i=0; i<19; i++) {
				if (flips[i]==1) {
					flip--;
					toggle(i, bowls);
					toggle(i+1, bowls);
					if (i>0 && i<18) {
						toggle(i-1, bowls);
					}
				}
			}
		}
		return least;
	}
	static int numberOfPossibilities(int n) {
		if (n==0) {
			return 1;
		}
		return 2*numberOfPossibilities(n-1);
	}
	static int[] convertBinary(int number, int length) {
		int[] arr=new int[length];
		int count=0;
		while (number!=0) {
			int remainder=number%2;
			number=number/2;
			arr[count]=remainder;
			count++;
		}
		return arr;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int[] bowls=new int[20];
		for (int i=0; i<20; i++) {
			bowls[i]=Integer.parseInt(st.nextToken());
			if (bowls[i]==1) {
				number1s++;
			}
		}
		System.out.println(f(bowls));
	}
}
