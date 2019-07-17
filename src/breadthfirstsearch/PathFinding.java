package breadthfirstsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PathFinding {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		boolean[][] currents=new boolean[n+1][n+1];
		for (int i=1; i<n+1; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j=1; j<n+1; j++) {
				if (Integer.parseInt(st.nextToken())==1) {
					currents[i][j]=true;
				}
				else {
					currents[i][j]=false;
				}
			}
		}
		Queue<Integer> q=new LinkedList<Integer>();
		boolean[] vis=new boolean[n+1];
		int[] dis=new int[n+1];
		for (int i=0; i<dis.length; i++) {
			dis[i]=-1;
		}
		dis[m]=0;
		q.add(m);
		while (!q.isEmpty()){
			int island=q.poll();
			vis[island]=true;
			for (int i=1; i<n+1; i++) {
				if (currents[island][i] && !vis[i]) {
					q.add(i);
					dis[i]=dis[island]+1;
					vis[i]=true;
				}
			}
		}
		ArrayList<Pair> distance=new ArrayList<Pair>();
		for (int i=1; i<n+1; i++) {
			if (dis[i]>0) {
				distance.add(new Pair(dis[i],i));
			}
		}
		Collections.sort(distance);
		int count=0;
		System.out.print(m);
		for (int i=0; i<distance.size(); i++) {
			// print out the same ones in a line
			if (distance.get(i).distance==count) {
				System.out.print(distance.get(i).island+" ");
			}
			else {
				count=distance.get(i).distance;
				System.out.print("\n"+distance.get(i).island+" ");
			}
		}
	}
	static class Pair implements Comparable<Pair>{
		int distance;
		int island;
		public Pair(int a, int b) {
			island=b;
			distance=a;
		}
		@Override
		public int compareTo(Pair o) {
			if (this.distance>o.distance) {
				return 1;
			}
			if (this.distance==o.distance) {
				return 0;
			}
			return -1;
		}
		
	}
}
