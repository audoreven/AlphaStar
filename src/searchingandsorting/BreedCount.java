package searchingandsorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BreedCount {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int q=Integer.parseInt(st.nextToken());
		int[][] prefix=new int[4][n+1];
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int nxt=Integer.parseInt(st.nextToken());
			for (int j=0; j<4; j++) {
				prefix[j][i]=prefix[j][i-1];
			}
			prefix[nxt][i]++;
		}
		int[][] intervals=new int[q][2];
		for (int i=0; i<q; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<2; j++) {
				intervals[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for (int i=0; i<q; i++) {
			int a=intervals[i][0];
			int b=intervals[i][1];
			System.out.println((prefix[1][b]-prefix[1][a-1])+ " " +(prefix[2][b]-prefix[2][a-1])+ " "+(prefix[3][b]-prefix[3][a-1]));
		}
	}
}
