package hardimplementations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class SpaceExploration {
	static int[] mx = { 1, 0, 0, -1, 0, 0 };
	static int[] my = { 0, 1, 0, 0, -1, 0 };
	static int[] mz = { 0, 0, 1, 0, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][][] space = new int[n][n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				char[] temp = br.readLine().toCharArray();
				for (int k = 0; k < n; k++) {
					if (temp[k] == '*') {
						space[i][j][k] = 0;
					} else {
						space[i][j][k] = -1;
					}
				}
			}
		}
		Queue<Coord> q = new ArrayDeque<Coord>();
		int asteroids=0;
		for (int i=0;i<n; i++) {
			for (int j=0; j<n; j++) {
				for (int k=0; k<n; k++) {
					if (space[i][j][k]==0) {
						q.add(new Coord(i,j, k));
						asteroids++;
						space[i][j][k]=asteroids;
						while(!q.isEmpty()) {
							Coord curr=q.poll();
							for (int l=0; l<6; l++) {
								int dx=mx[l]+curr.x;
								int dy=my[l]+curr.y;
								int dz=mz[l]+curr.z;
								if (dx>=0 && dy>=0 && dx<n && dy<n && dz>=0 && dz<n) {
									if (space[dx][dy][dz]==0) { 
										q.add(new Coord(dx, dy, dz));
										space[dx][dy][dz]=asteroids;
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(asteroids);
	}

	static class Coord {
		int x, y, z;

		public Coord(int a, int b, int c) {
			x = a;
			y = b;
			z = c;
		}
	}
}
