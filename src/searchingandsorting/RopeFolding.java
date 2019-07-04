package searchingandsorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RopeFolding {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		String[] temp = reader.nextLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int L = Integer.parseInt(temp[1]);
		ArrayList<Float> knots = new ArrayList<Float>();
		for (int i = 0; i < N; i++) {
			knots.add(Float.parseFloat(reader.nextLine()));
		}
		Collections.sort(knots);
		ArrayList<Float> toCheck = midpoint(knots);
		for (int i = 0; i < N; i++) {
			if (knots.get(i)!=0 && knots.get(i)!=L) {
				toCheck.add(knots.get(i));
			}
		}
		System.out.println(check(knots, toCheck));
		reader.close();
	}

	static ArrayList<Float> midpoint(ArrayList<Float> a) {
		ArrayList<Float> m = new ArrayList<Float>();
		for (int i = 0; i < a.size() - 1; i++) {
			m.add((a.get(i) + a.get(i + 1)) / 2);
		}
		return m;
	}

	static int check(ArrayList<Float> a, ArrayList<Float> c) {
		int p, q;
		float fold;
		int count = 0;
		for (int i = 0; i < c.size(); i++) {
			fold = c.get(i);
			for (int j = 1; j < a.size(); j++) {
				if (a.get(j) == fold) {
					q = j;
					p = j;
					if  (out(p,q,a)) {
						count++;
					}
					break;
				}
				else if (a.get(j) > fold) {
					q = j;
					p = j - 1;
					if  (out(p,q,a)) {
						count++;
					}
					break;
				}
			}
		}
		return count;
	}

	static boolean out(int p, int q, ArrayList<Float> a) {
		while (p > 0 && q < a.size()-1) {
			float dif = a.get(p) - a.get(p - 1);
			if (dif == a.get(q + 1) - a.get(q)) {
				q++;
				p--;
			} 
			else {
				return false;
			}
		}
		return true;
	}
}
