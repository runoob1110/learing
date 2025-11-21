package com.pan;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2023/11/6 9:12
 */
public class TimerTest {
    public static void main(String[] args) {
        String oneSeven = "00000000";
        StringBuilder oneSevenSb = new StringBuilder(oneSeven);
        String eightTwelve = "00000000";

        StringBuilder eightTwelveSb = new StringBuilder(eightTwelve);
        List<Integer> months = new ArrayList<>();
        months.add(1);
        months.add(2);
        months.add(3);
//        months.add(4);
        months.add(5);
        months.add(6);
        months.add(7);
        months.add(8);
        months.add(9);
        months.add(10);
        months.add(11);
//        months.add(12);

        for (Integer mon : months) {
            if (mon < 8) {
                oneSevenSb.setCharAt(7 - mon, '1');
            } else {
                eightTwelveSb.setCharAt(7 - (mon - 8), '1');
            }
        }
        byte[] result = new byte[2];
        result[1] = (byte) Integer.parseInt(oneSevenSb.toString(), 2);
        result[0] = (byte) Integer.parseInt(eightTwelveSb.toString(), 2);
        System.out.println(result);
    }
}
