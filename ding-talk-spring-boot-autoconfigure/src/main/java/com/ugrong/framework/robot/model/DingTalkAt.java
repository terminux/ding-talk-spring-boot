package com.ugrong.framework.robot.model;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

/**
 * 要@的人
 */
public class DingTalkAt {

    /**
     * 被@人的手机号
     */
    private String[] atMobiles;

    /**
     * 被@人的用户userid
     */
    private String[] atUserIds;

    /**
     * 是否@所有人
     */
    private boolean isAtAll = false;

    /**
     * At mobiles ding talk at.
     *
     * @param atMobiles the at mobiles
     * @return the ding talk at
     */
    public DingTalkAt atMobiles(String... atMobiles) {
        this.atMobiles = atMobiles;
        return this;
    }

    /**
     * At user ids ding talk at.
     *
     * @param atUserIds the at user ids
     * @return the ding talk at
     */
    public DingTalkAt atUserIds(String... atUserIds) {
        this.atUserIds = atUserIds;
        return this;
    }

    /**
     * At all ding talk at.
     *
     * @return the ding talk at
     */
    public DingTalkAt atAll() {
        this.isAtAll = true;
        return this;
    }

    /**
     * Get at mobiles string [ ].
     *
     * @return the string [ ]
     */
    public String[] getAtMobiles() {
        return atMobiles;
    }

    /**
     * Get at user ids string [ ].
     *
     * @return the string [ ]
     */
    public String[] getAtUserIds() {
        return atUserIds;
    }

    /**
     * Gets is at all.
     *
     * @return the is at all
     */
    public boolean getIsAtAll() {
        return isAtAll;
    }

    /**
     * As string string.
     *
     * @return the string
     */
    public String asString() {
        List<String> atList = new ArrayList<>();
        if (ArrayUtils.isNotEmpty(atMobiles)) {
            atList.addAll(List.of(atMobiles));
        }
        if (ArrayUtils.isNotEmpty(atUserIds)) {
            atList.addAll(List.of(atUserIds));
        }
        if (atList.isEmpty()) {
            return null;
        }
        return atList.stream().map("@"::concat).collect(joining(StringUtils.SPACE));
    }

    @Override
    public String toString() {
        return "DingTalkAt{" +
                "atMobiles=" + Arrays.toString(atMobiles) +
                ", atUserIds=" + Arrays.toString(atUserIds) +
                ", isAtAll=" + isAtAll +
                '}';
    }
}
