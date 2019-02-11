package com.southwood.ad.search;

import com.southwood.ad.search.vo.SearchRequest;
import com.southwood.ad.search.vo.SearchResponse;

/**
 * Created by nanzhao on 2019/2/11 12:53 PM
 */
public interface ISearch {

    SearchResponse fetchAds(SearchRequest request);
}
