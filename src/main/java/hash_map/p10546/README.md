https://www.acmicpc.net/problem/10546

**배부른 마라토너 (실버 IV)**

**문제**

마라토너라면 국적과 나이를 불문하고 누구나 참가하고 싶어하는 백준 마라톤 대회가 열린다. 42.195km를 달리는 이 마라톤은 모두가 참가하고 싶어했던 만큼 매년 모두가 완주해왔다. 단, 한 명만 빼고!

모두가 참가하고 싶어서 안달인데 이런 백준 마라톤 대회에 참가해 놓고 완주하지 못한 배부른 참가자 한 명은 누굴까?

**입력**

첫째 줄에는 참가자 수 N이 주어진다. (1 ≤ N ≤ 105)

N개의 줄에는 참가자의 이름이 주어진다.

추가적으로 주어지는 N-1개의 줄에는 완주한 참가자의 이름이 쓰여져 있다.

참가자들의 이름은 길이가 1보다 크거나 같고, 20보다 작거나 같은 문자열이고, 알파벳 소문자로만 이루어져 있다.

참가자들 중엔 동명이인이 있을 수도 있다.

**출력**

마라톤을 완주하지 못한 참가자의 이름을 출력한다.

**Cases**

3<br>
leo<br>
kiki<br>
eden<br>
eden<br>
kiki<br>
output : leo

5<br>
marina<br>
josipa<br>
nikola<br>
vinko<br>
filipa<br>
josipa<br>
filipa<br>
marina<br>
nikola<br>
output : vinko

4<br>
mislav<br>
stanko<br>
mislav<br>
ana<br>
stanko<br>
ana<br>
mislav<br>
output : mislav

**알고리즘 분류**

- 자료 구조
- 해시를 사용한 집합과 맵