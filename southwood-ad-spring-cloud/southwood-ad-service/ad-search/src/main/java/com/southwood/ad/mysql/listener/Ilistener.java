package com.southwood.ad.mysql.listener;

import com.southwood.ad.mysql.dto.BinlogRowData;

/**
 * Created by nanzhao on 2019/2/11 10:36 AM
 */
public interface Ilistener {

    void register();

    void onEvent(BinlogRowData eventData);
}
