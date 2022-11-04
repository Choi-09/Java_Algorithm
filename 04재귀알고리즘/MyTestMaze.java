package 자바자료구조;

//1. 좌표 클래스
class Items2 {
	public int x;
	public int y;
	public int dir;

	public Items2(int x, int y, int dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	public String toString() {
		return "<" + x + ", " + y + ", " + dir + ">";
	}
}

//2. 이동방향 클래스
class offsets2 {	
	public int a;	
	public int b;
	public offsets2(int ax, int by) {
		a = ax; b = by;	//a:x축 이동, b:y축이동
	}
}

//2. 메인클래스
public class Chap5_MyTestMaze {

	static offsets2 moves[] = new offsets2[8];	//이동방향을 나타내는 offesets2클래스 객체 배열로 만들기.

	public static int[][] maze = new int[100][100];	//maze를 100*100 배열로 빈공간 지정
	public static int[][] mark = new int[100][100]; //mark를 100*100 배열로 빈공간 지정

	public static void path(int[][] maze, int[][] mark, int ix, int iy) {

		mark[1][1] = 1;	// 
		StackMaze st = new StackMaze(12*15);	//12*15크기의 메이즈를 만듬
		Items2 temp = new Items2(1, 1, 2);	//Items2라는 스택을 temp에 담는데 초기값은 [1,1]에서 왼쪽 대각선 아래방향으로 시작.
//		temp.x = 1;
//		temp.y = 1;
//		temp.dir = 2;
		st.push(temp);	// temp(1,1,2)
		System.out.println("push()::"+temp.toString());

		while (!st.isEmpty()) // stack이 비어있지 않으면
		{
			temp = st.pop(); // stack pop.
			int i = temp.x;	// i: 현재 x좌표
			int j = temp.y;	// j: 현재 y좌표
			int d = temp.dir;	// d: 이동해야할 좌표
			System.out.println("pop()::"+temp.toString());
			
			while (d < 8) // moves forward
			{ // outFile << i << " " << j << " " << d << endl;
				int g = i + moves[d].a;	// g는 i가 움직인 이후 x좌표
				int h = j + moves[d].b;	// h는 j가 움직인 이후 y좌표
				if ((g == 12) && (h == 15)) { // 출구에 도착하면
												// output path
					System.out.println("the term near the exit: " + ix + " " + i + j);
					System.out.println("exit: " + ix + " " + iy);
					return;
				}
				if ((maze[g-1][h-1] == 0) && (mark[g][h] == 0)) { // maze가 0 이고 온 적도 없으면(mark==0)
					
					Items2 temp2 = new Items2(i, j, d+1);
					mark[g][h] = 1;
					temp2.x = i;  temp2.y = j; temp2.dir = d + 1;
					st.push(temp2); // stack it
					System.out.println("push()::"+temp2.toString());
					i = g; j = h; d = 0;
					
				} else
					d++; // try next direction
			}
		}
		System.out.println("no path in maze ");
	}

// 3. 메인 메소드
	public static void main(String[] args) {
		int[][] maze = new int[100][100];
		int[][] mark = new int[100][100];

	int input[][] = { // 12 x 15
				{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 }, 
				{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 }, 
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 }, 
				{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, 
				{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }, };
	
	for(int ia = 0; ia < 8; ia++) 
		moves[ia]= new offsets2(0,0);
	
		//moves[0] : 왼쪽으로 한 칸 
		moves[0].a=-1;
		moves[0].b=0;
		//moves[1] : 왼쪽 한 칸, 아래로 한 칸 
		moves[1].a=-1;
		moves[1].b=1;
		// moves[2] : 아래로 한 칸 
		moves[2].a=0;
		moves[2].b=1;
		// moves[3] : 오른쪽 한 칸, 아래로 한 칸 
		moves[3].a=1;
		moves[3].b=1;
		// moves[4] : 오른쪽 한칸 
		moves[4].a=1;
		moves[4].b=0;
		// moves[5]: 오른쪽 한 칸, 위로 한 칸 
		moves[5].a=1;
		moves[5].b=-1;
		// moves[6] : 위로 한 칸 
		moves[6].a=0;
		moves[6].b=-1;
		// moves[7]: 왼쪽으로 한 칸, 위로 한 칸 
		moves[7].a=-1;
		moves[7].b=-1;
	
	for(int i = 0; i < 14; i++) {		
		for (int j = 0; j < 17; j++) {
			if ((i == 0) || (j == 0) || (i == 13) || (j == 16))	//12*15 크기의 메이즈 주변을 1로 감싼다.
				maze[i][j] = 1;
			else {
				maze[i][j] = input[i - 1][j - 1]; //maze[1][1] = input[0][0] 이다.
			}
			mark[i][j] = 0;
		}
	}
	System.out.println("maze[12,15]::");	//① maze 12*15 출력	
	for(int i = 0; i < 14; i++){  
		for (int j = 0; j < 17; j++) {
			System.out.print(maze[i][j] + " ");
		}
		System.out.println();
	}
	
	System.out.println("mark::");		//② mark 출력
	for(int i = 0; i <=13; i++){
			for (int j = 0; j <= 16; j++) {
				System.out.print(mark[i][j] + " ");
			}
			System.out.println();
	}
	
	path(maze, mark, 12, 15);
		System.out.println("mark::");
		for (int i = 1; i <= 12; i++) {
			for (int j = 1; j <= 15; j++) {
				System.out.print(mark[i][j] + " ");
			}
			System.out.println();
		}

	}
}