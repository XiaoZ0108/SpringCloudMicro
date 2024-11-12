package com.example.Order.client;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "inventory",url="http://localhost:8082")
//@FeignClient(name = "inventory-service")
public interface InventoryClient {
    Logger log= LoggerFactory.getLogger(InventoryClient.class);

    @GetMapping(value = "/api/inventory")
    @Retry(name="inventory")
    @CircuitBreaker(name="inventory",fallbackMethod = "fallbackMethod")
    //@TimeLimiter()
    boolean isInStock(@RequestParam String skuCode,@RequestParam Integer quantity);

    default boolean fallbackMethod(String code,Integer quantity,Throwable throwable){
        log.info("Unable get inventory for skucode {},reason: {}",code,throwable.getMessage());
        return false;
    }
}
