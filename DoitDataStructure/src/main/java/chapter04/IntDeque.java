package chapter04;
// int형 고정 길이 큐

public class IntDeque {
    private int[] deque;            // 덱용 배열
    private int capacity;         // 덱의 크기
    private int front;            // 맨 처음 요소 커서
    private int rear;             // 맨 끝 요소 커서
    private int num;              // 현재 데이터 개수

    //--- 실행시 예외: 큐가 비어있음 ---//
    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() { }
    }

    //--- 실행시 예외: 큐가 가득 찼음 ---//
    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() { }
    }

    //--- 생성자(constructor) ---//
    public IntDeque(int maxlen) {
        num = 0;
        front = 0;
        rear = 1;
        capacity = maxlen;
        try {
            deque = new int[capacity];          // 큐 본체용 배열을 생성
        } catch (OutOfMemoryError e) {        // 생성할 수 없음
            capacity = 0;
        }
    }


    //--- 큐에 데이터를 인큐 ---//
    public int enqueFront(int x) throws OverflowIntQueueException {
        if (num >= capacity)
            throw new OverflowIntQueueException();            // 큐가 가득 찼음
        deque[front--] = x;
        num++;
        if (front < 0) {
            front = capacity - 1;
        }
        return x;
    }

    public int enqueRear(int x) throws OverflowIntQueueException {
        if (num >= capacity)
            throw new OverflowIntQueueException();            // 큐가 가득 찼음
        deque[rear++] = x;
        num++;
        if (rear == capacity) {
            rear = 0;
        }
        return x;
    }

    //--- 큐에서 데이터를 디큐 ---//
    public int dequeFront() throws EmptyIntQueueException {
        if (num <= 0)
            throw new EmptyIntQueueException();            // 큐가 비어있음
        front++;
        if (front == capacity)
            front = 0;
        int x = deque[front];
        num--;
        return x;
    }

    public int dequeRear() throws EmptyIntQueueException {
        if (num <= 0)
            throw new EmptyIntQueueException();            // 큐가 비어있음
        rear--;
        if (rear < 0)
            rear = capacity - 1;
        int x = deque[rear];
        num--;
        return x;
    }

    //--- 큐에서 데이터를 피크(프런트 데이터를 들여다봄) ---//
    public int front() throws EmptyIntQueueException {
        if (num <= 0)
            throw new EmptyIntQueueException();            // 큐가 비어있음
        return deque[front];
    }

    public int rear() throws EmptyIntQueueException {
        if (num <= 0)
            throw new EmptyIntQueueException();            // 큐가 비어있음
        return deque[rear];
    }

    //--- 큐를 비움 ---//
    public void clear() {
        num = front = rear = 0;
    }

    //--- 큐에서 x를 검색하여 인덱스(찾지 못하면 –1)를 반환 ---//
    public int indexOf(int x) {
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % capacity;
            if (deque[idx] == x)                // 검색 성공
                return idx;
        }
        return -1;                            // 검색 실패
    }

    //--- 큐의 크기를 반환 ---//
    public int getCapacity() {
        return capacity;
    }

    //--- 큐에 쌓여 있는 데이터 개수를 반환 ---//
    public int size() {
        return num;
    }

    //--- 큐가 비어있는가? ---//
    public boolean isEmpty() {
        return num <= 0;
    }

    //--- 큐가 가득 찼는가? ---//
    public boolean isFull() {
        return num >= capacity;
    }

    //--- 큐 안의 모든 데이터를 프런트 → 리어 순으로 출력 ---//
    public void dump() {
        if (num <= 0)
            System.out.println("큐가 비어있습니다.");
        else {
            for (int i = 0; i < num; i++)
                System.out.print(deque[(i + front + 1) % capacity] + " ");
            System.out.println();
        }
    }

    public void printDeque() {
        for (int i = 0; i < deque.length; i++) {
            System.out.print(deque[i] + " ");
        }
        System.out.println();
        System.out.println("front: " + front);
        System.out.println("rear: " + rear);
    }
}