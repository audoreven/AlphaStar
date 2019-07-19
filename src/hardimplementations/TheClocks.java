package hardimplementations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TheClocks {
	static ArrayList<Integer> moves = new ArrayList<Integer>();
	static ArrayList<Integer> maybe = new ArrayList<Integer>();
	static int[] vis = new int[10];
/*
	static void recurse(int[] clocks) {
		if (sum(clocks)) {
			moves = compare(moves, maybe);
			vis=new int[10];
			return;
		}
		for (int i = 1; i < 10; i++) {
			if (vis[i] < 3) {
				maybe.add(i);
				clocks = move(i, clocks);
				vis[i]++;
				System.out.println(maybe.toString());
				recurse(clocks);
				maybe.remove(maybe.size()-1);
				clocks = moveback(i, clocks);
				vis[i]--;
			}
		}
	}*/
	static void recurse(int i, int[] clocks) {
		boolean e=sum(clocks,maybe);
		if (e) {
			System.out.println(maybe.toString());
			moves=compare(moves, maybe);
			return;
		}
		// generate all possibilities
		for (int j=1; j<=9; j++) {
			if (vis[j]<1) {
				maybe.add(j);
				vis[j]++;
				recurse(i+1, clocks);
				maybe.remove(maybe.size()-1);
				vis[j]--;
			}
		}
	}

	static ArrayList<Integer> compare(ArrayList<Integer> moves, ArrayList<Integer> maybe) {
		if (moves.isEmpty()) {
			return maybe;
		} else {
			if (maybe.size() > moves.size()) {
				return moves;
			} else if (maybe.size() == moves.size()) {
				for (int i = 0; i < maybe.size(); i++) {
					if (moves.get(i) > maybe.get(i)) {
						return maybe;
					} else if (moves.get(i) < maybe.get(i)) {
						return moves;
					}
				}
			} else {
				return maybe;
			}
		}
		return maybe;
	}

	static boolean sum(int[] clock, ArrayList<Integer> moves) {
		int sum = 0;
		int clocks[]=clock;
		for (int i=0; i<moves.size(); i++) {
			clocks=move(moves.get(i), clocks);
		}
		for (int i = 0; i < 9; i++) {
			sum = clocks[i] + sum;
		}
		for (int i=0; i<moves.size(); i++) {
			clocks=moveback(moves.get(i), clocks);
		}
		if (sum == 0) {
			return true;
		}
		return false;
	}

	static int[] move(int n, int[] clocks) {
		if (n == 1) {
			clocks[0] = (clocks[0] + 3) % 12;
			clocks[1] = (clocks[1] + 3) % 12;
			clocks[3] = (clocks[3] + 3) % 12;
			clocks[4] = (clocks[4] + 3) % 12;
		} else if (n == 2) {
			clocks[0] = (clocks[0] + 3) % 12;
			clocks[1] = (clocks[1] + 3) % 12;
			clocks[2] = (clocks[2] + 3) % 12;
		} else if (n == 3) {
			clocks[1] = (clocks[0] + 3) % 12;
			clocks[2] = (clocks[1] + 3) % 12;
			clocks[4] = (clocks[4] + 3) % 12;
			clocks[5] = (clocks[5] + 3) % 12;
		} else if (n == 4) {
			clocks[0] = (clocks[0] + 3) % 12;
			clocks[3] = (clocks[3] + 3) % 12;
			clocks[6] = (clocks[6] + 3) % 12;
		} else if (n == 5) {
			clocks[1] = (clocks[1] + 3) % 12;
			clocks[3] = (clocks[3] + 3) % 12;
			clocks[4] = (clocks[4] + 3) % 12;
			clocks[5] = (clocks[5] + 3) % 12;
			clocks[7] = (clocks[7] + 3) % 12;
		} else if (n == 6) {
			clocks[2] = (clocks[2] + 3) % 12;
			clocks[5] = (clocks[5] + 3) % 12;
			clocks[8] = (clocks[8] + 3) % 12;
		} else if (n == 7) {
			clocks[3] = (clocks[3] + 3) % 12;
			clocks[4] = (clocks[4] + 3) % 12;
			clocks[6] = (clocks[6] + 3) % 12;
			clocks[7] = (clocks[7] + 3) % 12;
		} else if (n == 8) {
			clocks[6] = (clocks[6] + 3) % 12;
			clocks[7] = (clocks[7] + 3) % 12;
			clocks[8] = (clocks[8] + 3) % 12;
		} else {
			clocks[4] = (clocks[4] + 3) % 12;
			clocks[5] = (clocks[5] + 3) % 12;
			clocks[7] = (clocks[7] + 3) % 12;
			clocks[8] = (clocks[8] + 3) % 12;
		}
		return clocks;
	}

	static int[] moveback(int n, int[] clocks) {
		if (n == 1) {
			clocks[0] = (clocks[0] + 9) % 12;
			clocks[1] = (clocks[1] + 9) % 12;
			clocks[3] = (clocks[3] + 9) % 12;
			clocks[4] = (clocks[4] + 9) % 12;
		} else if (n == 2) {
			clocks[0] = (clocks[0] + 9) % 12;
			clocks[1] = (clocks[1] + 9) % 12;
			clocks[2] = (clocks[2] + 9) % 12;
		} else if (n == 3) {
			clocks[1] = (clocks[0] + 9) % 12;
			clocks[2] = (clocks[1] + 9) % 12;
			clocks[4] = (clocks[4] + 9) % 12;
			clocks[5] = (clocks[5] + 9) % 12;
		} else if (n == 4) {
			clocks[0] = (clocks[0] + 9) % 12;
			clocks[3] = (clocks[3] + 9) % 12;
			clocks[6] = (clocks[6] + 9) % 12;
		} else if (n == 5) {
			clocks[1] = (clocks[1] + 9) % 12;
			clocks[3] = (clocks[3] + 9) % 12;
			clocks[4] = (clocks[4] + 9) % 12;
			clocks[5] = (clocks[5] + 9) % 12;
			clocks[7] = (clocks[7] + 9) % 12;
		} else if (n == 6) {
			clocks[2] = (clocks[2] + 9) % 12;
			clocks[5] = (clocks[5] + 9) % 12;
			clocks[8] = (clocks[8] + 9) % 12;
		} else if (n == 7) {
			clocks[3] = (clocks[3] + 9) % 12;
			clocks[4] = (clocks[4] + 9) % 12;
			clocks[6] = (clocks[6] + 9) % 12;
			clocks[7] = (clocks[7] + 9) % 12;
		} else if (n == 8) {
			clocks[6] = (clocks[6] + 9) % 12;
			clocks[7] = (clocks[7] + 9) % 12;
			clocks[8] = (clocks[8] + 9) % 12;
		} else {
			clocks[4] = (clocks[4] + 9) % 12;
			clocks[5] = (clocks[5] + 9) % 12;
			clocks[7] = (clocks[7] + 9) % 12;
			clocks[8] = (clocks[8] + 9) % 12;
		}
		return clocks;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] clocks = new int[9];
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				clocks[i * 3 + j] = (Integer.parseInt(st.nextToken())) % 12;
			}
		}
		recurse(0, clocks);
	//	recurse(clocks);
		for (int i = 0; i < moves.size(); i++) {
			System.out.print(moves.get(i) + " ");
		}
	}
}
