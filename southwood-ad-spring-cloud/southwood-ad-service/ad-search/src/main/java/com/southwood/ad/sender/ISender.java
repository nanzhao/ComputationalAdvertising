package com.southwood.ad.sender;

import com.southwood.ad.mysql.dto.MySqlRowData;

/**
 * Created by nanzhao on 2019/2/11 10:57 AM
 */
public interface ISender {

    void sender(MySqlRowData rowData);
}
