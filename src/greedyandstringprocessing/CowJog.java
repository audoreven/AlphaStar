package greedyandstringprocessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CowJog {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		ArrayList<Cow> cows=new ArrayList<Cow>();
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			cows.add(new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		int counter=1;
		int curr=cows.get(n-1).speed;
		for (int i=n-1; i>0; i--) {
			if (curr>=cows.get(i-1).speed) {
				counter++;
				curr=cows.get(i-1).speed;
			}
		}
		System.out.println(counter);
	}
	static class Cow {
		int posi, speed;
		public Cow(int a, int b) {
			posi=a;
			speed=b;
		}
		
	}
}
