# https://www.acmicpc.net/problem/12865

import sys

def zero_one_knapsack(cargo, capacity):
    dp = []

    for i in range(len(cargo) + 1):
        dp.append([])
        for j in range(capacity + 1):
            weight = cargo[i - 1][0]
            value = cargo[i - 1][1]
            if i ==0 or j == 0:
                dp[i].append(0)
            elif weight <= j:
                dp[i].append(max(
                    value + dp[i - 1][j - weight],
                    dp[i - 1][j]
                ))
            else:
                dp[i].append(dp[i - 1][j])

    return dp[-1][-1]

# cargo = [(12, 4), (1, 2), (4, 10), (1, 1), (2, 2)]
# capacity = 15
# actual = zero_one_knapsack(cargo, capacity)
# expected = 15
# if actual == expected:
#     print("Pass")
# else:
#     print("Expect "+ 15 + ", Actual: " + actual)

readline = sys.stdin.readline
N, K = map(int, readline().split())
cargo = [tuple(map(int, readline().split())) for _ in range(N)]
print(zero_one_knapsack(cargo, K))

# 5 15
# 12 4
# 1 2
# 4 10
# 1 1
# 2 2
# Answer: 15
