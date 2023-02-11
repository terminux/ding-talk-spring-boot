package com.ugrong.framework.robot.service;

import com.ugrong.framework.robot.exception.DingTalkException;
import com.ugrong.framework.robot.model.DingTalkAt;
import com.ugrong.framework.robot.model.DingTalkMsg;

/**
 * 钉钉机器人消息发送服务.
 */
public interface DingTalkRobotService {

    /**
     * 使用配置的第一个机器人发送文本消息.
     *
     * @param content 文本内容
     * @throws DingTalkException the ding talk exception
     */
    void sendText(String content) throws DingTalkException;

    /**
     * 使用配置的第一个机器人发送文本消息且@指定人.
     *
     * @param content 文本内容
     * @param at      要@的人
     * @throws DingTalkException the ding talk exception
     */
    void sendText(String content, DingTalkAt at) throws DingTalkException;

    /**
     * 使用配置的第一个机器人发送消息.
     *
     * @param msg 消息信息
     * @throws DingTalkException the ding talk exception
     */
    void send(DingTalkMsg msg) throws DingTalkException;

    /**
     * 使用配置的第一个机器人发送消息且@指定人.
     *
     * @param msg 消息信息
     * @param at  要@的人
     * @throws DingTalkException the ding talk exception
     */
    void send(DingTalkMsg msg, DingTalkAt at) throws DingTalkException;

    /**
     * 指定机器人发送消息且@指定人（适用于多机器人的场景）.
     *
     * @param robotId 机器人id
     * @param msg     消息信息
     * @param at      要@的人
     * @throws DingTalkException the ding talk exception
     */
    void send(String robotId, DingTalkMsg msg, DingTalkAt at) throws DingTalkException;
}
