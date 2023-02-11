# ding-talk-spring-boot

> 基于spring boot 3.x的starter组件，集成了钉钉机器人发送消息通知，支持多机器人，开箱即用

* [基本配置](#基本配置)

* [开始使用](#开始使用)

### 基本配置

##### 1、先把项目 clone 到本地

```shell
git clone git@github.com:terminux/ding-talk-spring-boot.git
```

##### 2、进入到项目根目录下执行（需要JDK17+）

```shell
mvn -pl '!ding-talk-spring-boot-samples' -DskipTests clean install
```

##### 3、给项目添加依赖

```xml
<dependency>
    <groupId>com.ugrong.framework</groupId>
    <artifactId>ding-talk-spring-boot-starter</artifactId>
    <version>1.0.0</version>
</dependency>
```

##### 4、在项目中配置一下钉钉机器人

```yaml
com:
  ugrong:
    dingtalk:
      robots:
        default:
          enable-sign: true
          access-token: 'your accessToken'
          secret: 'your secret'
```

### 开始使用

##### 1、在项目中注入 [DingTalkRobotService](./ding-talk-spring-boot-autoconfigure/src/main/java/com/ugrong/framework/robot/service/DingTalkRobotService.java "DingTalkRobotService") 服务，例如：

```java
@Resource
private DingTalkRobotService dingTalkRobotService;
```

##### 2、使用 [DingTalkRobotService](./ding-talk-spring-boot-autoconfigure/src/main/java/com/ugrong/framework/robot/service/DingTalkRobotService.java "DingTalkRobotService") 中提供的方法进行消息发送

* 发送文本

```java
dingTalkRobotService.sendText("我就是我，是不一样的烟火");
```

* 发送文本且@所有人

```java
dingTalkRobotService.sendText("我就是我，是不一样的烟火", new DingTalkAt().atAll());
```

* 发送文本且@指定手机号的用户

```java
dingTalkRobotService.sendText("我就是我，是不一样的烟火", new DingTalkAt().atMobiles("12345678910", "10987654321"));
```

* 发送文本且@指定用户id的用户

```java
dingTalkRobotService.sendText("我就是我，是不一样的烟火", new DingTalkAt().atUserIds("userId1", "userId2"));
```

* 发送markdown

```java
DingTalkMarkdown markdown = new DingTalkMarkdown("杭州天气", "#### 杭州天气 @150XXXXXXXX \n> 9度，西北风1级，空气良89，相对温度73%\n> ![screenshot](https://img.alicdn.com/tfs/TB1NwmBEL9TBuNjy1zbXXXpepXa-2400-1218.png)\n> ###### 10点20分发布 [天气](https://www.dingalk.com) \n");
dingTalkRobotService.send(markdown);
```

* 发送markdown且@所有人

```java
DingTalkMarkdown markdown = new DingTalkMarkdown("杭州天气", "#### 杭州天气 @150XXXXXXXX \n> 9度，西北风1级，空气良89，相对温度73%\n> ![screenshot](https://img.alicdn.com/tfs/TB1NwmBEL9TBuNjy1zbXXXpepXa-2400-1218.png)\n> ###### 10点20分发布 [天气](https://www.dingalk.com) \n");
dingTalkRobotService.send(markdown, new DingTalkAt().atAll());
```

* 发送markdown且@指定手机号的用户

```java
DingTalkMarkdown markdown = new DingTalkMarkdown("杭州天气", "#### 杭州天气 @150XXXXXXXX \n> 9度，西北风1级，空气良89，相对温度73%\n> ![screenshot](https://img.alicdn.com/tfs/TB1NwmBEL9TBuNjy1zbXXXpepXa-2400-1218.png)\n> ###### 10点20分发布 [天气](https://www.dingalk.com) \n");
dingTalkRobotService.send(markdown, new DingTalkAt().atMobiles("12345678910", "10987654321"));
```

* 发送markdown且@指定用户id的用户

```java
DingTalkMarkdown markdown = new DingTalkMarkdown("杭州天气", "#### 杭州天气 @150XXXXXXXX \n> 9度，西北风1级，空气良89，相对温度73%\n> ![screenshot](https://img.alicdn.com/tfs/TB1NwmBEL9TBuNjy1zbXXXpepXa-2400-1218.png)\n> ###### 10点20分发布 [天气](https://www.dingalk.com) \n");
dingTalkRobotService.send(markdown, new DingTalkAt().atUserIds("userId1", "userId2"));
```

* 发送链接

```java
DingTalkLink link = new DingTalkLink();
link.setTitle("这是一个Link消息");
link.setText("这是Link消息");
link.setPicUrl("https://img.alicdn.com/tfs/TB1NwmBEL9TBuNjy1zbXXXpepXa-2400-1218.png");
link.setMessageUrl("https://open.dingtalk.com/document/");

dingTalkRobotService.send(link);
```

* 发送整体跳转的ActionCard

```java
DingTalkSingleActionCard actionCard = new DingTalkSingleActionCard();
actionCard.setTitle("打造一间咖啡厅");
actionCard.setText("![screenshot](https://img.alicdn.com/tfs/TB1NwmBEL9TBuNjy1zbXXXpepXa-2400-1218.png) \n #### 乔布斯 20 年前想打造的苹果咖啡厅 \n\n Apple Store 的设计正从原来满满的科技感走向生活化，而其生活化的走向其实可以追溯到 20 年前苹果一个建立咖啡馆的计划");
actionCard.setSingleTitle("阅读全文");
actionCard.setSingleURL("https://www.dingtalk.com/");

dingTalkRobotService.send(actionCard);
```

* 发送独立跳转的ActionCard，底部按钮竖直排列

```java
DingTalkActionCard actionCard = new DingTalkActionCard();
actionCard.setTitle("乔布斯 20 年前想打造一间苹果咖啡厅，而它正是 Apple Store 的前身");
actionCard.setText("![screenshot](https://img.alicdn.com/tfs/TB1NwmBEL9TBuNjy1zbXXXpepXa-2400-1218.png) \n\n #### 乔布斯 20 年前想打造的苹果咖啡厅 \n\n Apple Store 的设计正从原来满满的科技感走向生活化，而其生活化的走向其实可以追溯到 20 年前苹果一个建立咖啡馆的计划");

List<Button> buttons = List.of(new Button("内容不错", "https://www.dingtalk.com/"),
new Button("不感兴趣", "https://www.dingtalk.com/"));
actionCard.setBtns(buttons);
actionCard.setBtnLayout(BtnLayoutEnum.VERTICAL);

dingTalkRobotService.send(actionCard);
```

> 若底部按钮需要横向排列，则将 `btnLayout` 设置为 `HORIZONTAL` 即可，例如：

```java
actionCard.setBtnLayout(BtnLayoutEnum.HORIZONTAL);
```

* 发送FeedCard

```java
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
```

##### 3、多机器人场景

* 在配置文件中配置多个机器人，例如：

```yaml
com:
  ugrong:
    dingtalk:
      robots:
        robot1:
          enable-sign: true
          access-token: 'accessToken1'
          secret: 'secret1'
        robot2:
          enable-sign: true
          access-token: 'accessToken2'
          secret: 'secret2'
```

* 使用 [DingTalkRobotService#send(String robotId, DingTalkMsg msg, DingTalkAt at)](./ding-talk-spring-boot-autoconfigure/src/main/java/com/ugrong/framework/robot/service/DingTalkRobotService.java#L54 "DingTalkRobotService#send(String robotId, DingTalkMsg msg, DingTalkAt at)") 方法：

```java
// 根据自定义的机器人ID将消息发送给指定机器人且@所有人，适用于多机器人场景

dingTalkRobotService.send("robot2", new DingTalkText("测试文本"), new DingTalkAt().atAll());
```

> 注意：若使用之前的方法，它们没有指定机器人ID，所以会使用配置的第一个机器人，即 `robot1`

****

**相关单元测试可以在 [DingTalkRobotTests](./ding-talk-spring-boot-samples/src/test/java/com/ugrong/framework/robot/samples/DingTalkRobotTests.java "DingTalkRobotTests") 类中查看**
