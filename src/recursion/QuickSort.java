package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuickSort {
	static void quicksort(int[] n, int start, int end) {
		if (start < end) {
			int pivot, p, q;
			pivot = n[end];
			q = end - 1;
			p = start;
			while (p<=q) {
				while (n[p] < pivot && p < end) {
					p++;
				}
				while (n[q] > pivot && q>0) {
					q--;
				}
				if (p < q) {
					int temp = n[p];
					n[p] = n[q];
					n[q] = temp;
					p++;
					q--;
				}
				else {
					break;
				}
			}
			n[end] = n[p];
			n[p] = pivot;
			for (int i = 0; i < n.length; i++) {
				System.out.print(n[i] + " ");
			}
			System.out.println();
			quicksort(n, start, p-1);
			quicksort(n, p+1, end);
		}
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
		quicksort(numbers, 0, numbers.length - 1);
	}
}
