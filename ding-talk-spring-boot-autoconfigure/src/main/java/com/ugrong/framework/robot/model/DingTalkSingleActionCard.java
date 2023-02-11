package com.ugrong.framework.robot.model;

import com.ugrong.framework.robot.enums.DingTalkMsgTypeEnum;

/**
 * 整体跳转ActionCard
 */
public class DingTalkSingleActionCard implements DingTalkMsg {

    /**
     * 首屏会话透出的展示内容
     */
    private String title;

    /**
     * markdown格式的消息内容
     */
    private String text;

    /**
     * 单个按钮的标题
     */
    private String singleTitle;

    /**
     * 单个按钮的跳转链接
     */
    private String singleURL;

    @Override
    public DingTalkMsgTypeEnum getMsgType() {
        return DingTalkMsgTypeEnum.ACTION_CARD;
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
     * Gets single title.
     *
     * @return the single title
     */
    public String getSingleTitle() {
        return singleTitle;
    }

    /**
     * Sets single title.
     *
     * @param singleTitle the single title
     */
    public void setSingleTitle(String singleTitle) {
        this.singleTitle = singleTitle;
    }

    /**
     * Gets single url.
     *
     * @return the single url
     */
    public String getSingleURL() {
        return singleURL;
    }

    /**
     * Sets single url.
     *
     * @param singleURL the single url
     */
    public void setSingleURL(String singleURL) {
        this.singleURL = singleURL;
    }

    @Override
    public String toString() {
        return "DingTalkSingleActionCard{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", singleTitle='" + singleTitle + '\'' +
                ", singleURL='" + singleURL + '\'' +
                '}';
    }
}
