package depthfirstsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Moocast {
	static int count=0;
	static void DFS(int x, int[][] cows, boolean[] vis) {
		ArrayList<Integer> canreach=new ArrayList<Integer>();
		for (int i=0; i<cows.length; i++) {
			if (i!=x && !vis[i]) {
				int disx=Math.abs(cows[i][0]-cows[x][0]);
				int disy=Math.abs(cows[i][1]-cows[x][1]);
				if ((disx*disx)+(disy*disy)<=cows[x][2]) {
					canreach.add(i);
				}
			}
		}
		if (canreach.size()==0) {
			return;
		}
		for (int i=0; i<canreach.size(); i++) {
			vis[canreach.get(i)]=true;
			DFS(canreach.get(i), cows, vis);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[][] cows=new int[n][3];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			cows[i][0]=Integer.parseInt(st.nextToken());
			cows[i][1]=Integer.parseInt(st.nextToken());
			int temp=Integer.parseInt(st.nextToken());
			cows[i][2]=temp*temp;
		}
		int ans=0;
		for (int i=0; i<n; i++) {
			boolean[] vis=new boolean[n];
			vis[i]=true;
			DFS(i, cows, vis);
			for (int j=0; j<vis.length; j++) {
				if (vis[j]) {
					count++;
				}
			}
			ans=Math.max(ans, count);
			count=0;
		}
		System.out.println(ans);
	}
}
