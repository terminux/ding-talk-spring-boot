package com.ugrong.framework.robot.enums;

/**
 * 消息类型
 */
public enum DingTalkMsgTypeEnum {
    /**
     * text 类型
     */
    TEXT("text"),

    /**
     * link 类型
     */
    LINK("link"),

    /**
     * markdown 类型
     */
    MARKDOWN("markdown"),

    /**
     * ActionCard 类型
     */
    ACTION_CARD("actionCard"),

    /**
     * FeedCard 类型
     */
    FEED_CARD("feedCard");

    private final String value;

    DingTalkMsgTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
