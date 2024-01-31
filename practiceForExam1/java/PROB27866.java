import java.util.Scanner;

public class PROB27866 {
    static Scanner sc = new Scanner(System.in);
    static String str;
    static int index;
    public static void main(String[] args) {
        str = sc.next();
        index = sc.nextInt();
        System.out.println(str.charAt(index - 1));
    }
}
