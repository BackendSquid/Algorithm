# https://leetcode.com/problems/valid-palindrome/

from .sol1_1 import Solution as Solution1
from .sol1_2 import Solution as Solution2
from .sol1_3 import Solution as Solution3

def test(solution) -> bool:
    trueExpected = solution.isPalindrome("A man, a plan, a canal: Panama")
    falseExpected = solution.isPalindrome("race a car")
    # print(trueExpected)
    # print(falseExpected)
    return trueExpected and not falseExpected

def printTest(solution, tag: str):
    result = "Pass: " if test(solution) is True else "Fail: "
    print(result + tag)

def test_1():
    printTest(Solution1(), "1_1")
    printTest(Solution2(), "1_2")
    printTest(Solution3(), "1_3")

test_1()
