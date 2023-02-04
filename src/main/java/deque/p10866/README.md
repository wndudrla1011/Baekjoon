https://www.acmicpc.net/problem/10866

**덱 (실버 IV)**

**문제**

정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 여덟 가지이다.

- push_front X: 정수 X를 덱의 앞에 넣는다.
- push_back X: 정수 X를 덱의 뒤에 넣는다.
- pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
- pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
- size: 덱에 들어있는 정수의 개수를 출력한다.
- empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
- front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
- back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.

**입력**

첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

**출력**

출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.

**Cases**

15<br>
push_back 1<br>
push_front 2<br>
front<br>
back<br>
size<br>
empty<br>
pop_front<br>
pop_back<br>
pop_front<br>
size<br>
empty<br>
pop_back<br>
push_front 3<br>
empty<br>
front<br>
output :<br>
2<br>
1<br>
2<br>
0<br>
2<br>
1<br>
-1<br>
0<br>
1<br>
-1<br>
0<br>
3<br>

22<br>
front<br>
back<br>
pop_front<br>
pop_back<br>
push_front 1<br>
front<br>
pop_back<br>
push_back 2<br>
back<br>
pop_front<br>
push_front 10<br>
push_front 333<br>
front<br>
back<br>
pop_back<br>
pop_back<br>
push_back 20<br>
push_back 1234<br>
front<br>
back<br>
pop_back<br>
pop_back<br>
output :<br>
-1<br>
-1<br>
-1<br>
-1<br>
1<br>
1<br>
2<br>
2<br>
333<br>
10<br>
10<br>
333<br>
20<br>
1234<br>
1234<br>
20<br>

**알고리즘 분류**

- 자료 구조
- 덱