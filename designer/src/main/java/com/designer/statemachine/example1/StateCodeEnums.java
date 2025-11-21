package com.designer.statemachine.example1;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2025/3/7 11:12
 */
public enum StateCodeEnums implements IEnum {
    /**
     * 管理员
     */
    MOVING("MOVING", "行进中"),
    /**
     * 普通用户
     */
    CLOSED("CLOSED", "到站-关门"),
    OPEN("OPEN", "到站-开门"),
    SUSPENDED("SUSPENDED", "停运的");

    private String code;

    private String displayName;

    StateCodeEnums(String code, String displayName) {
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
