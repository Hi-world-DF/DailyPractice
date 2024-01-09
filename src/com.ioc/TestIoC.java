package com.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoC {
    @Test
    public  void test1(){
        //加载配置
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        //从容器中获得bean
        BookService bookService = (BookService) applicationContext.getBean("bookServiceId");
        bookService.addBook();
    }
}
