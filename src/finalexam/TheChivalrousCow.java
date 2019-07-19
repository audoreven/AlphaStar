package finalexam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class TheChivalrousCow {
	static int[] dx = { 2, -2, 1, -1, 2, -2, 1, -1 };
	static int[] dy = { 1, 1, 2, 2, -1, -1, -2, -2 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		char[][] pasture = new char[y][x];
		Posi start = new Posi(0, 0);
		Posi end = new Posi(0, 0);
		for (int i = 0; i < y; i++) {
			pasture[i] = br.readLine().toCharArray();
			for (int j = 0; j < x; j++) {
				if (pasture[i][j] == 'K') {
					start = new Posi(i, j);
				}
				if (pasture[i][j] == 'H') {
					end = new Posi(i, j);
				}
			}
		}
		Queue<Posi> q=new ArrayDeque<Posi>();
		int[][] dis=new int[y][x];
		boolean[][] vis=new boolean[y][x];
		vis[start.x][start.y]=true;
		q.add(start);
		while (!q.isEmpty()) {
			Posi a=q.poll();
			for (int i=0; i<8; i++) {
				int mx=a.x+dx[i];
				int my=a.y+dy[i];
				if (mx>=0 && mx<y && my>=0 && my<x) {
					if (!vis[mx][my]) {
						vis[mx][my]=true;
						q.add(new Posi(mx, my));
						dis[mx][my]=dis[a.x][a.y]+1;
					}
				}
			}
		}
		System.out.println(dis[end.x][end.y]);
	}

	static class Posi {
		int x, y;

		public Posi(int a, int b) {
			x = a;
			y = b;
		}
	}
}
