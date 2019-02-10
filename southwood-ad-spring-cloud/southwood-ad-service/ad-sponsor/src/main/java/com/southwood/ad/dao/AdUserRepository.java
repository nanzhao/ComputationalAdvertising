package com.southwood.ad.dao;

import com.southwood.ad.entity.AdUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nanzhao on 2019/2/10 3:23 PM
 */
public interface AdUserRepository extends JpaRepository<AdUser, Long>{

    /**
     * <h2>根据用户名查找用户记录</h2>
     * */
    AdUser findByUsername(String username);

}
