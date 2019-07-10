package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SkewedSorting {
	static int move=0;
	static void brokenmergesort(int[] n, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;

			brokenmergesort(n, start, mid);
			brokenmergesort(n, mid + 1, end);

			brokenmerge(n, start, end, mid);
		}
	}
	static void brokenmerge(int[] n, int start, int end, int mid) {
		int[] temp=new int[mid-start+1];
		int[] temp2=new int[end-mid];
		for (int i=0; i<mid-start+1; i++) {
			temp[i]=n[i+start];
		}
		for (int i=0; i<end-mid; i++) {
			temp2[i]=n[i+mid+1];
		}
		if (temp[0]>temp2[0]) {
			move=move+(temp.length*temp.length*2);
			int p=0; int q=0;
			for (int i=start; i<=end; i++) {
				if (q<temp.length) {
					n[i]=temp2[q];
					q++;
				} else if (p<temp.length){
					n[i]=temp[p];
					p++;
				}
			}
		}
	}
	static int powerOf2(int n) {
		if (n==0) {
			return 1;
		}
		return 2*powerOf2(n-1);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int cows=1;
		for (int i=0; i<n; i++) {
			cows=cows*2;
		}
		int[] order=new int[cows];
		for (int i=0; i<cows; i++) {
			order[i]=Integer.parseInt(br.readLine());
		}
		brokenmergesort(order, 0, cows-1);
		System.out.println(move);
		for (int i=0; i<cows; i++) {
			System.out.println(order[i]);
		}
	}
}
