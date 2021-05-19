## 서로소 집합(Disjoint Sets)

- 공통 원소가 없는 두 집합
- 서로소 집합 자료구조: 서로소 부분 집합들로 나누어진 원소들의 데이터를 처리하기 위한 자료구조 → 합집합(union)과 찾기(find) 연산으로 조작하기 때문에 union-find 자료구조라고도 부른다.
  - union: 두 개별 집합을 하나의 집합으로 합치는 연산
  - find: 특정한 원소가 속한 집합이 어떠한 집합인지 알려주는 연산
- 무방향 그래프 내에서의 사이클을 판별할 때 사용할 수 있다.



## union-find 알고리즘

1. A와 B의 루트 노드를 찾는다.
2. A의 루트 노드를 B의 부모 노드로 설정한다.
3. 모든 union 연산을 처리할 때까지 1번과 2번을 반복한다.

시간복잡도 : O(VM) 

- V: 노드의 수
- M: find / union 연산의 수



## path compression

- Find를 실행한 노드에서 거쳐간 노드를 root에 바로 연결하는 기법
- Find를 실행한 노드는 root node를 한 번에 알 수 있다.



```java
import java.util.*;

public class Main {

    // 노드의 개수(V)와 간선(Union 연산)의 개수(E)
    // 노드의 개수는 최대 100,000개라고 가정
    public static int v, e;
    public static int[] parent = new int[100001]; // 부모 테이블 초기화하기

    // 특정 원소가 속한 집합을 찾기
    public static int findParent(int x) {
        // 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    // 두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        // 부모 테이블상에서, 부모를 자기 자신으로 초기화
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        // Union 연산을 각각 수행
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            unionParent(a, b);
        }

        // 각 원소가 속한 집합 출력하기
        System.out.print("각 원소가 속한 집합: ");
        for (int i = 1; i <= v; i++) {
            System.out.print(findParent(i) + " ");
        }
        System.out.println();

        // 부모 테이블 내용 출력하기
        System.out.print("부모 테이블: ");
        for (int i = 1; i <= v; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }
}
```

```
6 4
1 4
2 3
2 4
5 6
각 원소가 속한 집합: 1 1 1 1 5 5 
부모 테이블: 1 1 1 1 5 5 
```



## 여행가자

```java
import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

N = int(input()) # 노드 수 입력 받기
M = int(input()) # 정점 수 입력 받기
parent = [0] * (N+1) # 부모 테이블 초기화

# 부모 테이블 상에서 자기 자신을 부모로 설정
for i in range(1, N+1):
    parent[i] = i

def find(a): # a 노드의 부모 노드 찾기
    if a == parent[a]: # a 노드가 부모 노드이면 a 반환
        return a
    p = find(parent[a]) # a 노드를 따라가면서 부모 노드 찾기
    parent[a] = p # 부모 테이블 갱신
    return parent[a]

def union(a, b): # a집합과 b집합 합치기
    a = find(a) # a 노드의 부모 노드 찾기
    b = find(b) # b 노드의 부모 찾기

    if a == b: # 이미 동일한 집합이면 연결시에 순환이 발생
        return

    if a < b: # a의 부모가 b 부모보다 상위 루트이면
        parent[b] = a # b의 부모를 a의 부모로 변경
    else: # b의 부모가 a 부모보다 상위 루트이면
        parent[a] = b # a의 부모 변경

for y in range(1, N+1): # y번째 도시
    maps = list(map(int, input().split())) # y번째 도시가 어느 도시와 연결되어 있는지 정보
    for x in range(1, len(maps)+1): # y도시 연결 정보 추출
        if maps[x-1] == 1: # x 도시와 연결되어 있으면
            union(y, x) # 두 도시를 결합

tour = list(map(int, input().split())) # 여행 계획 정보
result = set([find(i) for i in tour]) # 여행 계획의 루트 노드 찾기
if len(result) != 1: # set 개수가 2개 이상이면 두개의 집합이 존재
    print('NO')
else:
    print('YES') # set 개수가 1이면 한 개의 집합이 존재
```

