package breadthfirstsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

import breadthfirstsort.SpaceExploration.Position;

public class CowBeautyPageant {
	// start BFS at multiple locations
	private static void solve() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		char[][] hide=new char[n][m];
		for (int i=0; i<n; i++) {
			String temp=br.readLine();
			hide[i]=temp.toCharArray();
		}
		Queue<Position> q=new ArrayDeque<Position>();
		int[][] dis=new int[n][m];
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (hide[i][j]=='X') {
					dis[i][j]=0;
				}
				else {
					dis[i][j]=-1;
				}
			}
		}
		while(!q.isEmpty()) {
			
		}
	}
	
	public static void main(String[] args) throws IOException{
		solve();
	}
}
