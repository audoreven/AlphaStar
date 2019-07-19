package finalexam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheBigDance {
	static int sum=0;
	static void mergesort(int[] n, int start, int end) {
		if (end-start==1) {
			sum=(end+1)*(start+1)+sum;
			return;
		}
		if (start < end) {
			int mid = (start + end) / 2;

			mergesort(n, start, mid);
			mergesort(n, mid + 1, end);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] cows=new int[n];
		for (int i=0; i<n; i++){
			cows[i]=i+1;
		}
		mergesort(cows, 0, n-1);
		System.out.println(sum);
	}
}
