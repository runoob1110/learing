package com.designer.statemachine.example1;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2025/3/7 13:27
 */
public class Test {
    public static void main(String[] args) {
        SubwayAbsStateMachine sm = new SubwayStateMachine();
        SubwayState state = sm.execute(StateCodeEnums.MOVING, new SubwayEvent(EventCodeEnums.BRAKING));
    }
}
