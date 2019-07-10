package datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BovineShuffle {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		// data structure for this
		int[] posi=new int[n+1];
		int[] moves=new int[n+1];
		Queue<Integer> q=new ArrayDeque<Integer>();
		st=new StringTokenizer(br.readLine());
		for (int i=1; i<n+1; i++) {
			int temp=Integer.parseInt(st.nextToken());
			posi[temp]++;
			moves[i]=temp;
		}
		for (int i=1; i<n+1; i++) {
			if (posi[i]==0) {
				q.add(i);
			}
		}
		while (!q.isEmpty()) {
			int a=q.poll();
			posi[moves[a]]--;
			if (posi[moves[a]]==0) {
				q.add(moves[a]);
			}
		}
		int cows=0;
		for (int i=1; i<n+1; i++) {
			cows=cows+posi[i];
		}
		System.out.println(cows);
	}
}
