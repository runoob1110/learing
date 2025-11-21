package com.pan.io;

import java.io.*;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2024/4/17 16:45
 */
public class FileTest01 {
    public static void main(String[] args) {
//        15:34:24
//        收到消息{"cycle":90,"curTime":62}
//        15:33:22
//        计算出来的CrossCycle(CrossID=cllnmtl, StartTime=2024-06-13 15:33:21, LastCycleLen=90, CurCycleLen=90, CurCycleRemainLen=27)


        String lastCycleStartTime = "2024-06-15 11:27:35";
        int lastCycleLen = 51;
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lastStartTimeMill;
        try {
            lastStartTimeMill = sdf.parse(lastCycleStartTime).getTime();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
//        11:30:29
        long cycleBeginTime = lastStartTimeMill + lastCycleLen * 1000;
        long timeDiff = 1718422229000l - cycleBeginTime;
        int currentTime = (int) (timeDiff / 1000);
        if (currentTime < 0) {
            currentTime = lastCycleLen + currentTime;
        }
        if (currentTime > lastCycleLen) {
            currentTime = currentTime % lastCycleLen;
        }

        System.out.println(currentTime);
    }
}
