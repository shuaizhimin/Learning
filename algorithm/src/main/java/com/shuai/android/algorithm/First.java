package com.shuai.android.algorithm;

/**
 * Created with Andrid Studio.
 * User:shuaizhimin
 * Date:17/10/22
 * Time:下午8:39
 */
public class First {

    public static void main(String args[]) {

        revertChar("abcdefaoksl");
    }


    public static void revertChar(String s) {
        char[] ch = s.toCharArray();
        String result = "";
        int len = ch.length;
        for (int i = len - 1; i >= 0; i--) {
            result += ch[i];
        }
        System.out.println("revertChar:" + result);
    }

}
