package com.southwood.ad.mysql.constant;

import com.github.shyiko.mysql.binlog.event.EventType;
import com.oracle.javafx.jmx.json.JSONReader;

/**
 * Created by nanzhao on 2019/2/11 10:00 AM
 */
public enum OpType {

    ADD,
    UPDATE,
    DELETE,
    OTHER;

    public static OpType to(EventType eventType) {

        switch (eventType) {
            case EXT_WRITE_ROWS:
                return ADD;
            case EXT_UPDATE_ROWS:
                return UPDATE;
            case EXT_DELETE_ROWS:
                return DELETE;

            default:
                return OTHER;
        }
    }
}
