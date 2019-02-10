package com.southwood.ad.index;

/**
 * Created by nanzhao on 2019/2/10 9:23 PM
 */
public interface IndexAware<K, V> {

    V get(K key);

    void add(K key, V value);

    void update(K key, V value);

    void delete(K key, V value);
}
