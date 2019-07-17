package greedyandstringprocessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class NameThatNumber {
	String name="";
	ArrayList<String> names=new ArrayList<String>();
	static void allPossible(String num) {
		
	}
	static void numToLetter(String num) {
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n=br.readLine();
		ArrayList<String> dictionary=new ArrayList<String>();
		String temp=br.readLine();
		while (!(temp).isEmpty()) {
			dictionary.add(temp);
			temp=br.readLine();
		}
	}
}
