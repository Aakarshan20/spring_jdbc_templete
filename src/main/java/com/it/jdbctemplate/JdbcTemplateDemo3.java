package com.it.jdbctemplate;

import com.it.dao.IAccountDao;
import com.it.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * jdbc Template的IOC用法
 */
public class JdbcTemplateDemo3 {
    public static void main(String[] args) {

        //1. 獲取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2. 獲取對象
        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        //3. 執行操作

        //保存
        //jt.update("insert into account(name, money)values(?,?)", "iii", 200f);
        //更新
        // jt.update("update account set name=?, money=? where id=?", "jjj", 300f, 11);
        //刪除
         //jt.update("delete from account where id = ? ", 11);

        //查詢所有 query方法有很多
        //List<Account> accounts = jt.query("select * from account where money > ?", new AccountRowMapper(), 1000f); //自己加一個accountRowMapper
//        List<Account> accounts = jt.query("select * from account where money > ?", new BeanPropertyRowMapper<Account>(Account.class), 1000f); //spring封裝的方法
//        for(Account account: accounts){
//            System.out.println(account);
//        }
        //查詢一個
//        List<Account> accounts = jt.query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), 9); //spring封裝的方法
//        System.out.println(accounts.isEmpty() ? "沒有資料": accounts.get(0));
        //查詢返回一行一列(使用聚合函數 但不加group by子句)
        Long count = jt.queryForObject("select count(1) from account where money > ?", Long.class, 1000f);
        System.out.println(count);
    }
}

/**
 * 定義account的封裝策略
 * 自己將對象封裝到集合裡
 */
class AccountRowMapper implements RowMapper<Account> {
    /**
     * 把結果集中的數據封裝到Account中 由spring將每個account加到集合中
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setName(resultSet.getString("name"));
        account.setMoney(resultSet.getFloat("money"));
        return account;
    }
}
