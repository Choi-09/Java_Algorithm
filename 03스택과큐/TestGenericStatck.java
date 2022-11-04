package 자바자료구조;

import java.util.Scanner;

public class TestGenericStatck {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		// 제너릭타입을 쓰면 오류발생! 
		StackGeneric s = new StackGeneric(8);	// 최대 8 개를 푸시할 수 있는 스택
		Point p = new Point(0,0);	
		int rndx = 0, rndy = 0;
	
		while (true) {
			System.out.println(); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", s.size(), s.getCapacity());
			System.out.print("(1)푸시　(2)팝　(3)피크　(4)덤프　(0)종료: ");

			int menu = stdIn.nextInt();
			if (menu == 0)
				break;

			switch (menu) {
			case 1: // 푸시
				System.out.print("데이터: ");
				
				if (s.isFull())
					System.out.println("스택이 가득찼있습니다.");
				else {
					Point px = new Point(0,0);
					s.push(px);
					
					//0~9까지 난수 생성해서 rndx, rndy에 대입
					double d = Math.random()*10;	// rndx 에 난수 생성
					rndx = (int)d;
					
					double d1 = Math.random()*10;	// rndy에 난수 생성
					rndy = (int)d1;
					
					px.setX(rndx);	//rndx를 x에 출력 (.setX)
					px.setY(rndy);	//rndy를 y에 출력 (.setY)
				}
				break;

			case 2: // 팝
				if (s.isEmpty())
					System.out.println("스택이 비어있습니다.");
				else {
					p = s.pop();
					System.out.println("팝한 데이터는 " + p + "입니다.");
				}
				break;

			case 3: // 피크
				if (s.isEmpty())
					System.out.println("스택이 비어있습니다.");
				else {
					p = s.peek();
					System.out.println("피크한 데이터는 " + p + "입니다.");
				}
				break;

			case 4: // 덤프
				s.dump();
				break;
			}
		}
	}
}