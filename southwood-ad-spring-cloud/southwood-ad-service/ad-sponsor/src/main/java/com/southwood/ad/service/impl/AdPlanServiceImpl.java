package com.southwood.ad.service.impl;

import com.southwood.ad.constant.CommonStatus;
import com.southwood.ad.constant.Constants;
import com.southwood.ad.dao.AdPlanRepository;
import com.southwood.ad.dao.AdUserRepository;
import com.southwood.ad.entity.AdPlan;
import com.southwood.ad.entity.AdUser;
import com.southwood.ad.exception.AdException;
import com.southwood.ad.service.IAdPlanService;
import com.southwood.ad.utils.CommonUtils;
import com.southwood.ad.vo.AdPlanGetRequest;
import com.southwood.ad.vo.AdPlanRequest;
import com.southwood.ad.vo.AdPlanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by nanzhao on 2019/2/10 4:42 PM
 */
@Service
public class AdPlanServiceImpl implements IAdPlanService {

    private final AdUserRepository userRepository;
    private final AdPlanRepository planRepository;

    @Autowired
    public AdPlanServiceImpl(AdUserRepository userRepository,
                             AdPlanRepository planRepository) {
        this.userRepository = userRepository;
        this.planRepository = planRepository;
    }

    @Override
    @Transactional
    public AdPlanResponse createAdPlan(AdPlanRequest request)
            throws AdException {

        if (!request.createValidate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        // 确保关联的 User 是存在的
        Optional<AdUser> adUser =
                userRepository.findById(request.getUserId());
        if (!adUser.isPresent()) {
            throw new AdException(Constants.ErrorMsg.CAN_NOT_FIND_RECORD);
        }

        AdPlan oldPlan = planRepository.findByUserIdAndPlanName(
                request.getUserId(), request.getPlanName()
        );
        if (oldPlan != null) {
            throw new AdException(Constants.ErrorMsg.SAME_NAME_PLAN_ERROR);
        }

        AdPlan newAdPlan = planRepository.save(
                new AdPlan(request.getUserId(), request.getPlanName(),
                        CommonUtils.parseStringDate(request.getStartDate()),
                        CommonUtils.parseStringDate(request.getEndDate())
                )
        );

        return new AdPlanResponse(newAdPlan.getId(),
                newAdPlan.getPlanName());
    }

    @Override
    public List<AdPlan> getAdPlanByIds(AdPlanGetRequest request)
            throws AdException {

        if (!request.validate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        return planRepository.findAllByIdInAndUserId(
                request.getIds(), request.getUserId()
        );
    }

    @Override
    @Transactional
    public AdPlanResponse updateAdPlan(AdPlanRequest request)
            throws AdException {

        if (!request.updateValidate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        AdPlan plan = planRepository.findByIdAndUserId(
                request.getId(), request.getUserId()
        );
        if (plan == null) {
            throw new AdException(Constants.ErrorMsg.CAN_NOT_FIND_RECORD);
        }

        if (request.getPlanName() != null) {
            plan.setPlanName(request.getPlanName());
        }
        if (request.getStartDate() != null) {
            plan.setStartDate(
                    CommonUtils.parseStringDate(request.getStartDate())
            );
        }
        if (request.getEndDate() != null) {
            plan.setEndDate(
                    CommonUtils.parseStringDate(request.getEndDate())
            );
        }

        plan.setUpdateTime(new Date());
        plan = planRepository.save(plan);

        return new AdPlanResponse(plan.getId(), plan.getPlanName());
    }

    @Override
    @Transactional
    public void deleteAdPlan(AdPlanRequest request) throws AdException {

        if (!request.deleteValidate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        AdPlan plan = planRepository.findByIdAndUserId(
                request.getId(), request.getUserId()
        );
        if (plan == null) {
            throw new AdException(Constants.ErrorMsg.CAN_NOT_FIND_RECORD);
        }

        plan.setPlanStatus(CommonStatus.INVALID.getStatus());
        plan.setUpdateTime(new Date());
        planRepository.save(plan);
    }
}
