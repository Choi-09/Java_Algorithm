
//퀵 정렬(비재귀 버전)
package Chap6_Sorting;

public class QuickSort {

	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void quickSort(int[] a, int left, int right) {

		QuickSortStack st = new QuickSortStack(30);
		Point pt = new Point(left, right);
		st.push(pt);
		
//	while ()
		
		
		while (st.isEmpty() != true) {
			Point rt = st.pop();
			int pl =left=  rt.getX();
			int pr =right= rt.getY();
//			int mp = (pr + pl) / 2;
			int x = a[(left +right)/2];
//<내 코드>	*int mp = (pl + pr) / 2;	int x = 초기값 -> 초기값이 고정되어야 그 값과 비교해서 sort시키는데 내가 짠 코드로 하면 mp의 값이 index로 고정되면서 해당 index에 들어가는 값과 비교되고, 정렬 중에 오류가 난다.
			do {

				while (a[pl] < x)
//				*while (a[pl] < a[mp])
					pl++;
				while (a[pr] > x)
//				*while (a[pl] > a[mp])
					pr--;
				if (pl <= pr)
					swap(a, pl++, pr--);
			} while (pl <= pr);
//			System.out.println("pl="+pl+"pr="+pr+"mp = " +mp);
//			System.out.println("오름차순으로 정렬했습니다.");
//			for (int i = 0; i < a.length; i++)
//				System.out.println("x[" + i + "]=" + a[i]);
			if (left < pr) {
				Point pt1 = new Point(left, pr);
				System.out.println("pt1 = "+pt1);
				st.push(pt1);
			}
			if (pl < right) {
				Point pt2 = new Point(pl, right);
				System.out.println("pt2 = "+pt2);
				st.push(pt2);
			}
		}
	}

	public static void main(String[] args) {
		int nx = 10;
		int[] x = new int[10];
		for (int ix = 0; ix < 10; ix++) {
			double d = Math.random();
			x[ix] = (int)(d * 100);
		}
	    System.out.println("quick 정렬전");
        for (int i = 0; i < nx; i++)
            System.out.print(" " + x[i]);
        System.out.println();

		quickSort(x, 0, nx - 1); // 배열 x를 퀵정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.println("x[" + i + "]=" + x[i]);
	}
}
