package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaleShare {
	static int[] idk() {
		int[] sum=new int[3];
		return idk();
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] barn=new int[3];
		barn[0]=Integer.parseInt(br.readLine());
		int[] bales=new int[n-1];
		for (int i=0; i<n-1; i++) {
			bales[i]=Integer.parseInt(br.readLine());
		}
	}
}
