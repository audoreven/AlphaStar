package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Moo {
	static char find(long i) {
		int k=0;
		long length=S(k);
		while (length<i) {
			k++;
			length=S(k);
		}
		if (i==1) {
			return 'm';
		} if (i==2 || i==3) {
			return 'o';
		} 
		if (S(k)-S(k-1)<i) {
			return find(i-S(k-1)-k-3);
		}
		if (S(k)-S(k-1)>i) {
			if (i==S(k-1)+1) {
				return 'm';
			}
			else if (i>S(k-1)){
				return 'o';
			}
		}
		return 'o';
	}
	static long S(int k) {
		if (k==0) {
			return 3;
		}
		return 2*S(k-1)+k+3;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());

		System.out.println(find(n));
	}
}
