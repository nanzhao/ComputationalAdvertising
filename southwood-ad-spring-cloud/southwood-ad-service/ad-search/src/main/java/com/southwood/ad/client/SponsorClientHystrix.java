package com.southwood.ad.client;

import com.southwood.ad.client.vo.AdPlan;
import com.southwood.ad.client.vo.AdPlanGetRequest;
import com.southwood.ad.vo.CommonResponse;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by nanzhao on 2019/2/10 9:06 PM
 */
@Component
public class SponsorClientHystrix implements SponsorClient {

    //一旦出现错误之后，服务就会降级，然后使用的就是这个服务了
    @Override
    public CommonResponse<List<AdPlan>> getAdPlans(
            AdPlanGetRequest request) {
        return new CommonResponse<>(-1,
                "eureka-client-ad-sponsor error");
    }
}
