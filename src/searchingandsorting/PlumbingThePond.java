package searchingandsorting;

import java.util.Scanner;

public class PlumbingThePond {
	static int[] dx={0,1,1,-1,0,-1,1,-1};
	static int[] dy={1,0,1,-1,-1,0,-1,1};
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		String[] temp=reader.nextLine().split(" ");
		int R=Integer.parseInt(temp[0]);
		int C=Integer.parseInt(temp[1]);
		int[][] D_rc=new int[R+2][C+2];
		for (int i=1; i<R+1; i++) {
			temp=reader.nextLine().split(" ");
			for (int j=1; j<C+1; j++) {
				D_rc[i][j]=Integer.parseInt(temp[j-1]);
			}
		}
		for (int i=0; i<R+2; i++) {
			for (int j=0; j<C+2; j++) {
				if (i==0 || j==0 || i==R+1 || j==C+1) {
					D_rc[i][j]=-1;
				}
			}
		}
		System.out.println(checkMove(D_rc));
		reader.close();
	}
	
	static int checkMove(int[][] depth) {
		int maxdepth=0;
		for (int i=1; i<depth.length-1; i++) {
			for (int j=1; j<depth[i].length-1; j++) {
				for  (int k=0; k<8; k++) {
					int nx=i+dx[k];
					int ny=j+dy[k];
					if (depth[i][j]==depth[nx][ny]) {
						maxdepth=Math.max(maxdepth, depth[i][j]);
					}
				}
			}
		}
		return maxdepth;
	}
}

