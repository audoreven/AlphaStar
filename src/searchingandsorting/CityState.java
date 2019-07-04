package searchingandsorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CityState {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int n = Integer.parseInt(reader.nextLine());
		ArrayList<Pair> map = new ArrayList<Pair>();
		for (int i = 0; i < n; i++) {
			String[] temp = reader.nextLine().split(" ");
			map.add(new Pair(temp[1], temp[0]));
		}
		Collections.sort(map);
		// take one, search for city whose state is equivalent to the original
		// city
		// if they are special pair, count++, remove both else remove the one
		// taken out
		for (int i = 0; i < n; i++) {
			Pair city=map.get(i);
			
		}
		reader.close();
	}

	static void count() {

	}

	static class Pair implements Comparable<Pair> {
		String city, state;

		public Pair(String x, String y) {
			state = x;
			city = y.substring(0, 2);
		}

		public int compareTo(Pair p) {
			int value = this.state.compareTo(p.state);
			if (value != 0) {
				return value;
			} else {
				return this.city.compareTo(p.city);
			}
		}

	}
}
