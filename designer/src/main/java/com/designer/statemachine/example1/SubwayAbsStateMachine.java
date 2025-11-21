package com.designer.statemachine.example1;

import java.util.List;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2025/3/7 11:16
 */
public abstract class SubwayAbsStateMachine {
    /**
     * 定义的所有状态
     */
    private static List<SubwayState> allStates = null;

    /**
     * 状态机执行事件
     *
     * @param stateCode
     * @param event
     * @return
     */
    public SubwayState execute(StateCodeEnums stateCode, SubwayEvent event) {
        SubwayState startState = this.getState(stateCode);
        for (SubwayTransition transition : startState.getTransitions()) {
            if (event.getEventCode().equals(transition.getEventCode())) {
                return transition.execute(event);
            }
        }
        System.out.println(String.format("StateMachine[{}] Can not find transition for stateId[{}] eventCode[{}]", this.getClass().getSimpleName(), stateCode, event.getEventCode()));
        System.out.println(String.format("StateMachine[%s] Can not find transition for current state:[%s] eventCode:[%s]", this.getClass().getSimpleName(), stateCode, event.getEventCode()));
        return null;
    }

    public SubwayState getState(StateCodeEnums stateCode) {
        if (allStates == null) {
            System.out.println("StateMachine declareAllStates");
            allStates = this.declareAllStates();
        }

        for (SubwayState state : allStates) {
            if (state.getStateCode().equals(stateCode)) {
                return state;
            }
        }
        return null;
    }

    /**
     * 由具体的状态机定义所有状态
     *
     * @return
     * @author 张振伟
     */
    public abstract List<SubwayState> declareAllStates();
}
