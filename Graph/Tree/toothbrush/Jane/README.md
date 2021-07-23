
# Programmers 다단계 칫솔 판매


- https://programmers.co.kr/learn/courses/30/lessons/77486

```py
def solution(enroll, referral, seller, amount):
    answer = []
    reversed_tree = dict()
    profits = dict()

    for i in range(len(enroll)):
        reversed_tree[enroll[i]] = referral[i]
        profits[enroll[i]] = 0

    for i in range(len(seller)):
        s = seller[i]
        profit = amount[i] * 100
        # 추천인이 존재하는 경우
        while not s == '-':
            current_profit = profits[s]
            added_profit = profit

            # 이익의 10%가 1원 이상일 경우 현재 셀러는 90%를 갖는다.
            if profit >= 10:
                added_profit -= profit // 10

            profits[s] = current_profit + added_profit

            # 이익의 10%가 1원 미만일 경우 위의 추천인들은 받을 몫이 없다.
            if profit < 10:
                break

            # s를 추천인으로 업데이트
            s = reversed_tree[s]
            profit = profit // 10

    answer = list(profits.values())
    print(answer)
    return answer

solution(["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"],
         ["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"],
         ["young", "john", "tod", "emily", "mary"],
         [12, 4, 2, 5, 10])
```

- 다른 사람 풀이
  - [Enumerate() in Python](https://www.geeksforgeeks.org/enumerate-in-python/)

```py
def solution(enroll, referral, seller, amount):
    answer = [0] * len(enroll)
    idx_list = {}
    for idx, name in enumerate(enroll):
        idx_list[name] = idx
    for idx, name in enumerate(seller):
        price = 100 * amount[idx]
        answer[idx_list[name]] += price
        while referral[idx_list[name]] != "-":
            answer[idx_list[name]] -= price // 10
            name = referral[idx_list[name]]
            answer[idx_list[name]] += price // 10
            price = price // 10
            if price == 0:
                break
        answer[idx_list[name]] -= price // 10
    return answer
```
