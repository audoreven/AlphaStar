package searchingandsorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SummingToSeven {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] mod7=new int[n];
		int[] prefix=new int[n+1];
		int length=0;
		for (int i=0; i<n; i++) {
			mod7[i]=Integer.parseInt(br.readLine())%7;
		}
		for (int i=1; i<1+n; i++) {
			prefix[i]=(prefix[i-1]+mod7[i-1])%7;
		}
		for (int i=1; i<=7; i++) {
			int p=1;
			int q=n;
			while (prefix[p]!=i && p<n) {
				p++;
			}
			while (prefix[q]!=i && q>0) {
				q--;
			}
			length=Math.max(q-p, length);
		}
		System.out.println(length);
	}
	
}
