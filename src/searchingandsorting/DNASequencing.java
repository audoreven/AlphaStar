package searchingandsorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DNASequencing {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int b=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		char[][] bulls=new char[b][];
		char[][] cows=new char[c][];
		int[][] out=new int[b][c];
		char[][] all=new char[b+c][];
		for (int i=0; i<b; i++) {
			String temp=br.readLine();
			bulls[i]=temp.toCharArray();
			all[i]=temp.toCharArray();
		}
		for (int i=0; i<c; i++) {
			String temp=br.readLine();
			cows[i]=temp.toCharArray();
			all[i+b]=temp.toCharArray();
		}
		for (int i=0; i<b; i++) {
			for (int j=0; j<c; j++) {
				int count=0;
				for (int l=0; l<b+c; l++) {
					boolean cont=true;
					if (l!=i && l!=j+b) {
						for (int k=0; k<25; k++) {
							if (all[l][k]!=bulls[i][k] && all[l][k]!=cows[j][k]) {
								cont=false;
								break;
							}
						}
						if (cont) {
							count++;
						}
					}
					out[i][j]=count;
				}
			}
		}
		for (int i=0; i<b; i++) {
			for (int j=0; j<c; j++) {
				System.out.print(out[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
}
