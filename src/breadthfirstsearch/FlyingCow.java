package breadthfirstsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class FlyingCow {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q=new ArrayDeque<Integer>();
		boolean[] vis=new boolean[3*n+1];
		int[] d=new int[3*n+1];
		q.add(1);
		while (!q.isEmpty()) {
			int curr=q.poll();
			if (curr<n && curr>0) {
				if (!vis[curr-1]) {
					q.add(curr-1);
					d[curr-1]=d[curr]+1;
					vis[curr-1]=true;
				}
				if (!vis[curr+1]) {
					q.add(curr+1);
					d[curr+1]=d[curr]+1;
					vis[curr+1]=true;
				}
				if (!vis[curr*3]) {
					q.add(curr*3);
					d[curr*3]=d[curr]+1;
					vis[curr*3]=true;
				}
				vis[curr]=true;
			}
		}
		d[1]=0;
		System.out.println(d[n]);
	}
}
