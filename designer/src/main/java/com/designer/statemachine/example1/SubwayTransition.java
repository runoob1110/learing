package com.designer.statemachine.example1;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2025/3/7 11:16
 */
public abstract class SubwayTransition {
    /**
     * 触发事件
     */
    private EventCodeEnums eventCode;

    /**
     * 触发当前状态
     */
    private SubwayState currState;

    /**
     * 触发后状态
     */
    private SubwayState nextState;

    public SubwayTransition(EventCodeEnums eventCode, SubwayState currState, SubwayState nextState) {
        super();
        this.eventCode = eventCode;
        this.currState = currState;
        this.nextState = nextState;
    }

    /**
     * 执行动作
     *
     * @param event
     * @return
     * @author
     */
    public SubwayState execute(SubwayEvent event) {
        System.out.println(String.format("当前是：%s 状态，执行：%s 操作后，流转成：\"%s\" 状态。", currState, eventCode, nextState));
        if (this.doExecute(event)) {
            return this.nextState;
        } else {
            return null;
        }
    }

    /**
     * 执行动作的具体业务
     *
     * @param event
     * @return
     * @author
     */
    protected abstract boolean doExecute(SubwayEvent event);

    public EventCodeEnums getEventCode() {
        return eventCode;
    }

    public void setEventCode(EventCodeEnums eventCode) {
        this.eventCode = eventCode;
    }

    public SubwayState getCurrState() {
        return currState;
    }

    public void setCurrState(SubwayState currState) {
        this.currState = currState;
    }

    public SubwayState getNextState() {
        return nextState;
    }

    public void setNextState(SubwayState nextState) {
        this.nextState = nextState;
    }
}
