package 자바자료구조;

public class IntStack {
	private int[] stk;		//스택용 배열
	private int capacity;	// 스택 용량
	private int ptr;		// 스택 포인터
	
	//실행 시 예외상황을 가정 (1)스택이 비어있음
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {}
	}
	
	//실행 시 예외상황을 가정 (2)스택이 가득 참
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {}
	}
	
	public IntStack(int maxlen) {
		ptr=0;
		capacity = maxlen;
		try {
			stk = new int[capacity];	// 스택 본체용 배열 생성
		} catch (OutOfMemoryError e) {	//생성할 수 없음
			capacity=0;
		}
	}
	
	//스택 마지막에 x를 푸시 했을 때 스택이 가득차 있어 푸시할 수 없는 경우 'OverflowIntStackException'을 발생, stk배열의 pointer를 증가시킨다.
	public int push(int x) throws OverflowIntStackException {
		if(ptr >= capacity)		//스택이 가득차면
			throw new OverflowIntStackException();
		return stk[ptr++] = x;
	}
	
	//스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) 했을 때 스택이 비어 있어 팝 할수 없는 경우 'EmptyIntStackException'를 발생, stk배열의 pointer를 감소시킨다.
	public int pop() throws EmptyIntStackException {
		if(ptr <=0)		//스택이 비면
			throw new EmptyIntStackException();
		return stk[--ptr];
	}
	
	//스택의 꼭대기에 있는 데이터를 들여다 보는데 스택이 비어있으면 'EmptyIntStackException'를 발생, 비어있지 않으면 stk[ptr-1]값을 반환.
	public int peek() throws EmptyIntStackException {
		if (ptr <=0)
			throw new EmptyIntStackException();
		return stk[ptr - 1];
	}
	
	//스택을 비운다
	public void clear() {
		ptr = 0;
	}
	
	// 스택에서 x를 찾아 인덱스 반환. 꼭대기부터 내려옴. (인덱스: 배열 요소-1) x가 없으면 -1 반환
	public int indexOf(int x) {
		for(int i = ptr-1; i>=0; i--)
			if (stk[i]==x)
				return i;	//x찾았을 때
		return -1;			//x찾기 실패
	}
	
	// 스택의 크기 반환
	public int getCapacity() {
		return capacity;
	}
	
	//스택에 쌓여있는 데이터 갯수 반환
	public int size() {
		return ptr;
	}
	
	//스택이 비어있는가? y->true, n->false
	public boolean isEmpty() {
		return ptr<=0;
	}
	
	//스택이 가득 찼는가?
	public boolean isFull() {
		return ptr>=capacity;
	}
	
	// 스택 안의 모든 데이터를 바닥 → 정상 순서로 표시
	public void dump() {
		if (ptr <=0)
			System.out.println("스택이 비어있습니다.");
		else {
			for(int i = 0; i<ptr; i++)
				System.out.println(stk[i] + " ");
			System.out.println();
		}
	}
}
