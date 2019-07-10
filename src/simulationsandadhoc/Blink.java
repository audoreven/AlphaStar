package simulationsandadhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Blink {
	static int convertDecimal(int[] binary) {
		int x=0;
		for (int i=0; i<binary.length; i++) {
			x=x+(binary[i]*powerOf2(i));
		}
		return x;
	}
	static int powerOf2 (int n) {
		int x=1;
		for (int i=0; i<n; i++) {
			x=x*2;
		}
		return x;
	}
	static int[] convertBinary(int number, int length) {
		int[] arr=new int[length];
		int count=0;
		while (number!=0) {
			int remainder=number%2;
			number=number/2;
			arr[count]=remainder;
			count++;
		}
		return arr;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		int[] lights=new int[n];
		ArrayList<Integer> decimal=new ArrayList<Integer>();
		for (int i=0; i<n; i++) {
			lights[i]=Integer.parseInt(br.readLine());
		}
		int contain=convertDecimal(lights);
		int[] firstOccurence= new int[powerOf2(n)];
		for (int i=0; i<powerOf2(n); i++) {
			firstOccurence[i]=-1;
		}
		int t=0;
		firstOccurence[contain]=t;
		boolean cont=true;
		while(cont) {
			t++;
			decimal.add(contain);
			int prev=lights[n-1];
			for (int i=n-1; i>0; i--) {
				if (lights[i-1]==1) {
					if (lights[i]==1) {
						lights[i]=0;
					} else {
						lights[i]=1;
					}
				}
			}
			if (prev==1){
				if (lights[0]==1) {
					lights[0]=0;
				}
				else {
					lights[0]=1;
				}
			} 
			//System.out.println("T"+t+" "+Arrays.toString(lights));
			contain=convertDecimal(lights);
			if (firstOccurence[contain]==-1) {
				firstOccurence[contain]=t;
			}
			else {
				cont=false;
				break;
			}
		}
		//System.out.println(decimal.toString());
		int start=firstOccurence[contain];
		//System.out.println(start);
		int index=(int) ((b-start)%(decimal.size()-start));
		lights=convertBinary(decimal.get(start+index),n);
		for (int i=0; i<n; i++) {
			System.out.println(lights[i]);
		}
	}
}
