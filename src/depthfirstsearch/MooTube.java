package depthfirstsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MooTube {
	static int vid=0;
	static void dfs(ArrayList<ArrayList<Video>> adj, int n, int k, boolean[] vis) {
		if (vis[n] || n>adj.size()-1) {
			return;
		}
		vis[n]=true;
		for (int i=0; i<adj.get(n).size(); i++) {
			if (adj.get(n).get(i).relevance>=k && !vis[adj.get(n).get(i).video]) {
				vid++;
				dfs(adj, adj.get(n).get(i).video, k, vis);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int q=Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Video>> adj=new ArrayList<ArrayList<Video>>();
		for (int i=0; i<n+1; i++) {
			adj.add(new ArrayList<Video>());
		}
		for (int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			adj.get(a).add(new Video(b,c));
			adj.get(b).add(new Video(a,c));
		}
		int[][] que=new int[q][2];
		for (int i=0; i<q; i++) {
			st = new StringTokenizer(br.readLine());
			que[i][0]=Integer.parseInt(st.nextToken());
			que[i][1]=Integer.parseInt(st.nextToken());
			boolean[] vis=new boolean[n+1];
			dfs(adj, que[i][1], que[i][0], vis);
			System.out.println(vid);
			vid=0;
		}
	}
	static class Video {
		int video, relevance;
		public Video(int a, int b){
			video=a;
			relevance=b;
		}
	}
}
