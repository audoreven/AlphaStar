package depthfirstsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SnowBoots {
	static int ans=250;
	static void DFS(int[] depth, int posi, Boots[] boots, int n, boolean[][] vis) {
		// if can't move anymore
		if (posi>depth.length-2) {
			ans=Math.min(n, ans);
			return;
		}
		for (int i = posi + 1; i < posi + boots[n].step + 1; i++) {
			if (i<depth.length) {
				if (!vis[i][n]) {
					if (boots[n].depth >= depth[i]) {
						vis[i][n]=true;
						DFS(depth, i, boots, n, vis);
					}
				}
			}
		}
		for (int i = n + 1; i < boots.length; i++) {
			if (!vis[posi][i]) {
				if (depth[posi] <= boots[i].depth) {
					vis[posi][i]=true;
					DFS(depth, posi, boots, i, vis);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[] depth = new int[n + 1];
		Boots[] boots = new Boots[b];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			depth[i + 1] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < b; i++) {
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			int temp2 = Integer.parseInt(st.nextToken());
			boots[i] = new Boots(temp, temp2);
		}
		for (int i = 0; i < b; i++) {
			boolean[][] vis=new boolean[n+1][b];
			DFS(depth, 1, boots, i, vis);
		}
		System.out.println(ans);
	}

	static class Boots {
		int depth, step;

		public Boots(int s, int d) {
			depth = s;
			step = d;
		}
	}
}
