package graph.p14226;

import java.io.IOException;
import java.util.*;

public class Main {

    static boolean[][] visited = new boolean[2001][2001]; //방문 체크 (행 : 화면 이모티콘 개수, 열 : 클립보드 이모티콘 개수)
    static int S; //타깃 값

    public static void main(String[] args) throws IOException {
        S = readInt();
        BFS();
    }

    static void BFS() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1, 0, 0)); //Root 노드

        while (!q.isEmpty()) {
            Node now = q.poll();
            int emoticon_num = now.val;
            int clipboard_num = now.clipboard;
            int time = now.timer;

            if (emoticon_num == S) {
                System.out.println(time);
                return;
            }

            if (emoticon_num > 0 && emoticon_num < 2000) {
                //1. 복사
                if (!visited[emoticon_num][emoticon_num]) {
                    visited[emoticon_num][emoticon_num] = true;
                    q.offer(new Node(emoticon_num, emoticon_num, time + 1));
                }

                //3. 삭제
                if (!visited[emoticon_num - 1][clipboard_num]) {
                    visited[emoticon_num - 1][clipboard_num] = true;
                    q.offer(new Node(emoticon_num - 1, clipboard_num, time + 1));
                }
            }

            //2. 붙여넣기
            if (clipboard_num > 0 && emoticon_num + clipboard_num < 2000) {
                if (!visited[emoticon_num + clipboard_num][clipboard_num]) {
                    visited[emoticon_num + clipboard_num][clipboard_num] = true;
                    q.offer(new Node(emoticon_num + clipboard_num, clipboard_num, time + 1));
                }
            }
        }
    }

    static class Node {
        int val;
        int clipboard;
        int timer;

        public Node(int val, int clipboard, int timer) {
            this.val = val;
            this.clipboard = clipboard;
            this.timer = timer;
        }
    }

    static int readInt() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
