package com.southwood.ad.service.impl;

import com.southwood.ad.dao.CreativeRepository;
import com.southwood.ad.entity.Creative;
import com.southwood.ad.service.ICreativeService;
import com.southwood.ad.vo.CreativeRequest;
import com.southwood.ad.vo.CreativeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nanzhao on 2019/2/10 4:35 PM
 */
@Service
public class CreativeServiceImpl implements ICreativeService {

    private final CreativeRepository creativeRepository;

    @Autowired
    public CreativeServiceImpl(CreativeRepository creativeRepository) {
        this.creativeRepository = creativeRepository;
    }

    @Override
    public CreativeResponse createCreative(CreativeRequest request) {

        Creative creative = creativeRepository.save(
                request.convertToEntity()
        );

        return new CreativeResponse(creative.getId(), creative.getName());
    }
}
