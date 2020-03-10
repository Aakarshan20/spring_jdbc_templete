package com.it.dao;

import com.it.domain.Account;

/**
 * 帳戶的持久層接口
 */
public interface IAccountDao {
    /**
     * 用ID找帳戶
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 用name查帳戶
     * @param accountName
     * @return
     */
    Account findAccountByName(String accountName);

    /**
     * 更新帳戶
     * @param account
     */
    void updateAccount(Account account);






}
