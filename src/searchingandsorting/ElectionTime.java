package searchingandsorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ElectionTime {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		String[] temp = reader.nextLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int k = Integer.parseInt(temp[1]);
		ArrayList<Pair> votes = new ArrayList<Pair>();
		for (int i = 0; i < n; i++) {
			String[] temp2 = reader.nextLine().split(" ");
			Pair x = new Pair(Integer.parseInt(temp2[0]), Integer.parseInt(temp2[1]), i + 1);
			votes.add(x);
		}
		Collections.sort(votes);
		for (int i=0; i<n-k; i++) {
			votes.remove(0);
		}
		// sort by r2
		for (int i=0; i<votes.size(); i++) {
			votes.get(i).switchr1r2();
		}
		Collections.sort(votes);
		int maxIndex=votes.get(votes.size()-1).ind;
		System.out.println(maxIndex);
	}
	
	static class Pair implements Comparable<Pair>{
		int r1, r2, ind;
		public Pair(int x, int y, int i) {
			r1=x;
			r2=y;
			ind=i;
		}
		public void switchr1r2(){
			int temp=r1;
			r1=this.r2;
			r2=temp;
		}
		public int compareTo(Pair o) {
			if (this.r1 > o.r1) {
				return 1;
			}
			return -1;
		}
		
	}
}
