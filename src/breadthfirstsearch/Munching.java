package breadthfirstsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Munching {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		Pair barn = new Pair(0, 0);
		Pair cow = new Pair(0, 0);
		char[][] field = new char[r][c];
		for (int i = 0; i < r; i++) {
			field[i] = br.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				if (field[i][j] == 'C') {
					cow = new Pair(i, j);
				}
				if (field[i][j] == 'B') {
					barn = new Pair(i, j);
				}
			}
		}
		Queue<Pair> q = new ArrayDeque<Pair>();
		q.add(cow);
		int[][] dist = new int[r][c];
		boolean[][] vis = new boolean[r][c];
		vis[cow.x][cow.y] = true;
		while (!q.isEmpty()) {
			Pair a = q.poll();
			for (int i = 0; i < 4; i++) {
				int mx = a.x + dx[i];
				int my = a.y + dy[i];
				if (mx >= 0 && mx < r && my >= 0 && my < c) {
					if (field[mx][my] != '*' && !vis[mx][my]) {
						vis[mx][my] = true;
						q.add(new Pair(mx, my));
						dist[mx][my] = dist[a.x][a.y] + 1;
					}
				}
			}
		}
		System.out.println(dist[barn.x][barn.y]);
	}

	static class Pair {
		int x, y;

		public Pair(int a, int b) {
			x = a;
			y = b;
		}
	}
}
