https://www.acmicpc.net/problem/6159

**코스튬 파티 (실버 V)**

**문제**

한 농부가 할로윈 파티에 그의 소들을 데려가려고한다. 아쉽게도 농부에게는 코스튬이 한벌밖에 없다. 그 코스튬에는 정확하게 사이즈는 S(1 <= S <= 1,000,000)이며, 최대 소 두마리가 들어간다. 농부는 N(2 <= N <= 20,000)마리의 소가 있으며(소의 이름은 편의상 소1.. 소N으로한다), 소i의 사이즈는 (1 <= L_i <= 1,000,000)이다. 만약 소 두마리의 크기 합이 코스튬의 크기 이하인 경우 둘이 코스튬에 들어갈 수 있다. 농부가 코스튬에 얼마나 많은 서로 다른 소의 짝이 들어가는지 구할수있도록 도와주자.

**입력**

첫째 줄에는 정수 N(소의 수)과 S(코스튬의 크기)가 주어진다.

둘째 줄부터는 각 줄에 소들의 크기가 주어진다.

**출력**

첫째 줄에 얼마나 많은 짝이 가능한지 출력한다.

**Cases**

4 6<br>
3<br>
5<br>
2<br>
1<br>
output : 4

**힌트**

위의 문제에서 4개의 짝은 아래와 같다.

- 소1-소3 (사이즈 합:5)
- 소1-소4 (사이즈 합:4)
- 소2-소4 (사이즈 합:6)
- 소3-소4 (사이즈 합:3)

**알고리즘 분류**

- 브루트포스 알고리즘
- 정렬
- 두 포인터