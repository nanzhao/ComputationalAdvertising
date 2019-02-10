package com.southwood.ad.constant;

import lombok.Getter;

/**
 * Created by nanzhao on 2019/2/10 11:44 AM
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
