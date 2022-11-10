package Chap6_Sorting;

public class MergeSort {
	static int[] c;

	// --- 배열을 a,b로 나누고 정렬  ---//
	static void merge(int[] a, int lefta, int righta, int leftb, int rightb ) {
		int pa = a[lefta] = 0;
		int pb = a[leftb] = 0;
		
		while(pa < righta && pb < rightb) {
			if(a[pa] <= a[pb]) {
				pa++;
			} else pb++;
		}
		while(pa < righta) {
			pa++;
		}
		while(pb < rightb) {
			pb++;
		}
	} 

	// --- 병합한 배열 a,b를 배열 c에 저장 ---//
	static void MergeSort(int[] a, int left, int right) {
		MergeSortStack st = new MergeSortStack(30);
		Point3 pt = new Point3(left, right);
		st.push(pt);
		
		if(left < right) {
			int i;
			int center = (left + right) /2;
			int p = 0;
			int j = 0;
			int k = left;
			
			MergeSort(a, left, center);
			MergeSort(a, center+1, right);
			
			for(i = left; i <= center; i++) {
				c[p++] = a[i];
			}
			
			while(i <=right && j < p)
				a[k++] = (c[j] < a[i]) ? c[j++] : a[i++];
			
			while(j < p)
				a[k++] = c[j++];
		}
	}

	public static void main(String[] args) {
		int nx = 20;
		int[] x = new int[20];
		for (int ix = 0; ix < 20; ix++) {
			double d = Math.random();
			x[ix] = (int) (d * 50);
		}
		System.out.println("정렬 전::");
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
		System.out.println();

		MergeSort(x, 0, nx - 1); // 배열 x를 퀵정렬

		System.out.println("오름차순 정렬 후::");
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
	}
}
