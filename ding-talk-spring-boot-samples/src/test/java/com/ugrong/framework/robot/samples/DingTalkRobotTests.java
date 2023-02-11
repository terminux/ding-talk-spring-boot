package com.ugrong.framework.robot.samples;

import com.ugrong.framework.robot.enums.BtnLayoutEnum;
import com.ugrong.framework.robot.model.*;
import com.ugrong.framework.robot.model.DingTalkActionCard.Button;
import com.ugrong.framework.robot.model.DingTalkFeedCard.Link;
import com.ugrong.framework.robot.service.DingTalkRobotService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DingTalkRobotTests {

    @Resource
    private DingTalkRobotService dingTalkRobotService;

    /**
     * 这里修改成真实手机号
     */
    private static final String[] atMobiles = new String[]{"12345678910", "10987654321"};

    /**
     * 这里修改成真实的钉钉用户id
     */
    private static final String[] atUserIds = new String[]{"userId1", "userId2"};

    /**
     * 发送文本
     */
    @Test
    void sendText() {
        dingTalkRobotService.sendText("我就是我，是不一样的烟火");
    }

    /**
     * 发送文本且@所有人
     */
    @Test
    void sendTextAndAtAll() {
        dingTalkRobotService.sendText("我就是我，是不一样的烟火", new DingTalkAt().atAll());
    }

    /**
     * 发送文本且@指定手机号的用户
     */
    @Test
    void sendTextAndAtMobiles() {
        dingTalkRobotService.sendText("我就是我，是不一样的烟火", new DingTalkAt().atMobiles(atMobiles));
    }

    /**
     * 发送文本且@指定用户id的用户
     */
    @Test
    void sendTextAndAtUserIds() {
        dingTalkRobotService.sendText("我就是我，是不一样的烟火", new DingTalkAt().atUserIds(atUserIds));
    }

    /**
     * 根据自定义的机器人ID将消息发送给指定机器人且@所有人，适用于多机器人场景
     */
    @Test
    void sendTextByRobotId() {
        dingTalkRobotService.send("robot2", new DingTalkText("测试文本"), new DingTalkAt().atAll());
    }

    /**
     * 发送markdown
     */
    @Test
    void sendMarkDown() {
        DingTalkMarkdown markdown = new DingTalkMarkdown("杭州天气", "#### 杭州天气 @150XXXXXXXX \n> 9度，西北风1级，空气良89，相对温度73%\n> ![screenshot](https://img.alicdn.com/tfs/TB1NwmBEL9TBuNjy1zbXXXpepXa-2400-1218.png)\n> ###### 10点20分发布 [天气](https://www.dingalk.com) \n");
        dingTalkRobotService.send(markdown);
    }

    /**
     * 发送markdown且@所有人
     */
    @Test
    void sendMarkDownAndAtAll() {
        DingTalkMarkdown markdown = new DingTalkMarkdown("杭州天气", "#### 杭州天气 @150XXXXXXXX \n> 9度，西北风1级，空气良89，相对温度73%\n> ![screenshot](https://img.alicdn.com/tfs/TB1NwmBEL9TBuNjy1zbXXXpepXa-2400-1218.png)\n> ###### 10点20分发布 [天气](https://www.dingalk.com) \n");
        dingTalkRobotService.send(markdown, new DingTalkAt().atAll());
    }

    /**
     * 发送markdown且@指定手机号的用户
     */
    @Test
    void sendMarkDownAndAtMobiles() {
        DingTalkMarkdown markdown = new DingTalkMarkdown("杭州天气", "#### 杭州天气 @150XXXXXXXX \n> 9度，西北风1级，空气良89，相对温度73%\n> ![screenshot](https://img.alicdn.com/tfs/TB1NwmBEL9TBuNjy1zbXXXpepXa-2400-1218.png)\n> ###### 10点20分发布 [天气](https://www.dingalk.com) \n");
        dingTalkRobotService.send(markdown, new DingTalkAt().atMobiles(atMobiles));
    }

    /**
     * 发送markdown且@指定用户id的用户
     */
    @Test
    void sendMarkDownAndAtUserIds() {
        DingTalkMarkdown markdown = new DingTalkMarkdown("杭州天气", "#### 杭州天气 @150XXXXXXXX \n> 9度，西北风1级，空气良89，相对温度73%\n> ![screenshot](https://img.alicdn.com/tfs/TB1NwmBEL9TBuNjy1zbXXXpepXa-2400-1218.png)\n> ###### 10点20分发布 [天气](https://www.dingalk.com) \n");
        dingTalkRobotService.send(markdown, new DingTalkAt().atUserIds(atUserIds));
    }

    /**
     * 发送链接
     */
    @Test
    void sendLink() {
        DingTalkLink link = new DingTalkLink();
        link.setTitle("这是一个Link消息");
        link.setText("这是Link消息");
        link.setPicUrl("https://img.alicdn.com/tfs/TB1NwmBEL9TBuNjy1zbXXXpepXa-2400-1218.png");
        link.setMessageUrl("https://open.dingtalk.com/document/");
        dingTalkRobotService.send(link);
    }

    /**
     * 发送整体跳转的ActionCard
     */
    @Test
    void sendSingleActionCard() {
        DingTalkSingleActionCard actionCard = new DingTalkSingleActionCard();
        actionCard.setTitle("打造一间咖啡厅");
        actionCard.setText("![screenshot](https://img.alicdn.com/tfs/TB1NwmBEL9TBuNjy1zbXXXpepXa-2400-1218.png) \n #### 乔布斯 20 年前想打造的苹果咖啡厅 \n\n Apple Store 的设计正从原来满满的科技感走向生活化，而其生活化的走向其实可以追溯到 20 年前苹果一个建立咖啡馆的计划");
        actionCard.setSingleTitle("阅读全文");
        actionCard.setSingleURL("https://www.dingtalk.com/");
        dingTalkRobotService.send(actionCard);
    }

    /**
     * 发送独立跳转的ActionCard，底部按钮竖直排列
     */
    @Test
    void sendActionCardAndButtonLayoutWithVertical() {
        DingTalkActionCard actionCard = new DingTalkActionCard();
        actionCard.setTitle("乔布斯 20 年前想打造一间苹果咖啡厅，而它正是 Apple Store 的前身");
        actionCard.setText("![screenshot](https://img.alicdn.com/tfs/TB1NwmBEL9TBuNjy1zbXXXpepXa-2400-1218.png) \n\n #### 乔布斯 20 年前想打造的苹果咖啡厅 \n\n Apple Store 的设计正从原来满满的科技感走向生活化，而其生活化的走向其实可以追溯到 20 年前苹果一个建立咖啡馆的计划");
        List<Button> buttons = List.of(new Button("内容不错", "https://www.dingtalk.com/"),
                new Button("不感兴趣", "https://www.dingtalk.com/"));
        actionCard.setBtns(buttons);
        actionCard.setBtnLayout(BtnLayoutEnum.VERTICAL);
        dingTalkRobotService.send(actionCard);
    }

    /**
     * 发送独立跳转的ActionCard，底部按钮横向排列
     */
    @Test
    void sendActionCardAndButtonLayoutWithHorizontal() {
        DingTalkActionCard actionCard = new DingTalkActionCard();
        actionCard.setTitle("乔布斯 20 年前想打造一间苹果咖啡厅，而它正是 Apple Store 的前身");
        actionCard.setText("![screenshot](https://img.alicdn.com/tfs/TB1NwmBEL9TBuNjy1zbXXXpepXa-2400-1218.png) \n\n #### 乔布斯 20 年前想打造的苹果咖啡厅 \n\n Apple Store 的设计正从原来满满的科技感走向生活化，而其生活化的走向其实可以追溯到 20 年前苹果一个建立咖啡馆的计划");
        List<Button> buttons = List.of(new Button("内容不错", "https://www.dingtalk.com/"),
                new Button("不感兴趣", "https://www.dingtalk.com/"));
        actionCard.setBtns(buttons);
        actionCard.setBtnLayout(BtnLayoutEnum.HORIZONTAL);
        dingTalkRobotService.send(actionCard);
    }

    /**
     * 发送FeedCard
     */
    @Test
    void sendFeedCard() {
        Link link1 = new Link();
        link1.setTitle("时代的火车向前开1");
        link1.setMessageURL("https://www.dingtalk.com/");
        link1.setPicURL("https://img.alicdn.com/tfs/TB1NwmBEL9TBuNjy1zbXXXpepXa-2400-1218.png");

        Link link2 = new Link();
        link2.setTitle("时代的火车向前开2");
        link2.setMessageURL("https://www.dingtalk.com/");
        link2.setPicURL("https://img.alicdn.com/tfs/TB1NwmBEL9TBuNjy1zbXXXpepXa-2400-1218.png");

        DingTalkFeedCard feedCard = new DingTalkFeedCard(List.of(link1, link2));
        dingTalkRobotService.send(feedCard);
    }

}
