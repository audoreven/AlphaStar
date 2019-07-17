package breadthfirstsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class UnlockingBlocks {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	// down, right, up, left

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		int n3 = Integer.parseInt(st.nextToken());
		int[][] grid = new int[31][31];
		for (int i = 0; i < n1; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int t2 = Integer.parseInt(st.nextToken());
			grid[t][t2] = 1;
		}
		for (int i = 0; i < n2; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int t2 = Integer.parseInt(st.nextToken());
			grid[t][t2] = 2;
		}
		for (int i = 0; i < n3; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int t2 = Integer.parseInt(st.nextToken());
			grid[t][t2] = 3;
		}
		// move blocks
		// if u can move then move
		//
		boolean[][][] vis=new boolean[31][31][3];
		Queue<Integer> q=new ArrayDeque<Integer>();
		
		if (separate(grid)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	private static boolean separate(int[][] grid) {
		for (int i=0; i<31; i++) {
			for (int j=0; j<31; j++) {
				for (int k=0; k<4; k++) {
					int mx=i+dx[k];
					int my=j+dy[k];
					if (mx>=0 && mx<31 && my>=0 && my<31) {
						if (grid[i][j]!=grid[mx][my] && grid[mx][my]!=0) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
}
