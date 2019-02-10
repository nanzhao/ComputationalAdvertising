package com.southwood.ad.index;

import lombok.Getter;

/**
 * Created by nanzhao on 2019/2/10 10:17 PM
 */
@Getter
public enum DataLevel {

    LEVEL2("2", "level 2"),
    LEVEL3("3", "level 3"),
    LEVEL4("4", "level 4");

    private String level;
    private String desc;

    DataLevel(String level, String desc) {
        this.level = level;
        this.desc = desc;
    }
}
