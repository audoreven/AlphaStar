package simulationsandadhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CowRace {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] bp = new int[1000000];
		int[] ep = new int[1000000];
		int totaltime = 0;
		int bt = 0;
		int et = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int bx = Integer.parseInt(st.nextToken());
			int by = Integer.parseInt(st.nextToken());
			totaltime = totaltime + by;
			for (int j = 0; j < by; j++) {
				if (bt +j == 0) {
					bp[j+bt] = bx;
				} else {
					bp[j+bt] = bp[j+ bt - 1] + bx;
				}
			}
			bt=by+bt;
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			for (int j = 0; j < ey; j++) {
				if (et +j == 0) {
					ep[j+et] = ex;
				} else {
					ep[j+et] = ep[j +et- 1] + ex;
				}
			}
			et=ey+et;
		}
		int prev = 0;
		int change = 0;
		for (int i = 0; i < totaltime; i++) {
			int curr = prev;
			if (ep[i] > bp[i]) {
				curr = 1;
			} else if (ep[i] < bp[i]) {
				curr = -1;
			} 
			if (curr != prev) {
				change++;
			}
			prev = curr;
		}
		if (change>0) {
			System.out.println(change-1);
		}
		else {
			System.out.println(change);
		}
	}

	static class Pair {
	}
}
