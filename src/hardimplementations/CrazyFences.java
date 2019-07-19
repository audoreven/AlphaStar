package hardimplementations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CrazyFences {
	// coord compressino
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		ArrayList<Coord[]> fences=new ArrayList<Coord[]>();
		Coord[] cows=new Coord[c];
		for (int i=0; i<n; i++) {
			
		}
		for (int i=0; i<c; i++) {
			st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			cows[i]=new Coord(a, b);
		}
	}
	static class Coord {
		int x, y;
		public Coord(int a, int b) {
			x=a;
			y=b;
		}
	}
	static class Fence {
		Coord start, end;
		public Fence(Coord a, Coord b) {
			start=a;
			end=b;
		}
	}
}
