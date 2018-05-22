package org.abewang.junit.chapter7.account;

import org.abewang.junit.chapter7.account.Account;
import org.abewang.junit.chapter7.account.AccountManager;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Abe
 * @Date 2018/5/21.
 */
public class MockAccountManager implements AccountManager {
    private Map<String, Account> map = new HashMap<>();

    public void addAccount(String userId, Account account) {
        map.put(userId, account);
    }

    @Override
    public Account findAccountForUser(String userId) {
        return map.get(userId);
    }

    @Override
    public void updateAccount(Account account) {
        // do nothing
    }
}
