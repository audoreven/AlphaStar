package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PartyLamps {
	
	public static void main(String[] args) throws IOException {
		// 16 possibilities
		// if C=2 --> 
		// if C=1 -->
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int c=Integer.parseInt(br.readLine());
		ArrayList<Integer> on = new ArrayList<Integer>();
		ArrayList<Integer> off = new ArrayList<Integer>();		
		StringTokenizer st= new StringTokenizer(br.readLine());
		int temp=Integer.parseInt(st.nextToken());
		while (temp!=-1) {
			on.add(temp);
			temp=Integer.parseInt(st.nextToken());
		}
		st= new StringTokenizer(br.readLine());
		temp=Integer.parseInt(st.nextToken());
		while (temp!=-1) {
			off.add(temp);
			temp=Integer.parseInt(st.nextToken());
		}
		
	}
}
