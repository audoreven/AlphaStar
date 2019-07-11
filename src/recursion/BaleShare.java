package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaleShare {
	static int[] sum=new int[3];
	static int ans=100000;
	static void DFS(int b, int[] bales){
		if (b<bales.length) {
			for (int i=0; i<3; i++) {
				sum[i]+=bales[b];
				if (sum[i]<ans) {
					DFS(b+1, bales);
				}
				sum[i]-=bales[b];
			}
		}
		if (b==bales.length) {
			int temp=Math.max(sum[2],Math.max(sum[0], sum[1]));
			if (ans==0) {
				ans=temp;
			} else {
				ans=Math.min(temp, ans);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		sum[0]=Integer.parseInt(br.readLine());
		int[] bales=new int[n-1];
		for (int i=0; i<n-1; i++) {
			bales[i]=Integer.parseInt(br.readLine());
		}
		DFS(0, bales);
		System.out.println(ans);
	}
}
