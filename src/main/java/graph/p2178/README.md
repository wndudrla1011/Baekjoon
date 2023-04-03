https://www.acmicpc.net/problem/2178

**미로 탐색(실버 I)**

**문제**

N×M크기의 배열로 표현되는 미로가 있다.

| 1   | 0   | 1   | 1   | 1   | 1   |
|-----|-----|-----|-----|-----|-----|
| 1   | 0   | 1   | 0   | 1   | 0   |
| 1   | 0   | 1   | 0   | 1   | 1   |
| 1   | 1   | 1   | 0   | 1   | 1   |

미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.

위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

**입력**

첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.

**출력**

첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.

**Cases**

4 6<br>
101111<br>
101010<br>
101011<br>
111011<br>
output : 15

4 6<br>
110110<br>
110110<br>
111111<br>
111101<br>
output : 9

2 25<br>
1011101110111011101110111<br>
1110111011101110111011101<br>
output : 38

7 7<br>
1011111<br>
1110001<br>
1000001<br>
1000001<br>
1000001<br>
1000001<br>
1111111<br>
output : 13

**알고리즘 분류**

- 그래프 이론
- 그래프 탐색
- 너비 우선 탐색