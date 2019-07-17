package depthfirstsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BovineBallet {
	static int[] dx={0,1,0,-1};
	static int[] dy={1,0,-1,0};
	static int maxy=2; static int miny=0;
	static int maxx=0; static int minx=-2;
	static int rot=0;
	static Pair rotate(Pair pivot, Pair rotate) {
		rot++; 
		Pair newr=new Pair(pivot.x+pivot.y-rotate.y, pivot.x+pivot.y-rotate.x);
		maxx=Math.max(maxx, newr.x);
		minx=Math.min(minx, newr.x);
		maxy=Math.max(maxy, newr.y);
		miny=Math.min(miny, newr.y);
		return newr;
	}
	static Pair move(Pair foot, int direction) {
		foot.x=foot.x+dx[direction];
		maxx=Math.max(maxx, foot.x);
		minx=Math.min(minx, foot.x);
		foot.y=foot.y+dy[direction];
		maxy=Math.max(maxy, foot.y);
		miny=Math.min(miny, foot.y);
		return foot;
	}
	static void interpret(String dir, Pair FR, Pair FL, Pair RR, Pair RL) {
		Pair foot; int direct;
		if (dir.substring(0, 2).equals("FR")) {
			foot=FR;
		} else if (dir.substring(0, 2).equals("FL")) {
			foot=FL;
		} else if (dir.substring(0, 2).equals("RR")) {
			foot=RR;
		} else {
			foot=RL;
		}
		if (dir.charAt(2)=='F') {
			direct=(0+rot)%4;
		} else if (dir.charAt(2)=='R') {
			direct=(1+rot)%4;
		} else if (dir.charAt(2)=='B') {
			direct=(2+rot)%4;
		} else {
			direct=(3+rot)%4;
		} 
		if (dir.charAt(2)=='P') {
			FR=rotate(foot, FR);
			FL=rotate(foot, FL);
			RR=rotate(foot, RR);
			RL=rotate(foot, RL);
		} else {
			foot=move(foot, direct);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		Pair FR=new Pair(0, 1);
		Pair FL=new Pair(-1, 1);
		Pair RR=new Pair(0, 0);
		Pair RL=new Pair(-1, 0);
		String[] instructions=new String[n];
		for (int i=0; i<n; i++) {
			instructions[i]=br.readLine();
			interpret(instructions[i], FR, FL, RR, RL);
		}
		System.out.println(maxx+ " "+ minx+ " "+maxy+" "+miny);
		System.out.println((maxx-minx)*(maxy-miny));
	}
	static class Pair {
		int x, y;
		public Pair(int a, int b) {
			x=a;
			y=b;
		}
	}
}
