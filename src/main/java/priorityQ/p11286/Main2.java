package priorityQ.p11286;

public class Main2 {

    public static void main(String[] args) throws Exception {
        int N = read();
        Heap heap = new Heap(N);
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            int c = read();
            if (c == 0) {
                sb.append(heap.poll()).append('\n');
                continue;
            }
            heap.offer(c);
        }
        System.out.print(sb);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }

}

class Heap {
    int[] heap;
    int size;
    Heap(int l) {
        heap = new int[l + 1];
    }
    void offer(int e) {
        heap[++size] = e; //가장 뒤부터 삽입
        int i = size << 1; //트리 구조 -> 트리 높이만큼 비교
        while ((i >>= 1) > 1) //Down-top 비교
            if (!swap(i)) break; //절댓값 힙 조건에 맞는지 검사
    }
    int poll() {
        if (size == 0) return 0;
        int e = heap[1]; //리프 노드의 최우측 값
        heap[1] = heap[size--]; //사이즈 줄이고, 가장 마지막 값을 루트로
        int i = 1;
        while ((i <<= 1) <= size) { //Top-Down 비교
            if (i < size && compare(i + 1, i)) i++; //형제 노드 중 작은 절댓값 찾기 (좌측이 작으면 i++)
            if (!swap(i)) break; //절댓값 힙 조건에 맞는지 검사
        }
        return e;
    }

    boolean swap(int i) {
        int j = i >> 1; //j : 부모 idx, i : 자식 idx
        int p = heap[j]; //p : 부모 값
        int c = heap[i]; //c : 자식 값
        if (compare(j, i)) return false; //부모가 자식보다 절댓값이 작으면 조건 만족
        heap[j] = c; //swap
        heap[i] = p; //swap
        return true; //swap 했으므로, 재 검사 필요
    }

    boolean compare(int i, int j) {
        int a = heap[i];
        int b = heap[j];
        if (a < 0) a = ~a + 1; //2의 보수 (음수 -> 양수)
        if (b < 0) b = ~b + 1; //2의 보수 (음수 -> 양수)
        if (a == b) return heap[i] < heap[j]; //절댓값이 같으므로 원소 값의 오름차순
        return a < b; //절댓값의 오름차순
    }
}