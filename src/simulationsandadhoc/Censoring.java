package simulationsandadhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Censoring {
	static boolean check(ArrayList<Character> w, char[] c) {
		boolean delete=true;
		for (int i=1; i<c.length+1; i++) {
			if (w.get(w.size()-i)==c[c.length-i]) {
				delete=true;
			}
			else {
				delete=false;
				break;
			}
		}
		return delete;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s=br.readLine();
		char[] t=br.readLine().toCharArray();
		ArrayList<Character> word=new ArrayList<Character>();
		for (int i=0; i<s.length(); i++) {
			word.add(s.charAt(i));
			if (word.size()>t.length) {
				if (check(word,t)) {
					for (int j=0; j<t.length; j++) {
						word.remove(word.size()-1);
					}
				}
			}
		}
		for (int i=0; i<word.size(); i++) {
			System.out.print(word.get(i));
		}
	}
}
