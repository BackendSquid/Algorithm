```python
import unittest
import re
import collections
from typing import List


def most_common_word(paragraph: str, banned: List[str]):
    print(re.sub(r'[^\w]', ' ', paragraph))
    words = [word for word in re.sub(r'[^\w]', ' ', paragraph)
             .lower().split()
             if word not in banned]

    counts = collections.defaultdict(int)

    for word in words:
        counts[word] += 1

    return max(counts, key=counts.get)


class CaseOne(unittest.TestCase):

    def test_case_one(self):
        self.assertEqual(most_common_word("Bob hit a ball, the hit BALL flew far after it was hit", ["hit"]), "ball")

```
