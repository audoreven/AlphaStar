package searchingandsorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class FairPhotography {
	static int maxInterv(ArrayList<Cow> cows, int breed) {
		int start=0; int length=0; int distance=0;
		for (int i=1; i<cows.size(); i++) {
			if (cows.get(i).breed==breed) {
				if (start==0) {
					start=i-1;
				}
				length++;
			}
			else {
				distance=Math.max(distance, cows.get(start+length).posi-cows.get(start+1).posi);
				length=0;
				start=0;
			}
		}
		distance=Math.max(distance, cows.get(start+length).posi-cows.get(start+1).posi);
		return distance;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Cow> cows = new ArrayList<Cow>(n+1);
		Cow base=new Cow(-1, "N");
		cows.add(base);
		for (int i = 1; i < n+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			cows.add(new Cow(Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		Collections.sort(cows);
		int[] prefix = new int[n + 1];
		int[] first = new int[2 * n + 1];
		int largest = 0;
		for (int i = 1; i < n + 1; i++) {
			prefix[i] = prefix[i - 1] + cows.get(i).breed;
		}
		for (int i = 0; i < n; i++) {
			if (first[prefix[i] + n] == 0) {
				first[prefix[i] + n] = cows.get(i+1).posi;
			}
		}		
		int interv1=maxInterv(cows, 1);
		int interv2=maxInterv(cows, -1);
		largest=Math.max(interv1, interv2);
		for (int i = 1; i < n; i++) {
			if (cows.get(i).posi>first[prefix[i] + n]) {
				largest = Math.max(cows.get(i).posi - first[prefix[i] + n], largest);
			}
		}
		System.out.println(largest);
	}

	static class Cow implements Comparable<Cow> {
		int posi;
		int breed;

		public Cow(int p, String b) {
			posi = p;
			if (b.equals("G")) {
				breed = -1;
			} else if (b.equals("H")){
				breed = 1;
			}
			else {
				breed=0;
			}
		}

		public int compareTo(Cow o) {
			if (this.posi > o.posi) {
				return 1;
			}
			return -1;
		}
	}
}
