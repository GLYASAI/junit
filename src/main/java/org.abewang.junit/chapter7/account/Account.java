package org.abewang.junit.chapter7.account;

/**
 * Account对象
 *
 * @Author Abe
 * @Date 2018/5/21.
 */
public class Account {
    /**
     * 账户ID
     */
    private String accountId;
    /**
     * 余额
     */
    private long balance;

    public Account(String accountId, long balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public void debit(long amount) {
        this.balance -= amount;
    }

    public void credit(long amount) {
        this.balance += amount;
    }

    public long getBalance() {
        return balance;
    }
}
