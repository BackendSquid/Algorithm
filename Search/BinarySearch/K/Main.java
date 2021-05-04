import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        Set<Integer> bst = new TreeSet<>();
        
        for (int i = 0; i < N; i++) {
            bst.add(sc.nextInt());
        }
        
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            if (bst.contains(sc.nextInt())) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
        
    }
    
}
