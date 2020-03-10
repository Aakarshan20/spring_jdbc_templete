package com.it.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * jdbc Template的最基本用法
 */
public class JdbcTemplateDemo4 {
    public static void main(String[] args) {
        //1.獲取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.取得對象
        JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        //3.執行操作
        jt.execute("insert into account (name, money)value('111', 222)");

    }
}
