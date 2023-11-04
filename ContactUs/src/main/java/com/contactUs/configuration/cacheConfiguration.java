package com.contactUs.configuration;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Configuration;

//in boot cache example
@Configuration
public class cacheConfiguration {

    CacheManagerCustomizer<ConcurrentMapCacheManager> customizer(){
        return new ConcurentCustomizer(); 
            
    }

    class ConcurentCustomizer implements CacheManagerCustomizer<ConcurrentMapCacheManager>{

        @Override
        public void customize(ConcurrentMapCacheManager cacheManager) {
           //null is allowed by default it's true    
           cacheManager.setAllowNullValues(false);
           //Whatever object you rae trying to store in cache that should be serilizable
           cacheManager.setStoreByValue(true);
           System.out.println("customizer invoked");
        }
        
    }
    
}
