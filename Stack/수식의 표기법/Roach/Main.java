package BackjunJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 1. 피연산자를 만나면 stack 에 대입한다. 2. 연산자가 나오면 stack 에서 pop 하여 계산한다.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, Double> valueMap = new HashMap<>();
        Stack<Double> opStack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        char[] cs = br.readLine().toCharArray();

        for (char c : cs) {
            if (Character.isAlphabetic(c)) {
                if (!valueMap.containsKey(c)) {
                    valueMap.put(c, Double.parseDouble(br.readLine()));
                }
            }
        }

        for (char c : cs) {
            if (Character.isAlphabetic(c)) {
                opStack.push(valueMap.get(c));
            } else if (opStack.size() > 1) {
                double a = opStack.pop();
                double b = opStack.pop();

                switch (c) {
                case '+':
                    opStack.push(b + a);
                    break;
                case '*':
                    opStack.push(b * a);
                    break;
                case '-':
                    opStack.push(b - a);
                    break;
                case '/':
                    opStack.push(b / a);
                    break;
                }
            }
        }
        System.out.printf("%.2f%n", opStack.pop());
    }

}
