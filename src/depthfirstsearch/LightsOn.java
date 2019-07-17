package depthfirstsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LightsOn {
	static int lights = 0;
	static boolean[][] lit;
	static ArrayList<Room>[][] temp;
	static boolean[][] vis;
	static int[] mx = { 1, 0, -1, 0 };
	static int[] my = { 0, 1, 0, -1 };

	static void yeet(int x, int y, int n) {
		// turn on all lights
		if (vis[x][y]) {
			return;
		}
		vis[x][y]=true;
		for (int i = 0; i < temp[x][y].size(); i++) {
			lit[temp[x][y].get(i).x][temp[x][y].get(i).y] = true;
			for (int j=0; j<4; j++) {
				int nx = temp[x][y].get(i).x + mx[j];
				int ny = temp[x][y].get(i).y + my[j];
				if (nx > 0 && nx < n+1 && ny > 0 && ny < n+1) {
					if (lit[nx][ny] && vis[nx][ny]) {
						yeet(temp[x][y].get(i).x, temp[x][y].get(i).y, n);
					}
				}
			}
		}
		// for neighbors
		for (int i = 0; i < 4; i++) {
			int nexx = x + mx[i];
			int nexy = y + my[i];
			if (nexx > 0 && nexx < n+1 && nexy > 0 && nexy < n+1) {
				if (lit[nexx][nexy] && !vis[nexx][nexy]) {
					yeet(nexx, nexy, n);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		temp = new ArrayList[n + 1][n + 1];
		lit = new boolean[n + 1][n + 1];
		vis = new boolean[n + 1][n + 1];
		for (int i=0; i<n+1; i++) {
			for (int j=0; j<n+1; j++) {
				temp[i][j] = new ArrayList<Room>();
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			temp[a][b].add(new Room(c, d));
		}
		lit[1][1] = true;
		yeet(1, 1, n);
		for (int i=1; i<n+1; i++) {
			for (int j=1; j<n+1; j++) {
				if (lit[i][j]) {
					lights++;
				}
			}
		}
		System.out.println(lights);
	}

	static class Room {
		int x, y;

		public Room(int a, int b) {
			x = a;
			y = b;
		}
	}
}
