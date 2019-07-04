package searchingandsorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TheaterSeating {
	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		String[] temp=reader.nextLine().split(" ");
		int w=Integer.parseInt(temp[0]);
		int r=Integer.parseInt(temp[1]);
		int[][] priority=new int[r][w];
		ArrayList<RCSeats> seats=new ArrayList<RCSeats>(w*r);
		for (int i=0; i<r; i++) {
			for (int j=0; j<w; j++) {
				seats.add(new RCSeats(i, j, ((w/2)-j)*((w/2)-j)+(i*i)));
			}
		}
		Collections.sort(seats);
		for (int i=0; i<w*r; i++) {
			priority[seats.get(i).row][seats.get(i).column]=w*r-i;
		}
		for(int i=r; i>0; i--) {
			for (int j=0; j<w; j++) {
				System.out.print(priority[i-1][j]+" ");
			}
			System.out.println();
		}
		reader.close();
	}
	
	static class RCSeats implements Comparable<RCSeats>{
		int row, column, distance;
		public RCSeats(int r, int c, int d) {
			row=r;
			column=c;
			distance=d;
		}
		
		public int compareTo(RCSeats o) {
			if (this.distance<o.distance) {
				return 1;
			}
			else if (this.distance==o.distance) {
				if (this.row<o.row) {
					return 1;
				}
				else if (this.row==o.row) {
					if (this.column<o.column) {
						return 1;
					}
					else {
						return -1;
					}
				}
				else {
					return -1;
				}
			}
			return -1;
		}
		
	}
}
