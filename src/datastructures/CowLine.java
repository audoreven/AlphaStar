package datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class CowLine {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		//vector or deque
		Deque<Integer> cows= new ArrayDeque<Integer>();
		int toAdd=1;
		for (int i=1; i<n+1; i++) {
			st=new StringTokenizer(br.readLine());
			if (st.nextToken().equals("A")) {
				if (st.nextToken().equals("L")) {
					cows.push(toAdd);
					toAdd++;
				}
				else {
					cows.addLast(toAdd);
					toAdd++;
				}
			}
			else {
				if (st.nextToken().equals("L")) {
					int k=Integer.parseInt(st.nextToken());
					for (int j=0; j<k; j++) {
						cows.removeFirst();
					}
				}
				else {
					int k=Integer.parseInt(st.nextToken());
					for (int j=0; j<k; j++) {
						cows.removeLast();
					}
				}
			}
		}
		while (!cows.isEmpty()) {
			System.out.println(cows.getFirst());
			cows.removeFirst();
		}
	}
}
