import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
    private static boolean[] primeNumberBox;
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(reader.readLine());
        int[] numbers = new int[N];
        initNumbers(numbers);
        int max = findMax(numbers);

        makePrimeNumberBox(max);
        
        int count = 0;
        for (int number : numbers) {
            if (primeNumberBox[number]) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static void makePrimeNumberBox(int max) {
        primeNumberBox = new boolean[max + 1];
        Arrays.fill(primeNumberBox, true);
        primeNumberBox[0] = false;
        primeNumberBox[1] = false;
        
        for (int number = 2; number < primeNumberBox.length; number++) {
            if (!primeNumberBox[number]) {
                continue;
            }
            int notPrimeNumber = number * 2;
            while (notPrimeNumber <= max) {
                primeNumberBox[notPrimeNumber] = false;
                notPrimeNumber += number;
            }
        }
    }

    private static int findMax(int[] numbers) {
        int max = 0;
        for (int number : numbers) {
            if (max < number) {
                max = number;
            }
        }
        return max;
    }

    private static void initNumbers(int[] numbers) throws IOException {
        StringTokenizer number = new StringTokenizer(reader.readLine());
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(number.nextToken());
        }
    }
}
