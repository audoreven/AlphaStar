package hardimplementations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CowYahtzee {
	static int num = 0;

	static void generate(int i, int s, int n, int[] freq, ArrayList<Pair[]> conditions) {
		if (i == n) {
			num=num+check(conditions, freq);
			return;
		}
		for (int j = 1; j <= s; j++) {
			freq[j]++;
			generate(i + 1, s, n, freq, conditions);
			freq[j]--;
		}
	}
	static int check(ArrayList<Pair[]> conditions, int[] freq) {
		int pass=0; 
		for (int i=0; i<conditions.size(); i++) {
			boolean prev=true;
			for (int j=0; j<conditions.get(i).length; j++) {
				int n=conditions.get(i)[j].number;
				int r=conditions.get(i)[j].rolls;
				if (freq[n]<r) {
					prev=false;
				}
			}
			if (prev) {
				return 1;
			}
		}
		return pass;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		ArrayList<Pair[]> conditions = new ArrayList<Pair[]>();
		for (int i = 0; i < e; i++) {
			String t = br.readLine();
			if (t.contains("+")) {
				ArrayList<String> temp = new ArrayList<String>();
				int mark = 0;
				for (int k = 0; k < t.length(); k++) {
					if (t.charAt(k) == '+') {
						temp.add(t.substring(mark, k));
						mark = k + 1;
					}
				}
				temp.add(t.substring(mark, t.length()));
				conditions.add(new Pair[temp.size()]);
				for (int j = 0; j < temp.size(); j++) {
					conditions.get(i)[j] = new Pair(temp.get(j));
				}
			} else {
				conditions.add(new Pair[1]);
				conditions.get(i)[0] = new Pair(t);
			}
		}
		
		int[] freq=new int[s+1];
		generate(0, s, n, freq, conditions);
		System.out.println(num);
	}

	static class Pair {
		int rolls, number;

		public Pair(String st) {
			int split = 0;
			for (int k = 0; k < st.length(); k++) {
				if (st.charAt(k) == 'x') {
					split = k;
				}
			}
			rolls = Integer.parseInt(st.substring(0, split));
			number = Integer.parseInt(st.substring(split + 1, st.length()));
		}
	}
}
