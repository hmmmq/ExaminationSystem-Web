package com.foodie.teacher.exception;

import com.foodie.teacher.feignapi.ItemProvider;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class ItemProviderBackFactory implements FallbackFactory<ItemProvider> {

    @Override
    public ItemProvider create(Throwable cause) {
        return null;
    }
}
