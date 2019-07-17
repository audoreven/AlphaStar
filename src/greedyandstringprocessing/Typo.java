package greedyandstringprocessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Typo {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n=br.readLine();
		int[] string=new int[n.length()];
		int[] restring=new int[n.length()];
		int[] prefix=new int[n.length()+1];
		int[] suffix=new int[n.length()+1];
		for (int i=0; i<n.length(); i++) {
			if (n.charAt(i)=='(') {
				string[i]=1;
				restring[n.length()-1-i]=-1;
			}
			else {
				string[i]=-1;
				restring[n.length()-1-i]=1;
			}
			prefix[i+1]=prefix[i]+string[i];
		}
		for (int i=0; i<n.length();i++) {
			suffix[i+1]=suffix[i]+restring[i];
		}
		if (prefix[n.length()]==-2) {
			int count=0;
			for (int i=0; i<n.length(); i++) {
				if (prefix[i+1]>=0) {
					if (string[i]==-1) {
						count++;
					}
				} else {
					break;
				}
			}
			System.out.println(count+1);
		} else if (prefix[n.length()]==2) {
			int count=0;
			for (int i=0; i<n.length(); i++) {
				if (suffix[i+1]>=0) {
					if (restring[i]==-1) {
						count++;
					}
				} else {
					break;
				}
			}
			System.out.println(count+1);
		}
		else {
			System.out.println(0);
		}
	}
}
