package com.ugrong.framework.robot.model;

import com.ugrong.framework.robot.enums.DingTalkMsgTypeEnum;

/**
 * Markdown
 */
public class DingTalkMarkdown implements DingTalkMsg {

    /**
     * 首屏会话透出的展示内容
     */
    private String title;

    /**
     * Markdown格式的消息内容
     */
    private String text;

    /**
     * Instantiates a new Ding talk markdown.
     *
     * @param title the title
     * @param text  the text
     */
    public DingTalkMarkdown(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Override
    public DingTalkMsgTypeEnum getMsgType() {
        return DingTalkMsgTypeEnum.MARKDOWN;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets text.
     *
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets text.
     *
     * @param text the text
     */
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "DingTalkMarkdown{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
