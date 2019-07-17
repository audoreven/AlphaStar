package greedyandstringprocessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class CardStacking {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int p=Integer.parseInt(st.nextToken());
		LinkedList<Integer> cards=new LinkedList<Integer>();
		for (int i=1; i<k+1; i++) {
			cards.add(i);
		}
		int deal=0; 
		ArrayList<Integer> bessie=new ArrayList<Integer>();
		while (k>deal) {
			deal++;
			if (deal%n==0) {
				bessie.add(cards.getFirst());
			}
			cards.removeFirst();

			if (cards.size()>1) {
				for (int i=0; i<p; i++) {
					int temp=cards.peek();
					cards.add(temp);
					cards.removeFirst();
				}
			}
		}
		Collections.sort(bessie);
		for (int i=0; i<bessie.size(); i++) {
			System.out.println(bessie.get(i));
		}
	}
}
