package com.it.jdbctemplate;

import com.it.dao.IAccountDao;
import com.it.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * jdbc Template的IOC用法
 */
public class JdbcTemplateDemo2 {
    public static void main(String[] args) {

        //1. 獲取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2. 獲取對象
        IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);
        //3. 創建Account對象
        Account account = accountDao.findAccountById(1);
        account.setMoney(30000.4f);
        account.setName("aaa4");
        accountDao.updateAccount(account);
        System.out.println(account);


    }
}
