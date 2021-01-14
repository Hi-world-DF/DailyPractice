package com.niuke.test;

/**
 * （1）assert [boolean 表达式]
 *     如果[boolean表达式]为true，则程序继续执行。
 *     如果为false，则程序抛出AssertionError，并终止执行。
 *
 * （2）assert[boolean 表达式 : 错误表达式 （日志）]
 *     如果[boolean表达式]为true，则程序继续执行。
 *     如果为false，则程序抛出java.lang.AssertionError，输出[错误信息]。
 * */

public class AssertTest {

    public static void main(String[] args) {
        test1(-5);
        test2(-3);
    }

    private static void test1(int a){
        assert a < 0;
        System.out.println(a);
    }
    private static void test2(int a){
        assert a > 0 : "something goes wrong here, a cannot be less than 0";
        System.out.println(a);
    }

}
