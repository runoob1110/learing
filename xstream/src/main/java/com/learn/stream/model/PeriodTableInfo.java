package com.learn.stream.model;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2024/11/4 15:44
 */
public class PeriodTableInfo {
    private int TimeTable; //   时段表号，范围1-16
//    private List<PeriodInfo> periodInfos;

    public int getTimeTable() {
        return TimeTable;
    }

    public void setTimeTable(int timeTable) {
        TimeTable = timeTable;
    }
}
