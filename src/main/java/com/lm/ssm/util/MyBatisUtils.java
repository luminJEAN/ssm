package com.lm.ssm.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisUtils {
    private static SqlSessionFactory sessionFactory=null;
    static {
        try {
            Reader reader= Resources.getResourceAsReader("mybatis-config.xml");//读取Mybatis的主配置文件，配置文件名是什么就写什么，这里我的主配置文件在src目录下
            sessionFactory=new SqlSessionFactoryBuilder().build(reader);//利用sql会话工厂构造器构造一个会话工厂，数据来源于reader

        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession() {//获取会话
        return sessionFactory.openSession();
    }
}
