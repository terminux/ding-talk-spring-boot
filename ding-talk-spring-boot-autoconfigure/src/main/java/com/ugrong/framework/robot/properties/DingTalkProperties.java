package com.ugrong.framework.robot.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * The type Ding talk properties.
 */
@ConfigurationProperties("com.ugrong.dingtalk")
public class DingTalkProperties {

    /**
     * 是否启用钉钉通知，默认启用
     */
    private boolean enabled = true;

    /**
     * 钉钉接口URL
     */
    private String url = "https://oapi.dingtalk.com";

    /**
     * 钉钉机器人配置信息
     */
    private Map<String, DingTalkRobotProperties> robots;

    /**
     * Is enabled boolean.
     *
     * @return the boolean
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets enabled.
     *
     * @param enabled the enabled
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets url.
     *
     * @param url the url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets robots.
     *
     * @return the robots
     */
    public Map<String, DingTalkRobotProperties> getRobots() {
        return robots;
    }

    /**
     * Sets robots.
     *
     * @param robots the robots
     */
    public void setRobots(Map<String, DingTalkRobotProperties> robots) {
        this.robots = robots;
    }
}
