import java.util.*;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
        int K = sc.nextInt();
        
        int W = 0;
        int V = 1;
        
        int[][] items = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            items[i][W] = sc.nextInt(); // W
            items[i][V] = sc.nextInt(); // V
        }
        
        int[][] table = new int[N + 1][K + 1];
        
        for (int numOfItem = 0; numOfItem < N + 1; numOfItem++) {
            for (int capacity = 0; capacity < K + 1; capacity++) {
                if (numOfItem == 0 || capacity == 0) {
                    continue;
                }
                int itemIndex = numOfItem - 1;
                int itemW = items[itemIndex][W];
                int itemV = items[itemIndex][V];
                
                if (itemW <= capacity) {
                    table[numOfItem][capacity] = Integer.max(
                        itemV + table[numOfItem - 1][capacity - itemW],
                        table[numOfItem - 1][capacity]
                    );
                } else {
                    table[numOfItem][capacity] = table[numOfItem - 1][capacity];
                }
            }
        }
        
        System.out.println(table[N][K]);
	}
}