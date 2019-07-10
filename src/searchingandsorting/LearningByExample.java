package searchingandsorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LearningByExample {
	public static void main(String[] args) {
		// redo ENTIRE LOGIC oml i suck
		Scanner reader = new Scanner(System.in);
		String[] temp = reader.nextLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int a = Integer.parseInt(temp[1]);
		int b = Integer.parseInt(temp[2]);
		ArrayList<Cows> cows = new ArrayList<Cows>();
		for (int i = 0; i < n; i++) {
			temp = reader.nextLine().split(" ");
			int weight = Integer.parseInt(temp[1]);
			cows.add(new Cows(temp[0], weight));
		}
		Collections.sort(cows);
		int s = 0;
		if (cows.get(0).weight>a) {
			if (cows.get(0).spots) {
				s=cows.get(0).weight-a;
			}
		}
		for (int i = 0; i < cows.size() - 1; i++) {
			int x = cows.get(i).weight;
			int y = cows.get(i + 1).weight;
			int midp = (x + y) / 2;
			if (cows.get(i).spots && cows.get(i + 1).spots) {
				s = s + y - x + 1;
			} else if (!cows.get(i).spots && !cows.get(i + 1).spots) {
				s = s + 0;
			} else {
				// spots lighter
				if (cows.get(i).spots) {
					if ((x + y) % 2 == 0) {
						s = s + y - midp + 1;
					} else {
						s = s + y - midp;
					}
				}
				// spots heavier
				else {
					if ((x + y) % 2 == 0) {
						s = s + y - midp + 1;
					} else {
						s = s + y - midp;
					}
				}
			}

		}
		System.out.println(s);
		reader.close();
	}
	
	static void count(ArrayList<Cows> c, int min, int max) {
		
	}

	static class Cows implements Comparable<Cows> {
		boolean spots;
		int weight;

		public Cows(String s, int w) {
			weight = w;
			if ("S".contains(s)) {
				spots = true;
			} else {
				spots = false;
			}
		}

		public int compareTo(Cows o) {
			if (this.weight > o.weight) {
				return 1;
			} else {
				return -1;
			}
		}

	}
}
