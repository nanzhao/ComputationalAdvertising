package com.southwood.ad.index;

import lombok.Getter;

/**
 * Created by nanzhao on 2019/2/10 10:18 PM
 */
@Getter
public enum CommonStatus {

    VALID(1, "有效状态"),
    INVALID(0, "无效状态");

    private Integer status;
    private String desc;

    CommonStatus(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }
}
