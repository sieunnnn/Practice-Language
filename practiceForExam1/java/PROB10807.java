import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PROB10807 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] numbers;
    static int v;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i ++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        v = Integer.parseInt(br.readLine());

        System.out.println(findNumber(v));
    }

    public static int findNumber(int v) {
        int cnt = 0;

        for (int i = 0; i < N; i ++) {
            if (numbers[i] == v) {
                cnt ++;
            }
        }

        return cnt;
    }
}
