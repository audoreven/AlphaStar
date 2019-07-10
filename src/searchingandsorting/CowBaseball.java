package searchingandsorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CowBaseball {
	 public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int n=Integer.parseInt(br.readLine());
		 int[] posi=new int[n];
		 for (int i=0; i<n; i++) {
			 posi[i]=Integer.parseInt(br.readLine());
		 }
		 Arrays.sort(posi);
		 
	}
}
