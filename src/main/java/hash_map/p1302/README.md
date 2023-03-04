https://www.acmicpc.net/problem/1302

**베스트셀러 (실버 IV)**

**문제**

김형택은 탑문고의 직원이다. 김형택은 계산대에서 계산을 하는 직원이다. 김형택은 그날 근무가 끝난 후에, 오늘 판매한 책의 제목을 보면서 가장 많이 팔린 책의 제목을 칠판에 써놓는 일도 같이 하고 있다.

오늘 하루 동안 팔린 책의 제목이 입력으로 들어왔을 때, 가장 많이 팔린 책의 제목을 출력하는 프로그램을 작성하시오.

**입력**

첫째 줄에 오늘 하루 동안 팔린 책의 개수 N이 주어진다. 이 값은 1,000보다 작거나 같은 자연수이다. 둘째부터 N개의 줄에 책의 제목이 입력으로 들어온다. 책의 제목의 길이는 50보다 작거나 같고, 알파벳 소문자로만 이루어져 있다.

**출력**

첫째 줄에 가장 많이 팔린 책의 제목을 출력한다. 만약 가장 많이 팔린 책이 여러 개일 경우에는 사전 순으로 가장 앞서는 제목을 출력한다.

**Cases**

5<br>
top<br>
top<br>
top<br>
top<br>
kimtop<br>
output : top

9<br>
table<br>
chair<br>
table<br>
table<br>
lamp<br>
door<br>
lamp<br>
table<br>
chair<br>
output : table

6<br>
a<br>
a<br>
a<br>
b<br>
b<br>
b<br>
output : a

8<br>
icecream<br>
peanuts<br>
peanuts<br>
chocolate<br>
candy<br>
chocolate<br>
icecream<br>
apple<br>
output : chocolate

1<br>
soul<br>
output : soul

**알고리즘 분류**

- 자료 구조
- 문자열
- 정렬
- 해시를 사용한 집합과 맵