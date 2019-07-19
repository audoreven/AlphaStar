package greedyandstringprocessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NameThatNumber {
	static long stringToNum (String name) {
		long ans=0;
		for (int i=0; i<name.length(); i++) {
			ans=ans*10+charToNum(name.charAt(i));
		}
		return ans;
	}
	static long charToNum(char n) {
		if (n=='A' || n=='B' ||n=='C') {
			return 2;
		} else if (n=='D' || n=='E' ||n=='F') {
			return 3;
		} else if (n=='G' || n=='H' ||n=='I') {
			return 4;
		} else if (n=='J' || n=='K' ||n=='L') {
			return 5;
		} else if (n=='M' || n=='N' ||n=='O') {
			return 6;
		} else if (n=='P' || n=='R' ||n=='S') {
			return 7;
		} else if (n=='T' || n=='V' ||n=='U') {
			return 8;
		} else {
			return 9;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n=Long.parseLong(br.readLine());
		ArrayList<String> dictionary=new ArrayList<String>();
		ArrayList<Long> toNum=new ArrayList<Long>();
		String temp;
		while ((temp=br.readLine())!=null) {
			toNum.add(stringToNum(temp));
			dictionary.add(temp);
		}
		ArrayList<String> can=new ArrayList<String>();
		for (int i=0; i<dictionary.size(); i++) {
			if (toNum.get(i)==n) {
				can.add(dictionary.get(i));
			}
		}
		if (can.isEmpty()) {
			System.out.println("NONE");
		} else {
			for (int i=0; i<can.size(); i++) {
				System.out.println(can.get(i));
			}
		}
	}
}
