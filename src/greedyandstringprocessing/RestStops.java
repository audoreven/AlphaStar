package greedyandstringprocessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class RestStops {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int rf = Integer.parseInt(st.nextToken());
		int rb = Integer.parseInt(st.nextToken());
		int dif = rf - rb;
		ArrayList<Rest> stops = new ArrayList<Rest>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			stops.add(new Rest(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(stops);
		long start = 0;
		long total=0;
		int i=0;
		while (start<l && i<n) {
			if (stops.get(i).posi>start) {
				total=total+(dif*(stops.get(i).posi-start)*stops.get(i).tasty);
				start=stops.get(i).posi;
			}
			i++;
		}
		System.out.println(total);
	}

	static class Rest implements Comparable<Rest> {
		int posi, tasty;

		public Rest(int a, int b) {
			posi = a;
			tasty = b;
		}

		public int compareTo(Rest o) {
			if (this.tasty < o.tasty) {
				return 1;
			} else if (this.tasty > o.tasty) {
				return -1;
			}
			return 0;
		}
	}
}
