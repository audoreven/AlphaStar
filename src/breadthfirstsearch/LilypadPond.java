package breadthfirstsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class LilypadPond {
	// go back to later
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int m=Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(st.nextToken());
		int m1=Integer.parseInt(st.nextToken());
		int m2=Integer.parseInt(st.nextToken());
		int[] mx={m1, m2, -m1, -m2, m1, m2, -m1, -m2};
		int[] my={m2, m1, -m2, -m1, -m2, -m1, m2, m1};
		int[][] pond=new int[m][n];
		Integer [] start=new Integer[2];
		Integer [] dest=new Integer[2];
		for (int i=0; i<m; i++) {
			st=new StringTokenizer(br.readLine());
			for (int j=0;j<n; j++) {
				pond[i][j]=Integer.parseInt(st.nextToken());
				if (pond[i][j]==3) {
					start[0]=i;
					start[1]=j;
				}
				if (pond[i][j]==4) {
					dest[0]=i;
					dest[1]=j;
				}
			}
		}
		Queue<Integer[]> q=new ArrayDeque<Integer[]>();
		boolean[][] vis=new boolean[m][n];
		int[][] dis=new int[m][n];
		q.add(start);
		while (!q.isEmpty()) {
			Integer[] a=q.poll();
			if (pond[a[0]][a[1]]==4) {
				System.out.println(dis[a[0]][a[1]]);
			}
			for (int i=0; i<8; i++) {
				int dx=mx[i]+a[0];
				int dy=my[i]+a[1];
				if (dx>=0 && dx<m && dy>=0 && dy<n) {
					if ((pond[dx][dy]==1 || pond[dx][dy]==4) && !vis[dx][dy]) {
						Integer[] b={dx, dy};
						q.add(b);
						dis[dx][dy]=dis[a[0]][a[1]]+1;
						vis[dx][dy]=true;
					}
				}
			}
		}
	}
	
}
