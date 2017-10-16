package com.shuai.android.suanfa;

/**
 * Created with Andrid Studio.
 * User:shuaizhimin
 * Date:17/10/15
 * Time:下午3:46
 */
public class ThreadDemo {
    private int j;
    String mString;
    StringBuffer mStringBuffer;

    public static void main(String args[]) {
        ThreadDemo tt = new ThreadDemo();
        Inc inc = tt.new Inc();
        Dec dec = tt.new Dec();

        Thread t1 = new Thread(inc);
        Thread t2 = new Thread(dec);
        Thread t3 = new Thread(inc);
        Thread t4 = new Thread(dec);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }


    public synchronized void inc() {
        j++;
        System.out.println(Thread.currentThread().getName() + " inc:" + j);
    }

    public synchronized void dec() {
        j--;
        System.out.println(Thread.currentThread().getName() + " dec:" + j);
    }

    class Inc implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                inc();
            }
        }
    }

    class Dec implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                dec();
            }
        }
    }
}
