package com.southwood.ad.service;

import com.southwood.ad.entity.AdPlan;
import com.southwood.ad.exception.AdException;
import com.southwood.ad.vo.AdPlanGetRequest;
import com.southwood.ad.vo.AdPlanRequest;
import com.southwood.ad.vo.AdPlanResponse;

import java.util.List;

/**
 * Created by nanzhao on 2019/2/10 4:16 PM
 */
public interface IAdPlanService {
    /**
     * <h2>创建推广计划</h2>
     * */
    AdPlanResponse createAdPlan(AdPlanRequest request) throws AdException;

    /**
     * <h2>获取推广计划</h2>
     * */
    List<AdPlan> getAdPlanByIds(AdPlanGetRequest request) throws AdException;

    /**
     * <h2>更新推广计划</h2>
     * */
    AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException;

    /**
     * <h2>删除推广计划</h2>
     * */
    void deleteAdPlan(AdPlanRequest request) throws AdException;
}
