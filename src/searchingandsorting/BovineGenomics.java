package searchingandsorting;

import java.util.Scanner;

public class BovineGenomics {
	static int toInteger(char i) {
		if (i=='A') {
			return 0;
		}
		else if (i=='C') {
			return 1;
		}
		else if (i=='G') {
			return 2;
		}
		else {
			return 3;
		}
	}
	static void reset(boolean[] arr) {
		for (int i=0; i<arr.length; i++) {
			arr[i]=false;
		}
	}
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		String[] temp=reader.nextLine().split(" ");
		int n=Integer.parseInt(temp[0]);
		int m=Integer.parseInt(temp[1]);
		String[] spotty=new String[n];
		String[] plain=new String[n];
		for (int i=0; i<n; i++) {
			spotty[i]=reader.nextLine();
		}
		for (int i=0; i<n; i++) {
			plain[i]=reader.nextLine();
		}
		boolean[] contains=new boolean[64];
		int count=0;
		for (int i=0; i<m-2; i++) {
			for (int j=i+1; j<m-1; j++) {
				for (int k=j+1; k<m; k++) {
					reset(contains);
					// (i,j,k):
					int howmany=0;
					for (int a=0; a<n; a++) {
						int index=(16*toInteger(plain[a].charAt(i)))+(4*toInteger(plain[a].charAt(j)))+(1*toInteger(plain[a].charAt(k)));
						contains[index]=true;
					}
					for (int a=0; a<n; a++) {
						int check=(16*toInteger(spotty[a].charAt(i)))+(4*toInteger(spotty[a].charAt(j)))+(1*toInteger(spotty[a].charAt(k)));
						if (contains[check]) {
							break;
						}
						howmany++;
					}
					if (howmany==n) {
						count++;
					}
				}
			}
		}
		System.out.println(count);
		reader.close();
	}
}
