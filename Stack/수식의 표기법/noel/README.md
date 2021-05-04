

[TOC]

# 수식의 표기법

- **카테고리: Stack**



- 수식의 표기법은 연산자의 위치에 따라 `전위, 후위, 중위` 표기법으로 분류된다.

  

  - ##### 전위 표기법(Prefix Notation) `++1*23+1/22`

    - 쉽게 결정되는 연산 순서

    - 연산의 우선순위 등을 신경쓰지 않아도 됨. (괄호 불필요)

      

  - ##### 중위 표기법(Infix Notation) `((1+(2*3))+(1+(2/2)))`

    - 친숙함

      

  - ##### 후위 표기법(Postfix Notation) `123*+42+2/+`

    - 쉽게 결정되는 연산 순서
  - 연산의 우선순위 등을 신경쓰지 않아도 됨. (괄호 불필요)

  > ** 갑자기 궁금한건대 10의자리 이상 계산은 어떻게 표기 해야하는거지?..

  

- 컴퓨터가 수식을 처리 하기에 가장 효율적인 방법은 후위 표기법이다.

  > #### 전위 vs 후위 
  >
  > 그냥 사용할 때는 전위방식이 연산자가 앞에 위치하기 때문에 사람이 읽거나 쓸때 후위방식보다 편한 것을 볼 수 있다. (???)
  >
  > 이 때문에 Lisp 계열의 언어는 전위 방식을 택했다.
  >
  > 반면, 후위표기방식은 앞부터 끝까지 그대로 읽어가며 해석할 수 있으므로 단순무식한 우리의 컴퓨터에게 유리한 방식이다.
  > 그래서인지 HP의 계산기는 RPN방식을 사용하기도 하고, 컴파일러를 만들때도 후위표기 방식을 사용하는 것으로 알고 있다.
  >
  > 어쨌든 전위와 후위방식의 가장 큰 장점은 ‘48÷2(9+3)’ 사건 같은 일이 일어날 여지가 없다는 것.
  >
  > https://black7375.tumblr.com/post/169264990885/%EC%A0%84%EC%9C%84-%EC%A4%91%EC%9C%84-%ED%9B%84%EC%9C%84-%ED%91%9C%EA%B8%B0%EB%B2%95

  

## 관련예제①

>  https://www.acmicpc.net/problem/1935

## 접근 방식

> #### 후위 표기 수식의 연산
>
> (1) 피연산자를 만나면 스택에 삽입
>
> (2) 연산자를 만나면 필요한 만큼의 피연산자를 스택에서 pop 하여 연산하고, 연산 결과를 다시 스택에 삽입
>
> (3) 수식이 끝나면, 마지막으로 스택을 pop 하여 출력

## 코드 작성

```java
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();

        double[] values = new double[N];

        for (int i = 0; i < values.length; i++) {
            values[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        double result = 0.0;

        for (char c : input) {
            if (Character.isAlphabetic(c)) {
                stack.push(values[(c - 65)]);  // 유니코드 A: 65
            } else {
                if (stack.size() > 1) {

                    double operand1 = stack.pop();
                    double operand2 = stack.pop();

                    switch (c) {

                        case '+':
                            stack.push((operand2 + operand1));
                            break;
                        case '-':
                            stack.push(operand2 - operand1);
                            break;
                        case '*':
                            stack.push(operand2 * operand1);
                            break;
                        case '/':
                            stack.push(operand2 / operand1);
                            break;

                    }
                }

            }
        }

        if(!stack.isEmpty()) {
            bw.write(String.format("%.2f",stack.pop()));
        }

        bw.flush();
    }

}

```

----



## 관련예제②

> #### 중위표기식을 후위표기식으로 변환
>
> https://www.acmicpc.net/problem/1918





---

## 참고링크



https://songeunjung92.tistory.com/22

https://comdolidol-i.tistory.com/46

https://reakwon.tistory.com/62