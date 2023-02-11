package com.ugrong.framework.robot.service.impl;

import com.ugrong.framework.robot.api.DingTalkApi;
import com.ugrong.framework.robot.enums.DingTalkMsgTypeEnum;
import com.ugrong.framework.robot.exception.DingTalkException;
import com.ugrong.framework.robot.model.*;
import com.ugrong.framework.robot.properties.DingTalkProperties;
import com.ugrong.framework.robot.properties.DingTalkRobotProperties;
import com.ugrong.framework.robot.service.DingTalkRobotService;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class DingTalkRobotServiceImpl implements DingTalkRobotService {

    private final DingTalkProperties dingTalkProperties;

    private final DingTalkApi dingTalkApi;

    public DingTalkRobotServiceImpl(DingTalkProperties dingTalkProperties, DingTalkApi dingTalkApi) {
        this.dingTalkProperties = dingTalkProperties;
        this.dingTalkApi = dingTalkApi;
    }

    @Override
    public void sendText(String content) throws DingTalkException {
        this.sendText(content, null);
    }

    @Override
    public void sendText(String content, DingTalkAt at) throws DingTalkException {
        this.send(new DingTalkText(content), at);
    }

    @Override
    public void send(DingTalkMsg msg) throws DingTalkException {
        this.send(msg, null);
    }

    @Override
    public void send(DingTalkMsg msg, DingTalkAt at) throws DingTalkException {
        send(null, msg, at);
    }

    @Override
    public void send(String robotId, DingTalkMsg msg, DingTalkAt at) throws DingTalkException {
        Map<String, DingTalkRobotProperties> robots = dingTalkProperties.getRobots();
        if (robots == null || robots.isEmpty()) {
            throw new DingTalkException("未配置钉钉机器人.");
        }
        DingTalkRobotProperties robotProperties;
        if (StringUtils.isNotBlank(robotId)) {
            robotProperties = robots.get(robotId);
        } else {
            robotProperties = robots.values().stream().findFirst().orElse(null);
        }
        if (robotProperties == null) {
            throw new DingTalkException(String.format("未找到钉钉机器人配置[%s].", robotId == null ? StringUtils.EMPTY : robotId));
        }
        try {
            DingTalkResponse response = sendMsg(robotProperties, msg, at);
            if (response == null || response.getErrCode() != 0) {
                throw new DingTalkException("钉钉通知发送失败.", response);
            }
        } catch (Exception e) {
            if (e instanceof DingTalkException dte) {
                throw dte;
            }
            throw new DingTalkException(e);
        }
    }

    private DingTalkResponse sendMsg(DingTalkRobotProperties robotProperties, DingTalkMsg msg, DingTalkAt at) throws Exception {
        Map<String, Object> sendMsg = buildMessage(msg, at);
        if (!robotProperties.isEnableSign()) {
            return dingTalkApi.send(robotProperties.getAccessToken(), sendMsg);
        }
        Long timestamp = System.currentTimeMillis();
        return dingTalkApi.send(robotProperties.getAccessToken(), sendMsg, timestamp, sign(robotProperties.getSecret(), timestamp));
    }

    private Map<String, Object> buildMessage(DingTalkMsg msg, DingTalkAt at) {
        Map<String, Object> sendMsg = new HashMap<>();
        putAt(msg, at, sendMsg);
        DingTalkMsgTypeEnum msgType = msg.getMsgType();
        String type = msgType.getValue();
        sendMsg.put("msgtype", type);
        sendMsg.put(type, msg);

        postProcessSendMsg(msg, at, sendMsg);

        return sendMsg;
    }

    protected void postProcessSendMsg(DingTalkMsg msg, DingTalkAt at, Map<String, Object> sendMsg) {
    }

    private void putAt(DingTalkMsg msg, DingTalkAt at, Map<String, Object> sendMsg) {
        DingTalkMsgTypeEnum msgType = msg.getMsgType();
        if (at == null || (msgType != DingTalkMsgTypeEnum.TEXT && msgType != DingTalkMsgTypeEnum.MARKDOWN)) {
            return;
        }
        if (msgType == DingTalkMsgTypeEnum.MARKDOWN) {
            //markdown消息内容content中要带上"@手机号"，跟atMobiles参数结合使用，才有@效果
            String atContent = at.asString();
            if (StringUtils.isNotBlank(atContent)) {
                DingTalkMarkdown markdown = (DingTalkMarkdown) msg;
                markdown.setText(markdown.getText().concat("\n\n").concat(atContent));
            }
        }
        sendMsg.put("at", at);
    }

    private String sign(String secret, Long timestamp) throws Exception {
        Charset charset = StandardCharsets.UTF_8;

        String stringToSign = timestamp + "\n" + secret;
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secret.getBytes(charset), "HmacSHA256"));
        byte[] signData = mac.doFinal(stringToSign.getBytes(charset));
        return URLEncoder.encode(new String(Base64.encodeBase64(signData)), charset);
    }

}
