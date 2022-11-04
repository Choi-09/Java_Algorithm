package 자바자료구조;

import java.util.Arrays;

public class Chap2_StringArrayMerge_prc {

	public static void main(String[] args) {
		String[] s1 = {"홍길동", "강감찬", "을지문덕", "계백", "김유신" };
		String[] s2 = {"독도", "울릉도", "한산도", "영도", "우도"};
		Arrays.sort(s1);
		Arrays.sort(s2);
		
		String[]s3 = new String[10];
		for(String st:s1) System.out.print(" " + st);
		System.out.println();
		for(String st:s2) System.out.print(" " + st);
		int i = 0, j = 0, k = 0;
		
		while(i<s1.length && j<s2.length) {
			if(s1[i].compareTo(s2[j])==0) {
				s3[k] = s2[j];
				k++; i++; j++;
			} else {

			}
		}
		
	}
}
