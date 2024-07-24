package chapter06.prob19;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();

        account.setBalance(10000);
        print(account.getBalance());

        account.setBalance(-100);
        print(account.getBalance());

        account.setBalance(2000000);
        print(account.getBalance());

        account.setBalance(300000);
        print(account.getBalance());
    }

    private static void print(int result) {
        System.out.println("현재 잔고: " + result);
    }
}
