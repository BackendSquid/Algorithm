# 섬의 개수

- https://leetcode.com/problems/letter-combinations-of-a-phone-number/

## Back-Tracking(백트래킹)

- 그래프 탐색을 하다가 더 갈 수 없으면 왔던 길을 되돌아가 다른길을 찾는다.
- DFS 보다 더 광의의 의미를 가진 기법
- **Recursion(재귀)**와 **Pruning(가지치기)** 가 핵심
- 가능성이 없는 후보를 즉시 포기 하는 것을 Pruning 이라고 한다.
- Pruning 을 잘할 수록 알고리즘 성능이 올라간다.
- 파이썬 알고리즘 인터뷰 p.328

### CSP (Constraint Satisfaction Problems, 제약 충족 문제)

- 백트래킹으로 풀기 적합한 문제
- 수많은 제약 조건(Constraints)을 충족하는 상태(States)를 찾아내는 문제
- 특정 조건을 만족하는 조합을 찾아내는 문제를 백트래킹으로 풀기 적합하다.
- 백트래킹으로 풀때는 DFS 를 활용하면 좋다.
