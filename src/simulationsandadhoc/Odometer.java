package simulationsandadhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Odometer {
	static long generate(long a, long b, int length, int where) {
		long num=0;
		for (int i=0; i<length; i++) {
			if (i!=where){
				num=num*10+a;
			}
			else {
				num=num*10+b;
			}
		}
		if (num>100) {
			return num;
		}
		return 100;
	}
	public static void main(String[] args) throws IOException {
		Set<Long> interesting=new TreeSet<Long>();
		Set<Long> omo=new TreeSet<Long>();
		// generate interesting numbers
		for (int i=3; i<18; i++) {
			for (long a=0; a<10; a++) {
				// a= majority number
				for (long b=0; b<10; b++) {
					// b= minority number
					if (b!=a) {
						for (int w=0; w<i; w++) {
							// w is where minority number is
							interesting.add(generate(a, b, i, w));
						}
					}
				}
			}
		}
		for (int i=3; i<17; i++) {
			for (long a=0; a<10; a++) {
				// a= majority number
				for (long b=0; b<10; b++) {
					// b= minority number
					if (b==a) {
						omo.add(generate(a, b, i, 0));
					}
				}
			}
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		long x=Long.parseLong(st.nextToken());
		long y=Long.parseLong(st.nextToken());
		long total=0;
		Long[] inter=interesting.toArray(new Long[interesting.size()]);
		Long[] ono=omo.toArray(new Long[omo.size()]);
		for (int i=0; i<interesting.size(); i++) {
			if (inter[i]>y) {
				break;
			}
			if (inter[i]>=x){
				total++;
			}
		}
		for (int i=1; i<ono.length; i++) {
			if (ono[i]>y) {
				break;
			}
			if (ono[i]>=x){
				total--;
			}
		}
		System.out.println(total);
	}
}
