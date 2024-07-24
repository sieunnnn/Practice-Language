package chapter06.prob20;

public class Account {
    private String accountNumber;
    private String name;
    private long balance;
    private int currentIdx = 0;

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBalance() {
        return this.balance;
    }

    public String setBalance(long balance) {
        long temp = this.balance;
        if (balance < 0) {
            temp += balance;

            if (temp < 0)
                return "잔액이 부족합니다.";

            else{
                this.balance = temp;
                return "출금에 성공했습니다.";
            }

        } else {
            this.balance += balance;

            return "입금에 성공했습니다.";
        }
    }

    public int getCurrentIdx() {
        return this.currentIdx;
    }

    public void increaseCurrentIdx() {
        this.currentIdx++;
    }
}
