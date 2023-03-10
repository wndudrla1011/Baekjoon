https://www.acmicpc.net/problem/22862

**가장 긴 짝수 연속한 부분 수열 (large) (골드 V)**

**문제**

길이가 N인 수열 S가 있다. 수열 S는 1 이상인 정수로 이루어져 있다. 수열 S에서 원하는 위치에 있는 수를 골라 최대 K번 삭제를 할 수 있다. 예를 들어, 수열 S가 다음과 같이 구성되어 있다고 가정하자.

> 수열 S : 1 2 3 4 5 6 7 8

수열 S에서 4번째에 있는 4를 지운다고 하면 아래와 같다.

> 수열 S : 1 2 3 5 6 7 8 

수열 S에서 최대 K번 원소를 삭제한 수열에서 짝수로 이루어져 있는 연속한 부분 수열 중 가장 긴 길이를 구해보자.

**입력**

수열 S의 길이 N와 삭제할 수 있는 최대 횟수인 K가 공백으로 구분되어 주어진다. 두 번째 줄에는 수열 S를 구성하고 있는 N개의 수가 공백으로 구분되어 주어진다.

**출력**

수열 S에서 최대 K번 원소를 삭제한 수열에서 짝수로 이루어져 있는 연속한 부분 수열 중 가장 긴 길이를 출력한다.

**제한**

- 1 <= N <= 1,000,000
- 1 <= K <= 100,000
- 1 <= 원소의 값 <= 10^6

**Cases**

8 2<br>
1 2 3 4 5 6 7 8<br>
output : 3

**알고리즘 분류**

- 두 포인터