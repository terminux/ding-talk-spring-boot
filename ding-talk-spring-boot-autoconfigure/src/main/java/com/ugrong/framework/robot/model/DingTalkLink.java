package com.ugrong.framework.robot.model;

import com.ugrong.framework.robot.enums.DingTalkMsgTypeEnum;

/**
 * 链接
 */
public class DingTalkLink implements DingTalkMsg {

    /**
     * 消息标题
     */
    private String title;

    /**
     * 消息内容，如果太长只会部分展示
     */
    private String text;

    /**
     * 图片URL
     */
    private String picUrl;

    /**
     * 点击消息跳转的URL
     */
    private String messageUrl;

    @Override
    public DingTalkMsgTypeEnum getMsgType() {
        return DingTalkMsgTypeEnum.LINK;
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

    /**
     * Gets pic url.
     *
     * @return the pic url
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * Sets pic url.
     *
     * @param picUrl the pic url
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    /**
     * Gets message url.
     *
     * @return the message url
     */
    public String getMessageUrl() {
        return messageUrl;
    }

    /**
     * Sets message url.
     *
     * @param messageUrl the message url
     */
    public void setMessageUrl(String messageUrl) {
        this.messageUrl = messageUrl;
    }

    @Override
    public String toString() {
        return "DingTalkLink{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", messageUrl='" + messageUrl + '\'' +
                '}';
    }
}
