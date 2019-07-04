package searchingandsorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FieldReduction {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int n = Integer.parseInt(reader.nextLine());
		int[] maxX = new int[4];
		int[] maxY = new int[4];
		int[] minX = new int[4];
		int[] minY = new int[4];
		ArrayList<Integer> xcoord = new ArrayList<Integer>();
		ArrayList<Integer> ycoord = new ArrayList<Integer>();
		ArrayList<Coordinates> coord=new ArrayList<Coordinates>();
		for (int i = 0; i < n; i++) {
			String[] temp = reader.nextLine().split(" ");
			int x=Integer.parseInt(temp[0]);
			int y=Integer.parseInt(temp[1]);
			xcoord.add(x);
			ycoord.add(y);
			coord.add(new Coordinates(x, y));
		}
		Collections.sort(xcoord);
		Collections.sort(ycoord);
		int area=40000*40000;
		for (int i = 1; i <= 4; i++) {
			maxX[i-1]=(xcoord.get(n - i));
			maxY[i-1]=(ycoord.get(n - i));
			minX[i-1]=(xcoord.get(i - 1));
			minY[i-1]=(ycoord.get(i - 1));
		}
		int mxX, mxY, mnX, mnY;
		for (int i=0; i<4; i++) {
			mxX=maxX[i];
			for (int j=0; j<4; j++){
				mxY=maxY[j];
				for (int k=0; k<4; k++) {
					mnX=minX[k];
					for (int l=0; l<4; l++) {
						mnY=minY[l];
						if (check(mxX, mxY, mnX, mnY, coord)) {
							area=Math.min(Math.abs(((mxX-mnX)*(mxY-mnY))), area);
						}
					}
				}
			}
		}
		System.out.println(area);
		reader.close();
	}
	
	static boolean check(int maxX, int maxY, int minX, int minY, ArrayList<Coordinates> coord) {
		int count=0;
		for (int i=0; i<coord.size(); i++) {
			int xvalue=coord.get(i).x;
			int yvalue=coord.get(i).y;
			if (xvalue>maxX || xvalue<minX) {
				count++;
			}
			else if (yvalue>maxY || yvalue<minY) {
				count++;
			}
		}
		if (count<=3) {
			return true;
		}
		return false;
	}
	
	static class Coordinates {
		int x, y;
		public Coordinates(int a, int b) {
			x=a;
			y=b;
		}
	}
}
