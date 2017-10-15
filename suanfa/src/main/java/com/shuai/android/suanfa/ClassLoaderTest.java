package com.shuai.android.suanfa;

/**
 * Created with Andrid Studio.
 * User:shuaizhimin
 * Date:17/10/14
 * Time:下午10:41
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader);
        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());
    }
}
