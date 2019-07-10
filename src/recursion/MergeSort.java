package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MergeSort {
	static void mergesort(int[] n, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;

			mergesort(n, start, mid);
			mergesort(n, mid + 1, end);

			merge(n, start, end, mid);
		}
	}

	static void merge(int[] n, int start, int end, int mid) {
		int[] temp = new int[n.length];
		int[] temp2 = new int[n.length];
		for (int i = 0; i < mid - start + 1; i++) {
			temp[i] = n[i + start];
		}
		for (int i = 0; i < end - mid; i++) {
			temp2[i] = n[i + mid + 1];
		}
		int p = 0;
		int q = 0;
		for (int i = start; i <= end; i++) {
			if (p < mid - start + 1 && q < end - mid) {
				if (temp[p] > temp2[q]) {
					n[i] = temp2[q];
					q++;
				} else {
					n[i] = temp[p];
					p++;
				}
			} else if (p == mid - start && q < end - mid) {
				n[i] = temp2[q];
				q++;
			} else {
				if (p < mid - start + 1) {
					n[i] = temp[p];
					p++;
				}
			}
		}
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] numbers = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		mergesort(numbers, 0, n - 1);
	}
}
