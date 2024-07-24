package chapter06.prob20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BankApplication {
    static Account[] accounts = new Account[100];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final String IS_ONLY_NUMBERS = "\\d+";
    static final String IS_NUMBER_EXIST = ".*\\d.*";

    public static void main(String[] args) throws IOException {
        while (true) {
            printInformation();

            int number = selectNumber();
            if (number == 5) {
                System.out.println("-------------------------------------------------");
                System.out.println("프로그램을 종료합니다.");
                System.out.println("-------------------------------------------------");
                break;
            }

            runApplication(number);
        }
    }

    private static void printInformation() {
        System.out.println("-------------------------------------------------");
        System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
        System.out.println("-------------------------------------------------");
    }

    private static int selectNumber() {
        try {
            System.out.print("선택> ");
            int number = Integer.parseInt(br.readLine());
            validateNumber(number);
            return number;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return selectNumber();
        }
    }

    private static void validateNumber(int number) {
        if (number < 1 || number > 5) {
            throw new IllegalArgumentException("1 ~ 5 사이의 숫자를 입력해주세요.");
        }
    }

    public static void runApplication(int number) {
        if (number == 1) createAccount();
        if (number == 2) printAccountList();
        if (number == 3) deposit();
        if (number == 4) withdraw();
    }

    private static void createAccount() {
        try {
            System.out.println("-------------------------------------------------");
            System.out.println("계좌 생성");
            System.out.println("-------------------------------------------------");

            System.out.print("계좌 번호: ");
            String accountNumber = br.readLine();
            validateAccountNumber(accountNumber);

            System.out.print("계좌주: ");
            String name = br.readLine();
            validateName(name);

            System.out.print("초기 입금액: ");
            long balance = Long.parseLong(br.readLine());
            validateBalance(balance);

            Account account = new Account();
            int currentIdx = account.getCurrentIdx();

            account.setAccountNumber(accountNumber);
            account.setName(name);
            account.setBalance(balance);

            account.increaseCurrentIdx();
            accounts[currentIdx] = account;

            System.out.println("결과: 입금에 성공했습니다.");

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            System.out.println("-------------------------------------------------");
            System.out.println("계좌 생성을 진행합니다.");
            createAccount();
        }
    }

    private static int findAccountNumber(String accountNumber) {
        int idx = -1;
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].getAccountNumber().equals(accountNumber)) {
                idx = i;
                break;
            }
        }

        if (idx == -1) throw new IllegalArgumentException("계좌가 존재하지 않습니다.");
        else return idx;
    }

    private static void validateAccountNumber(String accountNumber) {
        String[] accountNumbers = accountNumber.split("-");

        if (accountNumbers.length != 2) {
            throw new IllegalArgumentException("계좌번호를 확인해주세요.");
        }

        for (int i = 0; i < accountNumbers.length; i++) {
            if (!accountNumbers[i].matches(IS_ONLY_NUMBERS)) {
                throw new IllegalArgumentException("계좌번호는 숫자로만 이루어져야 합니다.");
            }
        }
    }

    private static void validateName(String name) {
        if (name.matches(IS_NUMBER_EXIST)) {
            throw new IllegalArgumentException("이름에 숫자가 들어갈 수 없습니다.");
        }
    }

    private static void validateBalance(long balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("입금액은 양수여야 합니다.");
        }
    }

    private static void printAccountList() {
        System.out.println("-------------------------------------------------");
        System.out.println("계좌 목록");
        System.out.println("-------------------------------------------------");

        for (Account account : accounts) {
            if (account != null) {
                System.out.printf("%-10s %-10s %-10d%n", account.getAccountNumber(), account.getName(), account.getBalance());
            }
        }
    }

    private static void deposit() {
        try {
            System.out.println("-------------------------------------------------");
            System.out.println("예금");
            System.out.println("-------------------------------------------------");

            System.out.print("계좌 번호: ");
            String accountNumber = br.readLine();
            int accountId = findAccountNumber(accountNumber);
            validateAccountNumber(accountNumber);

            System.out.print("예금액: ");
            long balance = Long.parseLong(br.readLine());
            validateBalance(balance);

            accounts[accountId].setBalance(balance);
            System.out.println("결과: 예금에 성공했습니다.");

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            System.out.println("-------------------------------------------------");
            System.out.println("계좌 생성을 진행합니다.");
            createAccount();
        }
    }

    private static void withdraw() {
        try {
            System.out.println("-------------------------------------------------");
            System.out.println("출금");
            System.out.println("-------------------------------------------------");

            System.out.print("계좌 번호: ");
            String accountNumber = br.readLine();
            int accountId = findAccountNumber(accountNumber);
            validateAccountNumber(accountNumber);

            System.out.print("출금액: ");
            long balance = Long.parseLong(br.readLine());
            validateBalance(balance);

            accounts[accountId].setBalance(-balance);

            System.out.println("결과: 출금에 성공했습니다.");

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            System.out.println("-------------------------------------------------");
            System.out.println("다시 처음으로 돌아갑니다.");
            withdraw();
        }
    }
}
