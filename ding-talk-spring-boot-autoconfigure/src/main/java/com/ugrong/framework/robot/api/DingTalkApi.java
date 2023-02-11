package com.ugrong.framework.robot.api;

import com.ugrong.framework.robot.model.DingTalkResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.PostExchange;

import java.util.Map;

/**
 * The interface Ding talk api.
 */
public interface DingTalkApi {

    /**
     * 发送钉钉机器人通知，用于非加签场景
     *
     * @param accessToken the access token
     * @param msg         the msg
     * @return the ding talk response
     */
    @PostExchange("/robot/send")
    DingTalkResponse send(@RequestParam("access_token") String accessToken, @RequestBody Map<String, Object> msg);

    /**
     * 发送钉钉机器人通知，用于加签场景
     *
     * @param accessToken the access token
     * @param msg         the msg
     * @param timestamp   the timestamp
     * @param sign        the sign
     * @return the ding talk response
     */
    @PostExchange("/robot/send")
    DingTalkResponse send(@RequestParam("access_token") String accessToken, @RequestBody Map<String, Object> msg,
                          @RequestParam("timestamp") Long timestamp, @RequestParam("sign") String sign);
}
