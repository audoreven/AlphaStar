package depthfirstsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MineSweeper {
	// recursively put down mines
	// break out when you know it's not right
	static int[] dx = { 0, 0, 1, 1, -1, -1, 1, -1 };
	static int[] dy = { 1, -1, 1, -1, 1, -1, 0, 0 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] field = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}

	}
}
