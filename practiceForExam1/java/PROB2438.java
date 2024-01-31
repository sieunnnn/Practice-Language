import java.util.Scanner;

public class PROB2438 {
    static Scanner sc = new Scanner(System.in);
    static int N;

    public static void main(String[] args) {
        N = sc.nextInt();
        printStars(N);
    }

    public static void printStars(int N) {
        for (int i = 1; i <= N; i ++) {
            for (int j = 1; j <= i; j ++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
