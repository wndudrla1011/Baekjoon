https://www.acmicpc.net/problem/9612

**Maximum Word Frequency (실버 IV)**

**문제**

Term frequency–Inverse document frequency (tf-idf) is a numerical statistic which reflects the importance of words in a document collection. It is often used in information retrieval system. The number of times a word appears in the document (word frequency) is one of the major factors to acquire tf-idf.

You are asked to write a program to find the most frequent word in a document.

**입력**

The first line contains an integer n (1≤ n ≤ 1000) which determines the number of words. The following n lines include the list of words, one word per line. A word contains only lower-case letters and it can contain up to 20 characters.

**출력**

Print out the word that has the highest frequency and its frequency, separated by a single space. If you get more than 2 results, choose only the one that comes later in the lexicographical order.

**Cases**

10<br>
mountain<br>
lake<br>
lake<br>
zebra<br>
tree<br>
lake<br>
zebra<br>
zebra<br>
animal<br>
lakes<br>
output : zebra 3

**알고리즘 분류**

- 자료 구조
- 문자열
- 정렬
- 해시를 사용한 집합과 맵