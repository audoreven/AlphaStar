package searchingandsorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HoofPaperScissors {
	// H=0, P=1, S=2
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] move = new int[n];
		int[] reversed = new int[n];
		for (int i = 0; i <n; i++) {
			String m = br.readLine();
			if (m.contains("H")) {
				move[i] = 0;
				reversed[n-i-1] = 0;
			} else if (m.contains("P")) {
				move[i] = 1;
				reversed[n-i-1] = 1;
			} else {
				move[i] = 2;
				reversed[n-i-1] = 2;
			}
		}
		int[][] prefix=prefix(move);
		int[][] suffix=prefix(reversed);
		int wins=0;
		for (int i=1; i<=n; i++) {
			// switching point at i
			for (int j=0; j<3; j++) {
				int first=prefix[j][i];
				for(int k=0; k<3; k++) {
					int second=suffix[k][n-i+1];
					wins=Math.max(first+second, wins);
				}
			}
		}
		System.out.println(wins);
	}
	
	static int[][] prefix(int[] arr) {
		int[][] prefix=new int[3][arr.length+1];
		for (int i=1; i<=arr.length; i++) {
			for (int j=0; j<3; j++) {
				prefix[j][i]=prefix[j][i-1];
			}
			prefix[arr[i-1]][i]++;
			
		}
		return prefix;
	}
}
