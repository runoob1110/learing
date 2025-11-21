package com.designer.statemachine.example1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2025/3/7 11:12
 */
public class SubwayState {
    /**
     * 状态编码
     */
    private StateCodeEnums stateCode;

    /**
     * 当前状态下可允许执行的动作
     */
    private List<SubwayTransition> transitions = new ArrayList<>();

    public SubwayState(StateCodeEnums stateCode, SubwayTransition... transitions) {
        this.stateCode = stateCode;
        for (SubwayTransition transition : transitions) {
            this.transitions.add(transition);
        }
    }

    // 添加动作
    public void addTransition(SubwayTransition transition) {
        transitions.add(transition);
    }

    @Override
    public String toString() {
        return stateCode.getDisplayName();
    }

    public StateCodeEnums getStateCode() {
        return stateCode;
    }

    public void setStateCode(StateCodeEnums stateCode) {
        this.stateCode = stateCode;
    }

    public List<SubwayTransition> getTransitions() {
        return transitions;
    }

    public void setTransitions(List<SubwayTransition> transitions) {
        this.transitions = transitions;
    }
}
