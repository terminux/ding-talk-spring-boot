package com.ugrong.framework.robot.model;

import com.ugrong.framework.robot.enums.DingTalkMsgTypeEnum;

import java.util.List;

/**
 * FeedCard
 */
public class DingTalkFeedCard implements DingTalkMsg {

    private final List<Link> links;

    public DingTalkFeedCard(List<Link> links) {
        this.links = links;
    }

    @Override
    public DingTalkMsgTypeEnum getMsgType() {
        return DingTalkMsgTypeEnum.FEED_CARD;
    }

    public List<Link> getLinks() {
        return links;
    }

    public static final class Link {

        private String title;

        private String messageURL;

        private String picURL;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMessageURL() {
            return messageURL;
        }

        public void setMessageURL(String messageURL) {
            this.messageURL = messageURL;
        }

        public String getPicURL() {
            return picURL;
        }

        public void setPicURL(String picURL) {
            this.picURL = picURL;
        }

        @Override
        public String toString() {
            return "Link{" +
                    "title='" + title + '\'' +
                    ", messageURL='" + messageURL + '\'' +
                    ", picURL='" + picURL + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "DingTalkFeedCard{" +
                "links=" + links +
                '}';
    }
}
