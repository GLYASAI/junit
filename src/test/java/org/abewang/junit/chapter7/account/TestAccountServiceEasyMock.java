package org.abewang.junit.chapter7.account;

import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;

/**
 * 使用EasyMock重写TestAccountService测试
 *
 * @Author Abe
 * @Date 2018/5/22.
 */
public class TestAccountServiceEasyMock {
    private AccountManager mockAccountManager;

    @Before
    public void setUp() {
        mockAccountManager = createMock("mockAccountManager", AccountManager.class);
    }

    @Test
    public void testTransferOk() {
        Account sender = new Account("1", 200);
        Account beneficiary = new Account("2", 200);

        // 没有返回值：直接调用方法
        mockAccountManager.updateAccount(sender);
        mockAccountManager.updateAccount(beneficiary);
        // 有返回值：使用expect和andReturn调用方法
        expect(mockAccountManager.findAccountForUser("1"))
                .andReturn(sender);
        expect(mockAccountManager.findAccountForUser("2"))
                .andReturn(beneficiary);

        replay(mockAccountManager);
        AccountService accountService = new AccountService();
        accountService.setAccountManager(mockAccountManager);
        accountService.transfer("1", "2", 50);

        assertEquals(150, sender.getBalance());
        assertEquals(250, beneficiary.getBalance());
    }
}
