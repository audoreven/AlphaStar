package breadthfirstsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class WordMorph {
	static boolean check(String s, String t) {
		int counter=0;
		for (int i=0; i<s.length(); i++) {
			if (s.charAt(i)!=t.charAt(i)) {
				counter++;
			}
		}
		if (counter==1) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String start = br.readLine();
		String end = br.readLine();
		Map<String, Integer> dictionary=new HashMap<String, Integer>();
		ArrayList<String> words= new ArrayList<String>();
		dictionary.put(start, 0);
		dictionary.put(end, 0);
		words.add(start);
		words.add(end);
		String temp;
		while (!(temp=br.readLine()).isEmpty()) {
			if (temp.length()==start.length()) {
				dictionary.put(temp, 0);
				words.add(temp);
			}
		}
		Queue<String> q=new ArrayDeque<String>();
		boolean[] vis= new boolean[dictionary.size()];
		vis[0]=true;
		q.add(start);
		while (!q.isEmpty()) {
			String a= q.poll();
			for (int i=0; i<dictionary.size(); i++) {
				if (!vis[i] && check(a, words.get(i))) {
						q.add(words.get(i));
						vis[i]=true;
						Integer replace=dictionary.get(a)+1;
						dictionary.put(words.get(i), replace);
				}
			}
		}
		System.out.println(dictionary.get(end));
	}
}
