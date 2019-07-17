package depthfirstsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Checkers {
	// I GIVE UPPPPP T^T
	static int Ocounter = 0;
	static int[] mx = { 1, -1, -1, 1 };
	static int[] my = { 1, -1, 1, -1 };
	static ArrayList<Integer[]> moves = new ArrayList<Integer[]>();
	static ArrayList<Integer[]> fmoves = new ArrayList<Integer[]>();

	static void DFS(int x, int y, char[][] board, int[][] vis) {
	//	System.out.println(Ocounter);
		if (Ocounter==0 && fmoves.isEmpty()) {
			Integer[] t={x,y};
			moves.add(t);
			for (int i=0; i<moves.size(); i++) {
				System.out.println(moves.get(i)[0]+" "+moves.get(i)[1]);
			}
			fmoves=moves;
			return;
		}
		if (vis[x][y]==4) {
			return;
		}
		for (int i=0; i<4; i++) {
			vis[x][y]++;
			Integer[] t={x,y};
			moves.add(t);
			t=move(i, x, y, board);
			if (x!=t[0] && y!=t[1]) {
				DFS(t[0], t[1], board, vis);
				t=moveback(i, t[0], t[1], board);
			}
			moves.remove(moves.size()-1);
		}
	}

	static Integer[] move(int i, int x, int y, char[][] board) {
		int tx=x+mx[i];
		int ty=y+my[i];
		Integer[] ori={x,y};
		if (tx>0 && tx<board.length && ty>0 && ty<board.length) {
			if (board[x+mx[i]][y+my[i]]=='o') {
				int tempx=x+(2*mx[i]);
				int tempy=y+(2*my[i]);
				Integer[] curr=new Integer[2];
				if (tempx>0 && tempx<board.length && tempy>0 && tempy<board.length) {
					board[x][y]='+';
					board[x+mx[i]][y+my[i]]='+';
					board[tempx][tempy]='K';
					Ocounter--;
					curr[0]=tempx; curr[1]=tempy;
					return curr;
				}
				return ori;
			}
		}
		return ori;
	}
	static Integer[] moveback(int i, int x, int y, char[][] board) {
		int tx=x-mx[i];
		int ty=y-my[i];
		Integer[] ori={x,y};
		if (tx>0 && tx<board.length && ty>0 && ty<board.length) {
			if (board[x-mx[i]][y-my[i]]=='+') {
				int tempx=x-(2*mx[i]);
				int tempy=y-(2*my[i]);
				Integer[] curr=new Integer[2];
				if (tempx>0 && tempx<board.length && tempy>0 && tempy<board.length) {
					board[x][y]='+';
					board[x-mx[i]][y-my[i]]='o';
					x=tempx;
					y=tempy;
					board[x][y]='K';
					Ocounter++;
					curr[0]=tempx; curr[1]=tempy;
					return curr;
				}
				curr[0]=tempx; curr[1]=tempy;
				return curr;
			}
		}
		return ori;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[][] board = new char[n + 1][n + 1];
		ArrayList<Integer[]> kings = new ArrayList<Integer[]>();
		for (int i = 1; i < n + 1; i++) {
			board[i] = (" " + br.readLine()).toCharArray();
			for (int j = 1; j < n + 1; j++) {
				if (board[i][j] == 'K') {
					Integer[] temp = { i, j };
					kings.add(temp);
				}
				if (board[i][j] == 'o') {
					Ocounter++;
				}
			}
		}
		for (int i = 0; i < kings.size(); i++) {
			int[][] vis=new int[n+1][n+1];
			DFS(kings.get(i)[0], kings.get(i)[1], board, vis);
			moves.clear();
			if (!fmoves.isEmpty()) {
				break;
			}
		}
		if (fmoves==null) {
			System.out.println("impossible");
		}
	}

}
