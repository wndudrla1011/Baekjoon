package priorityQ.p1927;

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
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}

class Heap {
    int[] heap;
    int size;
    Heap(int size) {
        heap = new int[size + 1];
    }
    void offer(int e) {
        heap[++size] = e; //가장 뒤부터 삽입
        int i = size << 1; //트리 구조 -> 트리 높이만큼 비교
        while ((i >>= 1) > 1) //Down-top 비교
            if (!swap(i)) break; //최소 힙 조건에 맞는지 검사
    }
    int poll() {
        if (size == 0) return 0;
        int e = heap[1]; //리프 노드의 최우측 값
        heap[1] = heap[size--]; //사이즈 줄이고, 가장 마지막 값을 루트로
        int i = 1;
        while ((i <<= 1) <= size) { //Top-down 비교
            if (i < size && heap[i + 1] < heap[i]) i++; //형제 노드 중 작은 값 찾기
            if (!swap(i)) break; //최소 힙 조건에 맞는지 검사
        }
        return e;
    }
    boolean swap(int i) {
        int j = i >> 1; //j : 부모 idx, i : 자식 idx
        int p = heap[j]; //p : 부모 값
        int c = heap[i]; //c : 자식 값
        if (p < c) return false; //부모가 자식보다 크면 최소 힙
        heap[j] = c; //swap
        heap[i] = p; //swap
        return true; //swap 했으므로, 재 검사 필요
    }
}
