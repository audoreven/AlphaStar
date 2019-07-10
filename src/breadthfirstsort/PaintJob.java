package breadthfirstsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class PaintJob {
	// BFS somehow
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int p=Integer.parseInt(st.nextToken());	
		st=new StringTokenizer(br.readLine());
		int[] colors=new int[n];
		for (int i=0; i<n; i++) {
			colors[i]=Integer.parseInt(st.nextToken());
		}
		Queue<Integer> q=new ArrayDeque();
		boolean[] vis=new boolean[p+1];
		int[] d=new int[p+1];
		q.add(a);
		while (!q.isEmpty()) {
			int x=q.poll();
			vis[x]=true;
			for (int i=0; i<n; i++) {
				if (!vis[(x*colors[i])%p]) {
					q.add((x*colors[i])%p);
					d[(x*colors[i])%p]=d[x]+1;
					vis[(x*colors[i])%p]=true;
				}
			}
		}
		if (d[b]==0){
			System.out.println(-1);
		}
		else {
			System.out.println(d[b]);
		}
	}
}
