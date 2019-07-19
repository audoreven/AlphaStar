package finalexam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheLazyCow {
	static long max=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long[] grass=new long[1000001];
		long[] prefix=new long[1000002];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			long a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			grass[b]=a;
		}
		for (int i=0; i<1000001; i++) {
			prefix[i+1]=prefix[i]+grass[i];
		}
		long sum=0;
		for (int i=k+1; i<1000001-k; i++) {
			sum=prefix[i+k+1]-prefix[i-k-1];
			max=Math.max(sum, max);
		}
		if (k>1000000) {
			System.out.println(prefix[1000000]);
		}else {
			System.out.println(max);
		}
	}
}
