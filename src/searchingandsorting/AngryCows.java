package searchingandsorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class AngryCows {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] hay = new int[n];
		for (int i = 0; i < n; i++) {
			hay[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(hay);
		int dis = (hay[hay.length - 1] - hay[0]+1) / k;
		ArrayList<ArrayList<Integer>> intervs = new ArrayList<ArrayList<Integer>>();
		int row = 0;
		for (int i=0; i<k; i++) {
			intervs.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < hay.length; i++) {
			if (hay[i] < (row + 1) * dis+hay[0]+1) {
				intervs.get(row).add(hay[i]);
			} else if (row==k-1){
				row=k-1;
				intervs.get(row).add(hay[i]);
			} else {
				row++;
				intervs.get(row).add(hay[i]);
			}
		}
		// ok: 
		int r = 0;
		for (int i = 0; i < k; i++) {
			Collections.sort(intervs.get(i));
			r = Math.max(r, intervs.get(i).get(intervs.get(i).size() - 1) - intervs.get(i).get(0));
		}

		if (k == 1) {
			System.out.println((hay[hay.length - 1] - hay[0]) / 2);
		} else {
			System.out.println(Math.min((r+1) / 2, (dis+1)/2));
		}
	}

	static class Pair implements Comparable<Pair> {
		int dif;
		int ind;

		public Pair(int x, int y) {
			dif = x;
			ind = y;
		}

		public int compareTo(Pair o) {
			if (this.dif > o.dif) {
				return 1;
			} else if (this.dif < o.dif) {
				return -1;
			}
			return 0;
		}
	}
}
