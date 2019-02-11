package com.southwood.ad.search.vo.media;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by nanzhao on 2019/2/11 12:56 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class App {

    // 应用编码
    private String appCode;
    // 应用名称
    private String appName;
    // 应用包名
    private String packageName;
    // activity 名称
    private String activityName;
}
