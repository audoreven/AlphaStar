package depthfirstsearch;

import java.util.ArrayList;

public class Permutations {
	static ArrayList<Integer> permute=new ArrayList<Integer>();
	static boolean[] vis=new boolean[5];
	static void DFS(int depth) {
		if (depth==4) {
			System.out.println(permute.toString());
			return;
		}
		for (int i=1; i<5; i++) {
			if (!vis[i]) {
				permute.add(i);
				vis[i]=true;
				DFS(depth+1);
				permute.remove(permute.size()-1);
				vis[i]=false;
			}
		}
	}
	
	public static void main(String[] args) {
		DFS(0);
	}
}
