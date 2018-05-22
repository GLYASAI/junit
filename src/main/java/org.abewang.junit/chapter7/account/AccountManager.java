package org.abewang.junit.chapter7.account;

/**
 * Account对象
 *
 * @Author Abe
 * @Date 2018/5/21.
 */
public interface AccountManager {
    Account findAccountForUser(String userId);

    void updateAccount(Account account);
}
