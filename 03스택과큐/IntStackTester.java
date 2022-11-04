// int형 고정 길이 스택 사용의 예

package 자바자료구조;

import java.util.Scanner;

public class IntStackTester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IntStack s = new IntStack(64);		// 최대 64개를 푸시할 수 있는 스택
		
		while(true) {
			System.out.println();
			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
			System.out.println("(1)푸시 (2)팝 (3)피크 (4)덤프 (0)종료:");
			
			int menu = sc.nextInt();	// 콘솔창에 1~4를 입력
			if(menu == 0) break;		//0 입력시 종료
			
			int x;
			
			switch (menu) {
				case 1:
					System.out.println("데이터: ");
					x = sc.nextInt();
					try {
						s.push(x);
					} catch(IntStack.OverflowIntStackException e) {
						System.out.println("스택이 가득 찼습니다.");
					}
					break;
				case 2:
					try {
						x = s.pop();
						System.out.println("팝한 데이터는 " + x + "입니다.");
					} catch (IntStack.EmptyIntStackException e) {
						System.out.println("스택이 비어있습니다.");
					}
					break;
					
				case 3:
					try {
						x = s.peek();
						System.out.println("피크한 데이터는 " + x + "입니다.");
					} catch (IntStack.EmptyIntStackException e) {
						System.out.println("스택이 비어있습니다.");
					}
					break;
				
				case 4:
					s.dump();
					break;
			}
		}
	}

}
