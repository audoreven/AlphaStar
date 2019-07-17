package depthfirstsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class PalindromicPaths {
	static int[] mx = { 1, 0, -1, 0 };
	static int[] my = { 0, 1, 0, -1 };

	static void DFStop(char[][] fields, int row, int currx, int curry, Set<String> palin, String half) {
		int column = fields.length - row - 1;
		// target is row column in fields
		if (row != currx || column != curry) {
			if (row == currx) {
				for (int i = curry; i < column; i++) {
					half = combine(half, fields[row][i]);
					curry++;
				}
			} else if (column == curry) {
				for (int i = currx; i < row; i++) {
					half = combine(half, fields[i][column]);
					currx++;
				}
			} else {
				for (int i = 0; i < 2; i++) {
					if (currx<fields.length-1 && curry<fields.length-1) {
						half = combine(half, fields[currx][curry]);
						currx=currx+mx[i];
						curry=curry+my[i];
						DFStop(fields, row, currx, curry, palin, half);
						currx=currx-mx[i];
						curry=curry-my[i];
						half=half.substring(0, half.length()-1);
					}
				}
			}
		}
		if (row == currx && column == curry) {
			half=combine(half, fields[row][column]);
			palin.add(half);
		}

	}

	static void DFSbottom(char[][] fields, int row, int currx, int curry, Set<String> palin, String half) {
		int column = fields.length - row - 1;
		// target is row column in fields
		if (row != currx || column != curry) {
			if (row == currx) {
				for (int i = curry; i > column; i--) {
					half = combine(half, fields[row][i]);
					curry--;
				}
			} else if (column == curry) {
				for (int i = currx; i > row; i--) {
					half = combine(half, fields[i][column]);
					currx--;
				}
			} else {
				for (int i = 2; i < 4; i++) {
					if (currx>0 && curry>0) {
						half = combine(half, fields[currx][curry]);
						currx=currx+mx[i];
						curry=curry+my[i];
						DFSbottom(fields, row, currx, curry, palin, half);
						currx=currx-mx[i];
						curry=curry-my[i];
						half=half.substring(0, half.length()-1);
					}
				}
			}
		}
		if (row == currx && column == curry) {
			half=combine(half, fields[row][column]);
			palin.add(half);
		}
	}

	static String combine(String m, char n) {
		Character.toString(n);
		return m + n;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		// go to middle (diagonal) and see if the top and bottom match
		char[] middle = new char[n];
		char[][] fields = new char[n][n];
		for (int i = 0; i < n; i++) {
			fields[i] = br.readLine().toCharArray();
			for (int j = 4; j > 0; j--) {
				middle[i] = fields[i][j - 1];
			}
		}
		Set<String> palin = new TreeSet<String>();
		for (int i = 0; i < n; i++) {
			String halft=""; String halfb="";
			Set<String> palint = new TreeSet<String>();
			Set<String> palinb = new TreeSet<String>();
			DFStop(fields, i, 0,0, palint, halft);
			DFSbottom(fields, i, n-1,n-1,palinb, halfb);
			// if both palint and palinb has smtg add it to palin
			String[] arr=palint.toArray(new String[palint.size()]);
			for (int j=0; j<palint.size(); j++) {
				if (palinb.contains(arr[j])) {
					palin.add(arr[j]);
				}
			}
		}
		System.out.println(palin.size());
	}
}
