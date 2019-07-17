package depthfirstsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sudoku {
	// try everything that works... -.- you dont say lmaoo
	static int[] blockx = { 1, 1, 1, 4, 4, 4, 7, 7, 7 };
	static int[] blocky = { 1, 4, 7, 1, 4, 7, 1, 4, 7 };
	static int[] dx = { 1, 1, 1, 0, 0, -1, -1, -1 };
	static int[] dy = { 1, -1, 0, 1, -1, 0, -1, 1 };
	static int counter = 0;
	static int[][] answer = new int[9][9];

	static boolean check(int[][] grid) {
		int[] block = new int[10];
		for (int i = 0; i < 9; i++) {
			int cx = blockx[i];
			int cy = blocky[i];
			block[grid[cx][cy]]++;
			for (int j = 0; j < 8; j++) {
				int mx = cx + dx[j];
				int my = cy + dy[j];
				block[grid[mx][my]]++;
				if (block[grid[mx][my]] > 1) {
					return false;
				}
			}
			block = new int[10];
		}
		int[] col = new int[10];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				col[grid[j][i]]++;
				if (col[grid[j][i]] > 1) {
					return false;
				}
			}
			col = new int[10];
		}
		int[] row = new int[10];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				row[grid[i][j]]++;
				if (row[grid[i][j]] > 1) {
					return false;
				}
			}
			row = new int[10];
		}
		return true;
	}

	static void DFS(int row, int[][] grid) {
		if (row>8 && counter==0) {
			if (check(grid)) {
				answer=grid;
			}
			return;
		}
		int[] vis=new int[10];
		for (int i=0; i<9; i++) {
			if (grid[row][i]!=0) {
				vis[grid[row][i]]++;
			}
		}/*
		for (int i=0; i<9; i++) {
			if (grid[row][i]==0) {
				for (int j=1; j<10; j++) {
					if (vis[j]==0) {
						grid[row][i]=j;
						vis[j]++;
						counter--;
						break;
					}
				}
			}
		}*/
			// action
			DFS(row+1, grid);
			// undo actions
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] grid = new int[9][9];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if (grid[i][j] == 0) {
					counter++;
				}
			}
			if (i < 8) {
				st = new StringTokenizer(br.readLine());
			}
		}
		DFS(0, grid);
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				System.out.print(answer[i][j]+" ");
			}
			System.out.println();
		}
	}
}
