package com.it.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * jdbc Template的最基本用法
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //準備數據源: spring的內置數據源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/eesy");
        ds.setUsername("root");
        ds.setPassword("1234");

        //1.創建jdbctemplate對象
        JdbcTemplate jt = new JdbcTemplate();
        //給jt設置數據源
        jt.setDataSource(ds);
        //2.執行操作
        jt.execute("insert into account (name, money)value('hhh', 300.3)");


    }
}
