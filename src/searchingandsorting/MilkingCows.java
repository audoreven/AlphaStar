package searchingandsorting;

import java.util.Arrays;
import java.util.Scanner;

public class MilkingCows {
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		int n=Integer.parseInt(reader.nextLine());
		Intervals[] farmers=new Intervals[n];
		for (int i=0; i<n; i++) {
			String[] temp=reader.nextLine().split(" ");
			Intervals t=new Intervals(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
			farmers[i]=t;
		}
		Arrays.sort(farmers);
		int ans1=farmers[0].end-farmers[0].start;
		int ans2=0;
		int maxend=farmers[0].end;
		int start=farmers[0].start;
		for (int i=1; i<n; i++) {
			if (farmers[i].start<=maxend) {
				maxend=Math.max(farmers[i].end, maxend);
				ans1=Math.max(ans1, maxend-start);
			}
			else {
				// new interval
				ans2=Math.max(farmers[i].start-maxend, ans2);
				start=farmers[i].start;
				maxend=farmers[i].end;
			}
		}
		System.out.println(ans1+" "+ans2);
	}
	static class Intervals implements Comparable<Intervals>{
		int start, end;
		public Intervals() {
			start=0;
			end=0;
		}
		public Intervals(int x, int y) {
			start=x;
			end=y;
		}
		public int compareTo(Intervals i) {
			if (this.start>i.start) {
				return 1;
			}
			else if (this.start==i.start) {
				return 0;
			}
			return -1;
		}
	}
}
