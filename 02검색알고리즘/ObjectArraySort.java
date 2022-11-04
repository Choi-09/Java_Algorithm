package 자바자료구조;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

 
public class ObjectArraySort {
	public static void main(String[] args) {
		
	String[] s = { "sort", "string", "array" };
	Arrays.sort(s);
	Arrays.sort(s, Comparator.naturalOrder());
	Arrays.sort(s, Comparator.reverseOrder()); 
	
	Arrays.sort(s, new Comparator<String>() {
	    @Override
	    public int compare(String o1, String o2) {
	        return o2.compareTo(o1);            // 내림차순으로 정렬
	    }
	});
	
	s = Arrays.stream(s).sorted().toArray(String[]::new);	
	s = Arrays.stream(s).sorted(Collections.reverseOrder()).toArray(String[]::new);
	Collections.sort(Arrays.asList(s));
	
	Fruit[] arr = {
	        new Fruit("사과", 200),
	        new Fruit("키위", 500),
	        new Fruit("오렌지", 200),
	        new Fruit("바나나", 50),
	        new Fruit("수박", 880),
	        new Fruit("체리", 10)
	};
	
    System.out.println();
    System.out.println("정렬전::");
    for ( Fruit city: arr)
    	System.out.print(" " + city);
    System.out.println();

    
//구현 - 정렬
    Arrays.sort(arr);
    System.out.println();
    System.out.println("정렬후::");
    for ( Fruit city: arr)
    	System.out.print(" " + city);
    System.out.println();

	ArrayList<Fruit> lst1 = new ArrayList<Fruit>(Arrays.asList(arr)); //Fruit[]arr을 리스트로 바꿔서 객체생성
	ArrayList<Fruit> lst2 = new ArrayList<Fruit>();//Fruit 
	lst2.add(new Fruit("복숭아", 200));
	lst2.add(new Fruit("포도", 300));
	lst2.add(new Fruit("참외", 100));
	lst2.add(new Fruit("딸기", 50));
	lst2.add(new Fruit("블루베리", 500));
	lst2.add(new Fruit("구지뽕", 300));
	
	System.out.println();
	System.out.println("새로운 리스트2 정렬전::");
    for ( Fruit city: lst2)
    	System.out.print(" " + city);
    System.out.println();
  
    
    Collections.sort(lst2);
	System.out.println();
	System.out.println("새로운 리스트2 정렬후::");
    for ( Fruit city: lst2)
    	System.out.print(" " + city);
    System.out.println();

    
//구현- merge를 iterator 사용()    
    ArrayList<Fruit> lst3 = new ArrayList<Fruit>();  //lst3 빈 바구니(객체) 만들어주기
    
    // 비어있는 lst3.
	System.out.println("\n" + "lst3" + lst3); 
	
//	  Iterator: 자바의 컬렉션(Collection)에 저장되어 있는 요소들을 순회하는 인터페이스
	Iterator<Fruit> iter1 = lst1.iterator(); //제너럴타입 Fruit 순회준비. 
	Iterator<Fruit> iter2 = lst2.iterator(); // 제너럴타입 Fruit 순회준비
	
	Fruit data1 = iter1.next();
	Fruit data2 = iter2.next();
	
	while (iter1.hasNext() && iter2.hasNext())  {
		if(data1.compareTo(data2)<0) {
		lst3.add(data1);
		data1=iter1.next();
		} else if(data1.compareTo(data2)>0) {
			lst3.add(data2);
			data2=iter2.next();
		} else {lst3.add(data2);
			data1 = iter1.next();
			data2 = iter2.next();
		}
	}	
	
	while(iter1.hasNext()) {
		if(data1.compareTo(data2)<0) {
			lst3.add(data1);
			data1=iter1.next();
			} else if(data1.compareTo(data2)>0) {
				lst3.add(data2);
				while (iter1.hasNext()) {
					lst3.add(data1);
					data1 = iter1.next();
				}
				lst3.add(data1);
			} else if (data1.compareTo(data2) == 0){
				while(iter1.hasNext()) {
					lst3.add(data1);
					data1=iter1.next();
				}
				lst3.add(data1);
			}
		
		while(iter2.hasNext()) {
			if(data1.compareTo(data2)<0) {
				lst2.add(data2);
				data2=iter2.next();
			} else if(data1.compareTo(data2)>0) {
				lst3.add(data1);
				while(iter2.hasNext()) {
					lst2.add(data2);
					data2 = iter2.next();
				}
				lst3.add(data2);
			} else if(data1.compareTo(data2)==0) {
				while(iter2.hasNext()) {
					lst3.add(data2);
					data2=iter2.next();
				}
				lst3.add(data2);
			}
		}
	}

	System.out.println();
    System.out.println("merge:: ");
    for ( Fruit city: lst3)
    	System.out.print(city+ " ");
    System.out.println();

//binary search - Comparator를 사용한 구현    
    Fruit newFruit = new Fruit("참외", 100);
    Comparator<Fruit> cc= new Comparator<Fruit>() {
    	public int compare(Fruit u1, Fruit u2) {
    		return u1.compareTo(u2);
    	}
    };
       
    System.out.println();
    int result =Collections.binarySearch(lst3, newFruit, cc);
		System.out.println("조회결과 :"+ result);
    
	}
 }
