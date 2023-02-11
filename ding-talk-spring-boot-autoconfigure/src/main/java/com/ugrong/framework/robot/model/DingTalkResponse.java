package com.ugrong.framework.robot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Ding talk response.
 */
public class DingTalkResponse {

    /**
     * 返回码
     */
    @JsonProperty("errcode")
    private int errCode;

    /**
     * 对返回码的文本描述内容
     */
    @JsonProperty("errmsg")
    private String errMsg;

    /**
     * Gets err code.
     *
     * @return the err code
     */
    public int getErrCode() {
        return errCode;
    }

    /**
     * Sets err code.
     *
     * @param errCode the err code
     */
    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    /**
     * Gets err msg.
     *
     * @return the err msg
     */
    public String getErrMsg() {
        return errMsg;
    }

    /**
     * Sets err msg.
     *
     * @param errMsg the err msg
     */
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "DingTalkResponse{" +
                "errCode=" + errCode +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
