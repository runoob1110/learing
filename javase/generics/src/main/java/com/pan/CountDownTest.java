package com.pan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2025/2/24 18:44
 */
public class CountDownTest {
    public static void main(String[] args) {
        List<Integer> phases = List.of(10, 21, 90, 10, 47, 42);
//        int remainingTime = 29; // 示例中的剩余时间
        for (int i = 220; i > 0; i--) {
            System.out.println("当前周期剩余时间: " + i);
            int[] result = calculateCurrentPhase(phases, i);
//            calculateCurrentStageAndRemainingTime(phases, 90);
            System.out.println("当前阶段: " + result[0]);
            System.out.println("阶段剩余时长: " + result[1]);
        }
    }

    public static int[] calculateCurrentPhase(List<Integer> phases, int remainingTime) {
        int totalCycleLength = phases.stream().mapToInt(Integer::intValue).sum();
        int currentTime = totalCycleLength - remainingTime;
        // current = 220 - 90 = 130
        int accumulatedTime = 0;
        for (int i = 0; i < phases.size(); i++) {
            int phaseLength = phases.get(i);

            if (currentTime < accumulatedTime + phaseLength) {
                int phaseRemainingTime = (accumulatedTime + phaseLength) - currentTime;
                return new int[]{i + 1, phaseRemainingTime};
            }
            accumulatedTime += phaseLength;
        }

        // 如果剩余时间为0，说明在最后一个阶段
        return new int[]{phases.size(), 0};
    }


    public static void calculateCurrentStageAndRemainingTime(List<Integer> stages, int remainingTime) {
        int totalLength = stages.stream().mapToInt(Integer::intValue).sum();
        if (remainingTime > totalLength) {
            System.out.println("周期剩余时间大于周期总长度，输入有误");
            return;
        }

        int accumulatedTime = 0; // 累计阶段时间
        for (int i = 0; i < stages.size(); i++) {
            accumulatedTime += stages.get(i); // 累加当前阶段时间
            if (remainingTime <= accumulatedTime) {
                // 当前阶段为 i + 1（阶段从1开始计数）
                int currentStage = i + 1;
                int stageRemainingTime = accumulatedTime - remainingTime;

                if (stageRemainingTime == stages.get(i)) {
                    // 如果剩余时间正好等于当前阶段的开始时间，说明阶段剩余时长为0
                    System.out.println("当前阶段: " + currentStage + ", 阶段剩余时长: 0");
                } else {
                    // 否则，计算阶段剩余时长
                    System.out.println("当前阶段: " + currentStage + ", 阶段剩余时长: " + (stages.get(i) - stageRemainingTime));
                }
                return;
            }
        }
    }
}
