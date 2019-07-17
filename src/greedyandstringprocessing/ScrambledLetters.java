package greedyandstringprocessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ScrambledLetters {
	static void compare(String[] b, String[] w, int a) {
		// take best of a, and worst of everything else
		int best=0;
		String[] temp=new String[b.length]; 
		for (int i=0; i<b.length; i++) {
			if (i!=a) {
				temp[i]=w[i];
			}
			else {
				temp[i]=b[a];
			}
		}
		Arrays.sort(temp);
		best=Arrays.binarySearch(temp, b[a]);
		// take worst of a, and best of everything else
		int worst=0;
		String[] temp2=new String[w.length];
		for (int i=0; i<b.length; i++) {
			if (i!=a) {
				temp2[i]=b[i];
			}
			else {
				temp2[i]=w[a];
			}
		}
		Arrays.sort(temp2);
		worst=Arrays.binarySearch(temp2, w[a]);
		System.out.println((best+1)+" "+(worst+1));
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		char[][] names=new char[n][];
		for (int i=0; i<n; i++) {
			names[i]=br.readLine().toCharArray();
		}
		String[] best=new String[n];
		String[] worst=new String[n];
		for (int i=0; i<n; i++) {
			Arrays.sort(names[i]);
			String t="";
			String t2="";
			for (int j=0; j<names[i].length; j++) {
				t=t+names[i][j];
				t2=t2+names[i][names[i].length-1-j];
			}
			best[i]=t;
			worst[i]=t2;
		}
		for (int i=0; i<n; i++) {
			compare(best, worst, i);
		}
	}
}
