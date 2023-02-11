package com.ugrong.framework.robot.model;

import com.ugrong.framework.robot.enums.BtnLayoutEnum;
import com.ugrong.framework.robot.enums.DingTalkMsgTypeEnum;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 独立跳转ActionCard
 */
public class DingTalkActionCard implements DingTalkMsg {

    /**
     * 首屏会话透出的展示内容
     */
    private String title;

    /**
     * markdown格式的消息内容
     */
    private String text;

    /**
     * 按钮排列顺序
     * <p>
     * 0：按钮竖直排列
     * <p>
     * 1：按钮横向排列
     */
    private String btnOrientation;

    /**
     * 按钮
     */
    private List<Button> btns;

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
     * Gets btn orientation.
     *
     * @return the btn orientation
     */
    public String getBtnOrientation() {
        return this.btnOrientation;
    }

    /**
     * Gets btn layout.
     *
     * @return the btn layout
     */
    public BtnLayoutEnum getBtnLayout() {
        return StringUtils.equals(btnOrientation, BtnLayoutEnum.VERTICAL.getValue()) ? BtnLayoutEnum.VERTICAL : BtnLayoutEnum.HORIZONTAL;
    }

    /**
     * Sets btn layout.
     *
     * @param btnLayout the btn layout
     */
    public void setBtnLayout(BtnLayoutEnum btnLayout) {
        this.btnOrientation = btnLayout.getValue();
    }

    /**
     * Gets btns.
     *
     * @return the btns
     */
    public List<Button> getBtns() {
        return btns;
    }

    /**
     * Sets btns.
     *
     * @param btns the btns
     */
    public void setBtns(List<Button> btns) {
        this.btns = btns;
    }

    /**
     * 按钮
     */
    public static final class Button {

        /**
         * 按钮标题
         */
        private final String title;

        /**
         * 点击按钮触发的URL
         */
        private final String actionURL;

        /**
         * Instantiates a new Button.
         *
         * @param title     the title
         * @param actionURL the action url
         */
        public Button(String title, String actionURL) {
            this.title = title;
            this.actionURL = actionURL;
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
         * Gets action url.
         *
         * @return the action url
         */
        public String getActionURL() {
            return actionURL;
        }

        @Override
        public String toString() {
            return "Button{" +
                    "title='" + title + '\'' +
                    ", actionURL='" + actionURL + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "DingTalkActionCard{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", btnOrientation='" + btnOrientation + '\'' +
                ", btns=" + btns +
                '}';
    }
}
