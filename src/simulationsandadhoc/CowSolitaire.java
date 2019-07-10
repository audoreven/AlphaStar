package simulationsandadhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CowSolitaire {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int[][] game=new int[n][n];
		for (int i=0; i<n; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				String card=st.nextToken().substring(0, 1);
				if (card.equals("A")) {
					game[i][j]=1;
				} else if (card.equals("T")) {
					game[i][j]=10;
				} else if (card.equals("J")) {
					game[i][j]=11;
				} else if (card.equals("Q")) {
					game[i][j]=12;
				} else if (card.equals("K")) {
					game[i][j]=13;
				} else {
					game[i][j]=Integer.parseInt(card);
				}
			}
		}
		// first column
		for (int j=n-2; j>=0; j--) {
			game[j][0]=game[j][0]+game[j+1][0];
		}
		// last row
		for (int j=1; j<n; j++) {
			game[n-1][j]=game[n-1][j]+game[n-1][j-1];
		}
		for (int i=1; i<n; i++) {
			for (int j=n-2; j>=0; j--) {
				game[j][i]=game[j][i]+Math.max(game[j][i-1], game[j+1][i]);
			}
		}
		System.out.println(game[0][n-1]);
	}
}
