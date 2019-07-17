package breadthfirstsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SpaceExploration {
	// BFS but starting at multiple points
	static int[] mx={1, -1, 0, 0};
	static int[] my={0, 0, 1, -1};
	private static void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		char[][] space=new char[n][n];
		for (int i=0; i<n; i++) {
			String temp=br.readLine();
			space[i]=temp.toCharArray();
		}
		Queue<Position> q=new ArrayDeque<Position>();
		int[][] dis=new int[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (space[i][j]=='*') {
					dis[i][j]=0;
				}
				else {
					dis[i][j]=-1;
				}
			}
		}
		int asteroids=0;
		for (int i=0;i<n; i++) {
			for (int j=0; j<n; j++) {
				if (space[i][j]=='*' && dis[i][j]==0) {
					q.add(new Position(i,j));
					asteroids++;
					dis[i][j]=asteroids;
					while(!q.isEmpty()) {
						Position curr=q.poll();
						for (int k=0; k<4; k++) {
							int dx=mx[k]+curr.x;
							int dy=my[k]+curr.y;
							if (dx>=0 && dy>=0 && dx<n && dy<n) {
								if (space[dx][dy]=='*' && dis[dx][dy]==0) {
									q.add(new Position(dx, dy));
									dis[dx][dy]=asteroids;
								}
							}
						}
					}
				}
			}
		}
		System.out.println(asteroids);
	}
	public static void main(String[] args) throws IOException {
		solve();
	}
	static class Position {
		int x, y;
		public Position(int a, int b) {
			x=a;
			y=b;
		}
	}
}
