import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Roach {

    static int N;
    static int SUM;

    static PriorityQueue<Integer> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        if (queue.size() == 1) {
            queue.poll();
        }

        while (!queue.isEmpty()) {

            int num1 = queue.poll();
            int num2 = queue.poll();

            int TMP = num1 + num2;
            SUM += num1 + num2;

            if (queue.isEmpty()) {
                break;
            }
            queue.add(TMP);
        }

        if (queue.size() == 1) {
            SUM += queue.poll();
        }

        System.out.println(SUM);
    }

}
