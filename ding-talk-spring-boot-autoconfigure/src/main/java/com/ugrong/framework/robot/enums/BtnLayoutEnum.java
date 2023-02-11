package com.ugrong.framework.robot.enums;

/**
 * 按钮布局
 */
public enum BtnLayoutEnum {

    /**
     * 按钮竖直排列
     */
    VERTICAL("0"),

    /**
     * 按钮横向排列
     */
    HORIZONTAL("1");

    private final String value;

    BtnLayoutEnum(String value) {
        this.value = value;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }
}
