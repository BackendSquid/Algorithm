import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        
        int gcd = gcd(A, B);
        int lcm = lcm(A, B);
        
        System.out.println(gcd);
        System.out.println(lcm);
    }
    
    private static int gcd(int A, int B) {
        if (A < B) {
            int t = A;
            A = B;
            B = t;
        }
        
        while (A % B != 0) {
            int b = B;
            B = A % B;
            A = b;
        }
        
        return B;
    }
    
    private static int lcm(int A, int B) {
        return (A * B) / gcd(A, B);
    }
}
