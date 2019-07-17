package breadthfirstsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class CornMaze {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		char[][] maze = new char[r][c];
		Map<Character, ArrayList<Pair>> slides = new HashMap<Character, ArrayList<Pair>>();
		Pair end = new Pair(0, 0);
		Pair start = new Pair(0, 0);
		for (int i = 0; i < r; i++) {
			maze[i] = br.readLine().toCharArray();
			for (int j = 0; j < c; j++) {
				if (maze[i][j] == '@') {
					start = new Pair(i, j);
				} else if (maze[i][j] == '=') {
					end = new Pair(i, j);
				} else if (maze[i][j] == '#') {
					continue;
				} else {
					if (slides.containsKey(maze[i][j])) {
						ArrayList<Pair> temp = slides.get(maze[i][j]);
						temp.add(new Pair(i, j));
						slides.put(maze[i][j], temp);
					} else {
						ArrayList<Pair> temp = new ArrayList<Pair>();
						temp.add(new Pair(i, j));
						slides.put(maze[i][j], temp);
					}
				}
			}
		}
		Queue<Pair> q = new ArrayDeque<Pair>();
		boolean[][] vis = new boolean[r][c];
		q.add(start);
		int[][] dist = new int[r][c];
		vis[start.x][start.y] = true;
		while (!q.isEmpty()) {
			Pair a = q.poll();
			for (int i = 0; i < 4; i++) {
				int mx = a.x + dx[i];
				int my = a.y + dy[i];
				if (mx >= 0 && mx < r && my >= 0 && my < c) {
					if (maze[mx][my] == '.' && !vis[mx][my]) {
						vis[mx][my] = true;
						q.add(new Pair(mx, my));
						dist[mx][my] = dist[a.x][a.y] + 1;
					} else if (maze[mx][my] == '#' && !vis[mx][my]) {
						continue;
					} else if (maze[mx][my] == '=' && !vis[mx][my]) {
						System.out.println(dist[a.x][a.y] + 1);
						break;
					} else {
						if (!vis[mx][my]) {
							vis[mx][my] = true;
							ArrayList<Pair> temp = slides.get(maze[mx][my]);
							if (mx == temp.get(0).x) {
								int tx = slides.get(maze[mx][my]).get(1).x;
								int ty = slides.get(maze[mx][my]).get(1).y;
								q.add(new Pair(tx, ty));
								dist[tx][ty] = dist[a.x][a.y] + 1;
							} else {
								int tx = slides.get(maze[mx][my]).get(0).x;
								int ty = slides.get(maze[mx][my]).get(0).y;
								q.add(new Pair(tx, ty));
								dist[tx][ty] = dist[a.x][a.y] + 1;
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < r; i++) {
			System.out.println();
			for (int j = 0; j < c; j++) {
				System.out.print(dist[i][j]);
			}
		}
	}

	static class Pair {
		int x, y;

		public Pair(int a, int b) {
			x = a;
			y = b;
		}
	}
}
