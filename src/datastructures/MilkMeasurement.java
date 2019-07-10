package datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class MilkMeasurement {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		ArrayList<Entry> entries=new ArrayList<Entry>();
		Map<Integer, Integer> gallons= new TreeMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int d=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int change=Integer.parseInt(st.nextToken());
			entries.add(new Entry(d, c, change));
			gallons.put(c, g);
		}
		Collections.sort(entries);
		int prev=0; int sum=0; int max=g; int nxmx=g;
		for (int i=0; i<n; i++) {
			int day=entries.get(i).day;
			int cow=entries.get(i).cow;
			int change=entries.get(i).change;
			// if prev one produces less
			int ori=gallons.get(cow);
			int next=gallons.get(cow)+change;
			if (change<0) {
				if (ori==max) {
					if (next<=nxmx) {
						sum++;
						max=nxmx;
					}
					// if it gets out of a tie
				}
			}
			// if prev produces more
			if (change>0) {
				if (next>=max) {
					if (prev!=cow) {
						sum++;
						prev=cow;
					}
					nxmx=max;
					max=next;
				}
			}
			gallons.put(cow, next);
		}
		System.out.println(sum);
	}

	static class Entry implements Comparable<Entry> {
		int day, cow, change;

		public Entry(int x, int y, int z) {
			day = x;
			cow = y;
			change = z;
		}

		public int compareTo(Entry o) {
			if (this.day > o.day) {
				return 1;
			} else if (this.day == o.day) {
				if (this.cow > o.cow) {
					return 1;
				} else if (this.cow == o.cow) {
					return 0;
				}
				return -1;
			}
			return -1;
		}
	}
}
