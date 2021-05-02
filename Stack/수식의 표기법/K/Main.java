import java.util.*;
import java.io.*;

class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String postfix = br.readLine();
        
        Double[] operand = new Double[N];
        for(int i = 0; i < N; i++) {
            operand[i] = Double.parseDouble(br.readLine());
        }
      
        Double result = solve(operand, postfix);
        
        System.out.printf("%.2f", result);
    }
    
    private static double solve(Double[] operand, String postfix) {
        Deque<Double> stack = new ArrayDeque<>();
        
        for (char c : postfix.toCharArray()) {
            if (!isOperator(c)) {
                stack.push(operand[c - 'A']);
                continue;
            }
            stack.push(calculate(c, stack));
        }
        
        return stack.pop();
    }
    
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    
    private static Double calculate(char operator, Deque<Double> stack) {
        Double B = stack.pop();
        Double A = stack.pop();
        
        if (operator == '+') {
            return A + B;
        }
        if (operator == '-') {
            return A - B;
        }
        if (operator == '*') {
            return A * B;
        }
        if (operator == '/') {
            return A / B;
        }
        return 0.0;
    }
    
}
