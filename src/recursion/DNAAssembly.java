package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DNAAssembly {
	static ArrayList<String> seq=new ArrayList<String>();
	static int length=1000000;
	static void DFS(int d, String[] dna, boolean[] vis){
		if (d<dna.length) {
			for (int i=0; i<dna.length; i++) {
				// generate permutations
				if (!vis[i]) {
					vis[i]=true;
					seq.add(dna[i]);
					DFS(d+1,dna, vis);
					seq.remove(dna[i]);
					vis[i]=false;
				}
			}
		}
		if (d==dna.length) {
			length=Math.min(combine(seq),length);
			vis=new boolean[dna.length];
		}
	}
	static int combine(ArrayList<String> dna) {
		String last="";
		for (int i=0; i<dna.size(); i++) {
			last=combine(last, dna.get(i));
		}
		return last.length();
	}
	static String combine(String a, String b) {
		for (int i=Math.min(a.length(), b.length()); i>0; i--) {
			if (a.length()==0) {
				return b;
			}
			if (a.substring(a.length()-i,a.length()).equals((b.substring(0, i)))) {
				return a+b.substring(i, b.length());
			}
		}
		return a+b;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String[] dna=new String[n];
		for (int i=0; i<n; i++) {
			dna[i]=br.readLine();
		}
		boolean[] vis=new boolean[dna.length];
		DFS(0,dna, vis);		
		System.out.println(length);
	}
}
