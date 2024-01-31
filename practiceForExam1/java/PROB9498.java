import java.io.IOException;
import java.util.Scanner;

public class PROB9498 {
    static Scanner sc = new Scanner(System.in);
    static int score;

    public static void main(String[] args) throws IOException {
        score = sc.nextInt();
        System.out.println(changeScoreToGrade(score));
    }

    public static String changeScoreToGrade(int score) {
        if (score <= 100 && score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
