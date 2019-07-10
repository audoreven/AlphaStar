package datastructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BadHairDay {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		Stack<Integer> height=new Stack<Integer>();
		long sum=0;
		for (int i=0; i<n; i++) {
			int temp=Integer.parseInt(br.readLine());
			if (height.isEmpty()) {
				height.add(temp);
			}
			else if (height.lastElement()>temp) {
				sum=sum+height.size();
				height.add(temp);
			} else {
				// pop necessary ones 
				while (!height.isEmpty()) {
					if (height.lastElement()<=temp){
						height.pop();
					}
					else {
						sum=sum+height.size();
						break;
					}
				}
				height.add(temp);
			}
		}		
		System.out.println(sum);
	}
}
