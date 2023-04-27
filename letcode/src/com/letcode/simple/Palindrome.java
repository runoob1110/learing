package com.letcode.simple;

/**
 * @author ：panleilei
 * @description 回文数
 * @modified By：
 * @version:
 * @date ：Created in 2023/3/15 21:46
 */

import java.nio.charset.StandardCharsets;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 例如，121 是回文，而 123 不是。
 */
public class Palindrome {
    public static void main(String[] args) {
//        boolean palindrome = isPalindrome(122221);
//        System.out.println(palindrome);
        // 快速排序
//        int[] nums = {1,3,2,5,4,7,6,9,8};

//        int[] nums = {1,3,2,5,4,7,6,9,8};
//        int[] nums = {1,3,2,5,4,7,6,9,8};
//        int[] nums = {1,3,2,5,4,7,6,9,8};

//        String oldADD = "V000";
//        System.out.println("原始版本"+oldADD);
//        String str = oldADD.substring(oldADD.lastIndexOf("V")+1);
//        Integer num = Integer.parseInt(str)+1;
//        String newADD = "V"+String.valueOf(String.format("%0"+3+"d",num));
//        System.out.println("新版本"+newADD);

//        int i = 1;
//        String s = "1";
//        String format = String.format("%0" + 3 + "s", s);
//        System.out.println(format);

        int i = 1;
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);
        System.out.println(i1.equals(i2));
        System.out.println(i1==i2);

    }

    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int length = s.length();
        char[] left;
        char[] right;
        if (length % 2 == 0) {
            // 偶数个
            left = s.substring(0, length / 2).toCharArray();
            right = s.substring(length / 2).toCharArray();
        } else {
            left = s.substring(0, length / 2).toCharArray();
            right = s.substring(length / 2 + 1).toCharArray();
        }
        for (int i = 0; i < left.length; i++) {
            if (left[i] != right[right.length - i -1]) {
                return false;
            }
        }

        return true;
    }
}
