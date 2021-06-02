# 삽입 정렬 오름 차순 / 내림차순 문제풀이

삽입 정렬이랑 앞에 값과 뒤의 값을 하나하나씩 비교해가며, 정렬해 나가는 방식이다. 

즉 한마디로 진정한 노가다 방식이라고 생각하면 된다. 만약 아래 B 와 같은 배열이 주어졌다고 생각했을때

26을 움직이기 위해서는 앞전 인덱스인 59와 비교 그리고 옮긴 뒤 41과 비교... 를 반복하다 결국 31 의 앞자리까지 오게 될것이다.

이것을 간단한 의사코드로 표현하면 아래와 같을 것이다.

## Pseudo Code

```
for i in 1...array.length

    curVal = array[i];
    befidx = i - 1;
    while i >= 0 AND array[befidx] > curVal
        array[befidx+1] = array[befidx]
        befidx = befidx - 1;
        array[befidx+1] = curVal
    end

end
```

## Code - TypeScript

```typescript
const B : number[] = [31, 41, 59, 26, 41, 58];


const get = (array: number[], order: 'DESC' | 'ASC') => {
    for(let i = 1; i < array.length; i++) {
        let curValue = array[i];
        let befIdx = i - 1;
        while (befIdx >= 0 && (order === 'DESC') ? array[befIdx] > curValue : array[befIdx] < curValue) {
            array[befIdx+1] = array[befIdx];
            befIdx -= 1;
            array[befIdx+1] = curValue;
        }
    }
    return array;
}

console.log(get(B, 'ASC'));
```