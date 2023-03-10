package com.ugrong.framework.robot.properties;

public class DingTalkRobotProperties {

    /**
     * 机器人accessToken
     */
    private String accessToken;

    /**
     * 安全策略是否启用了加签
     */
    private boolean enableSign;

    /**
     * 用于验签的secret，若没有启用加签则不需要设置
     */
    private String secret;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public boolean isEnableSign() {
        return enableSign;
    }

    public void setEnableSign(boolean enableSign) {
        this.enableSign = enableSign;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
