package datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class LifeGuards {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		// total time of work - minimum time working alone = answer
		Set<Integer> name=new HashSet<Integer>();
		ArrayList<Shift> shifts=new ArrayList<Shift>();
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			shifts.add(new Shift(s, e));
		}
		Collections.sort(shifts);
		// total time of work:
		int time=0; int last=0;
		for (int i=0; i<n; i++) {
			if (shifts.get(i).start>=last) {
				time=shifts.get(i).end-shifts.get(i).start+time;
				last=shifts.get(i).end;
			} else {
				time=shifts.get(i).end-last+time;
				last=shifts.get(i).end;
			}
		}
		// minimum time working alone
		for (int i=0; i<n; i++) {
			
		}
	}
	static class Shift implements Comparable<Shift> {
		int start, end;
		public Shift(int x, int y) {
			start=x;
			end=y;
		}
		
		public int compareTo(Shift o) {
			if (this.start>o.start) {
				return 1;
			} else if (this.start<o.start) {
				return -1;
			}
			return 0;
		}
		
	}
}
