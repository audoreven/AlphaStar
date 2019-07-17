package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class MothersMilk {
	static void pour(Set<Integer> possi, int[] milk, int[] max, boolean[] vis) {
		int[] ori = milk;
		if (!possi.contains(milk[2]) && milk[0] == 0) {
			possi.add(milk[2]);
		}
		int prev = 1;
		milk[0] = 0;
		milk[1] = Math.min(max[1], milk[2]);
		milk[2] = milk[2] - Math.min(max[1], milk[2]);
		possi.add(milk[2]);
		// first pour into second one
		boolean cont=true;
		while (cont) {
			// if one is empty && not prev, pour the full one into that
			int into = 0;
			for (int i = 0; i < 3; i++) {
				if (i != prev && milk[i] != 0) {
					into = i;
				}
			}
			for (int i = 0; i < 3; i++) {
				if (milk[i] == 0) {
					if (i != prev) {
						milk[i] = Math.min(max[i], milk[into]);
						milk[into] = milk[into] - Math.min(max[i], milk[into]);
						prev=i;
						break;
					}
				}
			}
			if (milk[0] == 0) {
				if (vis[milk[2]]) {
					cont=false;
					break;
				}
				possi.add(milk[2]);
				vis[milk[2]]=true;
			}
			System.out.println(" "+possi.toString());
		}
		System.out.println(possi.toString());
		prev = 0;
		milk[1] = 0;
		milk[0] = Math.min(max[0], milk[2]);
		milk[2] = milk[2] - Math.min(max[0], milk[2]);
		cont=true;
		possi.add(milk[2]);
		// first pour into first one
		while (cont) {
			// if one is empty && not prev, pour the full one into that
			int into = 0;
			for (int i = 0; i < 3; i++) {
				if (i != prev && milk[i] != 0) {
					into = i;
				}
			}
			for (int i = 0; i < 3; i++) {
				if (milk[i] == 0) {
					if (i != prev) {
						milk[i] = Math.min(max[i], milk[into]);
						milk[into] = milk[into] - Math.min(max[i], milk[into]);
						prev=i;
						break;
					}
				}
			}
			if (milk[0] == 0) {
				if (vis[milk[2]]) {
					cont=false;
					break;
				}
				possi.add(milk[2]);
				vis[milk[2]]=true;
			}
		}
		System.out.println(" "+possi.toString());
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		Set<Integer> possi = new TreeSet<Integer>();
		int[] milk = { 0, 0, c };
		int[] max = { a, b, c };
		boolean[] vis=new boolean[c+1];
		pour(possi, milk, max, vis);
		System.out.println(possi.toString());
	}
}
