package org.abewang.junit.chapter7.account;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @Author Abe
 * @Date 2018/5/21.
 */
public class TestAccountService {
    @Test
    public void testTransferOK() {
        MockAccountManager mockAccountManager = new MockAccountManager();
        Account sender = new Account("1", 200);
        Account beneficiary = new Account("2", 200);
        mockAccountManager.addAccount("1", sender);
        mockAccountManager.addAccount("2", beneficiary);
        AccountService accountService = new AccountService();
        accountService.setAccountManager(mockAccountManager);
        accountService.transfer("1", "2", 50);

        assertEquals(150, sender.getBalance());
        assertEquals(250, beneficiary.getBalance());
    }
}
