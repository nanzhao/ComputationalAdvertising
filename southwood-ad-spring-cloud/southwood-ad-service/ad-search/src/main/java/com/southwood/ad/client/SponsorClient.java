package com.southwood.ad.client;

import com.southwood.ad.client.vo.AdPlan;
import com.southwood.ad.client.vo.AdPlanGetRequest;
import com.southwood.ad.vo.CommonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by nanzhao on 2019/2/10 9:01 PM
 */
@FeignClient(value = "eureka-client-ad-sponsor",
        fallback = SponsorClientHystrix.class)
//value 指向调用微服务的名称，fallback指向服务降级的方法
public interface SponsorClient {
    @RequestMapping(value = "/ad-sponsor/get/adPlan",
            method = RequestMethod.POST) //vaule指向调用的微服务的哪个方法
    CommonResponse<List<AdPlan>> getAdPlans(
            @RequestBody AdPlanGetRequest request);
}
