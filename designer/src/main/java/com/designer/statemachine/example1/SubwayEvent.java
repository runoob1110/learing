package com.designer.statemachine.example1;

import java.util.Map;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2025/3/7 11:14
 */
public class SubwayEvent {
    /**
     * 事件标识(编码)
     */
    private EventCodeEnums eventCode;

    /**
     * 附属的业务参数
     */
    private Map<Object, Object> attributes = null;

    public SubwayEvent(EventCodeEnums eventCode) {
        this.eventCode = eventCode;
    }

    public SubwayEvent(EventCodeEnums eventCode, Map<Object, Object> attributes) {
        this.eventCode = eventCode;
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return eventCode.getCode();
    }

    public EventCodeEnums getEventCode() {
        return eventCode;
    }

    public void setEventCode(EventCodeEnums eventCode) {
        this.eventCode = eventCode;
    }

    public Map<Object, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<Object, Object> attributes) {
        this.attributes = attributes;
    }
}
