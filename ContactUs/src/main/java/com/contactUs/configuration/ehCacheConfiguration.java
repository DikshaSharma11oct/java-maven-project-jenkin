package com.contactUs.configuration;

import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;


@Configuration
public class ehCacheConfiguration {
    
    @Bean
    CacheManager cacheManager(){
        return new EhCacheCacheManager(ehCacheManager());
    }
    //cacheManger is part of ehcache -> differnet from defined above
    
    private net.sf.ehcache.CacheManager ehCacheManager(){
       EhCacheManagerFactoryBean factoryBean= new EhCacheManagerFactoryBean();
       factoryBean.setConfigLocation(new ClassPathResource("ehCache.xml"));
       factoryBean.setShared(true);
       return factoryBean.getObject();

      // 2. Now make ehcache Xml file


    }
    
}
