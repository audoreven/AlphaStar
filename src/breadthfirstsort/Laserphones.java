package breadthfirstsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Laserphones {
	static int[] mx = { 1, -1, 0, 0 };
	static int[] my = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		char[][] pasture = new char[h][w];
		for (int i = 0; i < h; i++) {
			String temp = br.readLine();
			pasture[i] = temp.toCharArray();
		}
		Queue<Pair> q = new ArrayDeque<Pair>();
		int[][] dis = new int[h][w];
		Pair start = null;
		Pair end = null;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (pasture[i][j] == '*') {
					dis[i][j] = -2;
				} else if (pasture[i][j] == 'C') {
					if (start != null) {
						end = new Pair(i, j, -1);
						dis[i][j] = -1;
					} else {
						start = new Pair(i, j, -1);
					}
				} else {
					dis[i][j] = -1;
				}
			}
		}
		q.add(start);
		while (!q.isEmpty()) {
			Pair curr = q.poll();
			// visit valid neighbors
			for (int i = 0; i < 4; i++) {
				int dx=mx[i]+curr.x;
				int dy=my[i]+curr.y;
				if (dx>=0 && dy>=0 && dx<h && dy<w) {
					if (dis[dx][dy]==-1) {
						// add to q
						if (curr.prev==-1 || curr.prev==i) {
							q.add(new Pair(dx, dy, i));
							dis[dx][dy]=dis[curr.x][curr.y];
						}
						else {
							q.add(new Pair(dx, dy, i));
							dis[dx][dy]=dis[curr.x][curr.y]+1;
							dis[dx][dy]=Math.min(dis[curr.x][curr.y]+1,dis[dx][dy]);		
						}
					}
				}
			}
		}
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(dis[i][j] +" ");
			}
			System.out.println();
		}
		System.out.println(dis[end.x][end.y]);

	}

	static class Pair {
		int x, y;
		int prev;
		public Pair(int a, int b, int p) {
			x = a;
			y = b;
			prev=p;
		}
	}
}
