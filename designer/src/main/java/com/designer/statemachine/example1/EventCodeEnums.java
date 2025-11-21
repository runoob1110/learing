package com.designer.statemachine.example1;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2025/3/7 11:15
 */
public enum EventCodeEnums implements IEnum {
    /**
     * 管理员
     */
    START_UP("START_UP", "启动"),
    /**
     * 普通用户
     */
    CLOSING("CLOSING", "关门"),
    OPENING("OPENING", "开门"),
    BRAKING("BRAKING", "刹车");

    private String code;

    private String displayName;

    EventCodeEnums(String code, String displayName) {
        this.code = code;
        this.displayName = displayName;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
