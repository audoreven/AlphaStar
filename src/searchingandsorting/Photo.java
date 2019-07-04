package searchingandsorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Photo {
	static int intervals(ArrayList<Integer> c2, ArrayList<Pair> pairs) {
		// find intervals
		ArrayList<Integer> stops= new ArrayList<Integer>();
		//
		return stops.size()+1;
	}
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		String[] temp=reader.nextLine().split(" ");
		int n=Integer.parseInt(temp[0]);
		int k=Integer.parseInt(temp[1]);
		ArrayList<Integer> second=new ArrayList<Integer>();
		ArrayList<Pair> unfriendly=new ArrayList<Pair>();
		for (int i=0; i<k; i++) {
			temp=reader.nextLine().split(" ");
			int cow1=Integer.parseInt(temp[0]);
			int cow2=Integer.parseInt(temp[1]);
			unfriendly.add(new Pair(cow1,cow2));
			second.add(Math.max(cow1, cow2));
		}
		Collections.sort(unfriendly);
		Collections.sort(second);
		
		System.out.println(intervals(second, unfriendly));
		
		reader.close();
		
	}
	
	static class Pair implements Comparable<Pair>{
		int c1, c2;
		public Pair(int a, int b) {
			if (a>b) {
				c1=b;
				c2=a;
			}
			else {
				c1=a;
				c2=b;
			}
		}
		
		public int compareTo(Pair o) {
			if (this.c1>o.c1) {
				return 1;
			}
			return -1;
		}
	}
}
