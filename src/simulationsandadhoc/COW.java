package simulationsandadhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class COW {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String w=br.readLine();
		char[] word=w.toCharArray();
		long Cs=0;
		long COs=0;
		long COWs=0;
		for (int i=0; i<n; i++) {
			if (word[i]=='C') {
				Cs++;
			} else if (word[i]=='O') {
				COs=Cs+COs;
			} else if (word[i]=='W') {
				COWs=COs+COWs;
			}
		}
		System.out.println(COWs);
	}
}
