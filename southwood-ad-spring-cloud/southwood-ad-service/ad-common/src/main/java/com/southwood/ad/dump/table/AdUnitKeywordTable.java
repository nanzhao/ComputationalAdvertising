package com.southwood.ad.dump.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by nanzhao on 2019/2/10 10:28 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdUnitKeywordTable {

    private Long unitId;
    private String keyword;
}
