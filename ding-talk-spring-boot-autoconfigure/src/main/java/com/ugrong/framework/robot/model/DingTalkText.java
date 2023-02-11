package com.ugrong.framework.robot.model;

import com.ugrong.framework.robot.enums.DingTalkMsgTypeEnum;

/**
 * 文本
 */
public class DingTalkText implements DingTalkMsg {

    /**
     * 消息文本
     */
    private String content;

    /**
     * Instantiates a new Ding talk text.
     *
     * @param content the content
     */
    public DingTalkText(String content) {
        this.content = content;
    }

    @Override
    public DingTalkMsgTypeEnum getMsgType() {
        return DingTalkMsgTypeEnum.TEXT;
    }

    /**
     * Gets content.
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets content.
     *
     * @param content the content
     */
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "DingTalkText{" +
                "content='" + content + '\'' +
                '}';
    }
}
