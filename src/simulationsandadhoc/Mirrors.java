package simulationsandadhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Mirrors {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		Fence barn=new Fence(a, b, 'B');
		ArrayList<Fence> fences=new ArrayList<Fence>();
		int[] visb=new int[n];
		int[] vish=new int[n];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			char z=st.nextToken().charAt(0);
			fences.add(new Fence(x,y,z));
		}
		// if hit mirror 3 times - infinite loop
		// if no other mirrors after that in its row/column
		// go from both house and barn and see if they meet at a mirror
		// from barn:
		boolean stop=false;
		while(!stop) {
			
		}
		// from house:
		while(!stop) {
			
		}
	}
	static class Fence {
		int x, y, facing;
		public Fence(int a, int b, char c) {
			x=a;
			y=b;
			if (c=='/') {
				// from left== go up now
				// from bottom== go right now
				// from top== go left now
				// from right== go down now
				facing=1;
			} else if (c=='B') {
				facing=0;
			} else {
				// from right== go up now
				// from bottom== go left now
				// from top== go right now
				// from left== go down now
				facing=-1;
			}
		}
	}
}
