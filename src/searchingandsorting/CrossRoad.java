package searchingandsorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class CrossRoad {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		int toFix=b;
		ArrayList<Integer> broken=new ArrayList<Integer>();
		int[] prefix=new int[n];
		for (int i=0; i<b; i++) {
			int t=Integer.parseInt(br.readLine());
			broken.add(t);
			prefix[t-1]=1;
		}
		Collections.sort(broken);
		for (int i=1; i<n; i++) {
			prefix[i]=prefix[i]+prefix[i-1];
		}
		// somehow be able to get the number of broken lights in the area
		for (int i=0; i<n-k; i++) {
			int start=i;
			int end=i+k;
			toFix=Math.min(toFix, prefix[end]-prefix[start]);
		}
		System.out.println(toFix);
	}
}
