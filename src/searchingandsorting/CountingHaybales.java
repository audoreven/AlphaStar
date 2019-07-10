package searchingandsorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CountingHaybales {
	static int search(int[] arr, int tar) {
		int low = 0;
		int high = arr.length - 1;
		if (arr[0]>tar) {
			return 0;
		}
		while (low < high) {
			int mid = (low + high + 1) / 2;
			if (arr[mid] <= tar) {
				low = mid;
			} else if (arr[mid] > tar) {
				high = mid - 1;
			} 
		}
		return high+1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int[] pos = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			pos[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(pos);
	//	int[][] intervals = new int[q][2];
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int a = search(pos, Integer.parseInt(st.nextToken())-1);
			int b = search(pos, Integer.parseInt(st.nextToken()));
			System.out.println(b - a);
		}
	}
}
