package com.southwood.ad.service;

import com.southwood.ad.vo.CreativeRequest;
import com.southwood.ad.vo.CreativeResponse;

/**
 * Created by nanzhao on 2019/2/10 4:14 PM
 */
public interface ICreativeService {
    CreativeResponse createCreative(CreativeRequest request);
}
