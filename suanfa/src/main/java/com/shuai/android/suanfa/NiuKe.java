package com.shuai.android.suanfa;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created with Andrid Studio.
 * User:shuaizhimin
 * Date:17/10/11
 * Time:下午2:41
 */
public class NiuKe {



    public static void main(String args[]) {
        System.out.println("" + replaceSpace(new StringBuffer("We Are Happy")));
    }


    public static String replaceSpace(StringBuffer str) {
//        StringBuffer out = new StringBuffer();
//        for (int i = 0; i < str.toString().length(); i++) {
//            char b = str.charAt(i);
//            if (String.valueOf(b).equals(" ")) {
//                out.append("%20");
//            } else {
//                out.append(b);
//            }
//        }
//        return out.toString();
        return str.toString().replaceAll("\\s","%20");
    }

}
