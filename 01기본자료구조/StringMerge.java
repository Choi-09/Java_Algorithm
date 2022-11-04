package 자바자료구조;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class StringMerge {
	public static String[] removeElement(String[]arr, String item) {
		List<String> list = new ArrayList<>(Arrays.asList(arr));
		list.remove(item);
		return list.toArray(String[]:: new);
	}
	
	public static String[] removeDuplicate(String[] lst) {
		int count = lst.length;
	    for(int i = 0; i < count; i++) {
//	    	for(int j = i+1; j < count; j++)
	    	int j = i+1;
	    	while(j<count) {
	    		if((lst[i].compareTo(lst[j])) == 0) {
	    			lst = removeElement(lst, lst[j]);
	    			count--;
	    			System.out.println("j =" + j + "count = "+ count);
	    		}
	    		else j++;
	    	}
	    }
		return lst;
		
		
	}
	public static void main(String[] args) {
				ArrayList<String> list1 = new ArrayList<String>();
				list1.add("서울");
				list1.add("북경");
				list1.add("상해");
				list1.add("서울");
				list1.add("도쿄");
				list1.add("서울");
				list1.add("뉴욕");

				ArrayList<String> list2 = new ArrayList<String>();
				list2.add("런던");
				list2.add("로마");
				list2.add("방콕");
				list2.add("북경");
				list2.add("도쿄");
				list2.add("서울");
				list2.add("서울");
				list2.add("서울");
				list2.add(1, "LA");
				
				//sort 
				System.out.println("collection.sort()::");
				
			    Collections.sort(list1);
			    System.out.println("list1::");
			    for ( String city: list1)
			    	System.out.print(city+ " ");
			    System.out.println();
			    
			    System.out.println("list2::");
			    Collections.sort(list2);
			    for ( String city: list2)
			    	System.out.print(city+ " ");
			    
				//구현 부분	
				System.out.println();
			    System.out.println("merge:: ");
			    for ( String city: list2)
			    	System.out.print(city+ " ");
			    System.out.println();
			    
			    String []lst1 = new String[0];
			    lst1 = list1.toArray(lst1);
			    String []lst2 = new String[0];
			    lst2 = list2.toArray(lst2);
			    
			    lst1 = removeDuplicate(lst1);
			    lst2 = removeDuplicate(lst2);

			    
			    System.out.print("lst1 :");
			    for (String city:lst1)
			    	System.out.print( city + " ");
			    System.out.println();
			    System.out.print("lst2 :");
			    for (String city: lst2)
			    	System.out.print(city + " ");
			    System.out.println();
			    
			    //lst3으로 merge
			    String[]lst3 = new String[lst1.length+lst2.length];
			    
			    int i = 0; 
			    int j = 0; 
			    int k = 0;
			    
			    while(i<lst1.length && j<lst2.length) {
			    	if(lst1[i].compareTo(lst2[j]) < 0) {
			    		lst3[k] = lst1[i];
			    		k++; i++;
			    	} else if (lst1[i].compareTo(lst2[j]) > 0) { 
			    		lst3[k] = lst2[j];
			    		k++; j++;
			    	  } else { 
				    	lst3[k] = lst2[j]; //놓친부분! list1[i] = list2[j]일 때, lst1[i] or lst2[j] 둘 중 하나가 돌아가야한다.
			    	    k++; i++; j++;
			    	  }
			    }
			    
			    while (i < lst1.length) {
			    	lst3[k] = lst1[i];
			    	k++; j++;
			    }
			    while (j < lst2.length) {
			    	lst3[k] = lst2[j];
			    	k++; i++; 
			    }
			 
			    System.out.print("lst3: ");
			    for(int n =0; n <k; n++)
			    	System.out.print(lst3[n]+ " "); //k에서 필요없는 부분(null)을 for반복문 통해서 삭제
			    
				// Iterator 사용한 중복제거
			    ArrayList<String> li3 = new ArrayList<String>();
			    li3.addAll(list1);
			    li3.addAll(list2);

				System.out.println("\n" +"while문 전에 들어있는 리스트: " + li3);
				
//				Iterator<String> iter1 = list1.iterator();
//				while(iter1.hasNext()) {
//					int count = 0;
//					String str1 = (String) iter1.next();
//					for(int a = 0; a < list1.size(); a++) {
//						if(list1.get(a) == str1) {
//							count++;
//						}
//					}
//					if (count >=2 ) {
//						iter1.remove();
//					}
//					count = 0;
//				}

//				Iterator<String> iter2 = list2.iterator();
//				while(iter2.hasNext()) {
//					int count = 0;
//					String str2 = (String) iter2.next();
//					for(int b = 0; b < list2.size(); b++) {
//						if(list2.get(b) == str2) {
//							count++;
//						}
//					}
//					if (count >=2 ) {
//						iter2.remove();
//					}
//					count = 0;
//				}
//				System.out.println("iter1 ::" + list1);
//				System.out.println("iter2 ::" + list2);
				
				Iterator<String> iter3 = li3.iterator();
				while(iter3.hasNext()) { 				  //hasnext(): 보통 순방향으로 이동하는 iterator가 가리키는 데이터저장소의 현재위치에서 이동할 항목이 있는지 체크.
					int count = 0;
					String str3 = (String) iter3.next(); // next(): 중복없이 데이터들을 하나씩 꺼내줌.
					for(int b = 0; b < li3.size(); b++) {
						if(li3.get(b) == str3) {
							count++;
						}
					}
					if (count >=2 ) {
						iter3.remove();
					}
				}
			    Collections.sort(li3);
			    System.out.print("li3 :: ");
			    for ( String city3: li3)
			    	System.out.print(city3+ " ");
	}
	
}